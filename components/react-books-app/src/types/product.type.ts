export default interface IProductData {
  id?: any | null,
  barcode_number: string,
  product_name: string,
  product_description: string,
  unit_of_measure: number,
  unit_of_measure_label: string,
  measure: number,
  department_id: bigint,
  meal_id: bigint,
  meal_category_id: bigint,
  meal_sub_category_id: bigint,
  manufacturer_name: string,
  image_file_name: string,
  full_path_image_file_name: string,
  store_id: bigint,
  list_prize: number,
  selling_prize: number,
  prize_registry_insert_datetime: string,
  prize_registry_point_of_sale_id: bigint,
  brand_name: string,
  logo_image_file_name: string

}