package com.price.low.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.price.low.response.model.ProductRecord;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class ProductDetailsWWWFinderService {

	public static final Logger logger = LoggerFactory.getLogger(ProductDetailsWWWFinderService.class);

	public ProductRecord findByBarcode(String barcode) {

		logger.info("findByBarcode - START with barcode: {}", barcode);
		Document doc;
		try {
			doc = Jsoup.connect("https://it.openfoodfacts.org/product/"+barcode).get();
			logger.info(doc.title());
			Elements newsHeadlines = doc.select("#mp-itn b a");
			for (Element headline : newsHeadlines) {
				logger.info("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("findByBarcode - END");
		return null;
	}

}
