
import * as Environment from './env.js';



export const UNITS_OF_MEASURE_API     = Environment.BACKEND_API_PREFIX + '/api/unitOfMeasures'    ;
export const DEPARTMENTS_API     = Environment.BACKEND_API_PREFIX + '/api/departments'    ;
export const MEALS_API     = Environment.BACKEND_API_PREFIX + '/api/meals'    ;
export const MEAL_CATEGORIES_API      = '/api/mealCategories'    ;
export const MEAL_CATEGORIES_FULL_API = Environment.BACKEND_API_PREFIX + '/api/mealCategories'    ;

export const MEAL_SUB_CATEGORIES_API = '/api/mealSubCategories' ;
export const MEAL_SUB_CATEGORIES_FULL_API = Environment.BACKEND_API_PREFIX + MEAL_SUB_CATEGORIES_API ;
export const PRODUCTS_API = Environment.BACKEND_API_PREFIX + '/api/products' ;

export const FULL_PRODUCTS_API = Environment.BACKEND_API_PREFIX + '/api/v1/products/' ;
export const FULL_STORES_API = Environment.BACKEND_API_PREFIX + '/api/v1/stores/' ;
export const CUSTOM_BARCODE_API = Environment.BACKEND_API_PREFIX + '/api/v1/barcode/' ;

