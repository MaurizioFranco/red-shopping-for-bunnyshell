import http from "../http-common";
import IProductData from "../types/product.type"

class ProductDataService {
  getAll() {
    return http.get<Array<IProductData>>("/api/v1/products/");
  }

  create(data: IProductData) {
    return http.post<IProductData>("/api/v1/products/", data);
  }
/*
  get(id: string) {
    return http.get<IProductData>(`/books/${id}`);
  }


  update(data: IProductData, id: any) {
    return http.put<any>(`/books/${id}`, data);
  }

  delete(id: any) {
    return http.delete<any>(`/books/${id}`);
  }

  deleteAll() {
    return http.delete<any>(`/books`);
  }

  findByTitle(title: string) {
    return http.get<Array<IProductData>>(`/books?title=${title}`);
  }
  */
}

export default new ProductDataService();