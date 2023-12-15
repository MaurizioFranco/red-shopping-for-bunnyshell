package com.price.low.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.price.low.entity.PriceRegistry;
import com.price.low.entity.Product;
import com.price.low.repository.ProductRepository;
import com.price.low.repository.custom.ProductRecordRepository;
import com.price.low.request.model.ProductCustomRequest;
import com.price.low.response.model.ProductRecord;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class FullProductRegistryService {

	public static final Logger logger = LoggerFactory.getLogger(FullProductRegistryService.class);

	@Value("${app.folder.products.img}")
	public String IMG_DIR;
	
	@Autowired
	private ProductRecordRepository productRecordRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private PriceRegistryService prizeRegistryService;
	@Autowired
	private ProductDetailsWWWFinderService productDetailsWWWFinderService;

	/**
	 * Provides list of ProductRecord from repository
	 * 
	 * @return List<ProductRecord>
	 */
	public List<ProductRecord> getAll() {
		logger.info("getAll - START");
		List<ProductRecord> items = productRecordRepository.findAllProducts();
		logger.info("getAll - END - returning " + items.size() + " ProductRecord.");
		return items;
	}
	
	/**
	 * Provides ProductRecord for barcode received...
	 * It provides to search into local database and if it doesn't exists provides to call external api
	 * 
	 * @return ProductRecord
	 */
	public Optional<ProductRecord> getByBarcode(String barcode) {
		logger.info("getByBarcode - START with barcode: {}", barcode);
//		Optional<ProductRecord> optionalItem = Optional.ofNullable(productRecordRepository.findByBarcode(barcode));
		Optional<ProductRecord> optionalItem ;
		try {
			logger.info("getByBarcode - DEBUG - looking for product in internal database: {}", barcode);
			optionalItem = Optional.ofNullable(productRecordRepository.findByBarcode(barcode));
			logger.info("getByBarcode - DEBUG - looking for product in internal database: {}, found: {}", barcode, optionalItem.isPresent());
		} catch (Exception e) {
			logger.error("getByBarcode - ERROR in looking for product with barcode: {}, NO PRODUCT WITH THIS BARCODE IN OUR DATABASE.", barcode);
			e.printStackTrace();
			optionalItem = Optional.ofNullable(null);
		}
		if (optionalItem.isEmpty()) {
			optionalItem = Optional.ofNullable(productDetailsWWWFinderService.findByBarcode(barcode));
			logger.info("getByBarcode - END - returning from www.... found something: {}", optionalItem.isPresent());
			return optionalItem;
		} else {
			logger.info("getByBarcode - END - returning from internal research... found something: {}", optionalItem.isPresent());
			return optionalItem;			
		}
	}
	
	/**
	 * Provides to insert new product and current selling price
	 * 
	 * @param ProductCustomRequest
	 * @return
	 */
	public Product insert (ProductCustomRequest request) {
		logger.info("insert - START - with ProductCustomRequest {}", request);
		
		Product productToInsert = new Product (null, 
				request.getBarcode_number(),
				request.getProduct_name(),
				request.getProduct_description(),
				request.getUnit_of_measure(),
				request.getMeasure(),
				request.getDepartment_id(),
				request.getMeal_category_id(),
				request.getMeal_sub_category_id(),
				request.getManufacturer_name(),
				null
				) ;

		if (request.getFiles() != null) {

			try {
				logger.info("insert - DEBUG - inserting product image file");
				String imgFileName = uploadFile(request.getFiles()[0], buildNewFileName(request.getBarcode_number()+""));
				logger.info("createNewCandidate - DEBUG - imgFileName:" + imgFileName);
				productToInsert.setImage_file_name(imgFileName);
			} catch (Exception e) {
				logger.error("Error", e);
			}

		}
		
		Product insertedProduct = productRepository.saveAndFlush(productToInsert);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(request.getProduct_insert_datetime(), formatter);
		logger.info("insert - DEBUG - with dateTime: {}", dateTime);
		
		PriceRegistry prizeRegistryToInsert = new PriceRegistry (null,
				                               insertedProduct.getId(),
				                               request.getSelling_prize(),
				                               request.getList_prize(),
				                               dateTime,
				                               request.getStore_id()) ; 
		
		prizeRegistryService.insertPriceRegistryEntity(prizeRegistryToInsert);
		
//		ProductRecord objToReturn = new ProductRecord (null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null,
//				null               
//				) ;
		return insertedProduct ;

	}
	
	private String uploadFile (MultipartFile file, String imageFileName) throws IOException {
		logger.info("uploadFile - START");
		String fileNameToReturn = null ;
		String uploadFilePath = null;
		logger.info("uploadFile - DEBUG 2 - file.getOriginalFilename(): " + file.getOriginalFilename());
		String extension = new String(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1));
		String fileName = file.getOriginalFilename();
		logger.info("uploadFile - DEBUG 2.5 - extension: " + extension);
		fileNameToReturn = imageFileName + "." + extension;
		uploadFilePath = File.separatorChar + fileNameToReturn;
		if ((fileName.endsWith("jpg"))||(fileName.endsWith("jpeg"))||(fileName.endsWith("png"))||
				(fileName.endsWith("gif")) ){
			uploadFilePath = IMG_DIR + uploadFilePath ;
		}
		logger.info("uploadFile - DEBUG 3 - uploadFilePath: " + uploadFilePath);
		byte[] bytes = file.getBytes();
		logger.info("uploadFile - DEBUG 3.5 - bytes.length: " + bytes.length);
		FileOutputStream fos = new FileOutputStream(uploadFilePath);
		fos.write(bytes);
        fos.close();
		logger.info("uploadFile - END - fileNameToReturn: {}", fileNameToReturn);
		return fileNameToReturn;
	}
	
	private String buildNewFileName (String email) {
		String returnName = email ;
		returnName = returnName.hashCode() + "-" + new Random().nextInt();
		return returnName ;
	}

}
