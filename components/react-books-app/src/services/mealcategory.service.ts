import http from "../http-common";
// import IProductData from "../types/product.type"
import * as Constants from "../constants.js";

class MealCategoryDataService {
  getAll() {
    // return http.get<Array<IProductData>>("/api/v1/products/");
    return http.get<Array<any>>(Constants.MEAL_CATEGORIES_API);
  }
}

export default new MealCategoryDataService();