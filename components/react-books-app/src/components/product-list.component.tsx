import { Component, ChangeEvent } from "react";
import * as Constants from "../constants.js";
import ProductDataService from "../services/product.service";
import MealCategoryDataService from "../services/mealcategory.service.js";
import { Link } from "react-router-dom";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import IProductData from '../types/product.type';
import nobooks from '../assets/nobooks.png';

type Props = {};

type State = {
  mealCategoriesFromApi: Array<any>,
  selectedMealCategoryId: number,
  mealSubCategoriesFromApi: Array<any>,
  defaultMealSubCategories: Array<any>,
  selectedMealSubCategoryId: number,
  mealSubCategoriesList: Array<any>,
  productsFromApi: Array<any>,
  filteredProductsList: Array<any>,
  mealCategoriesList: Array<any>,
  defaultMealCategories: Array<any>,
  filteredProductsForList: Array<any>,



  items: Array<IProductData>,
  currentProduct: IProductData | null,
  currentIndex: number,
  searchTitle: string
};

export default class ProductList extends Component<Props, State>{
  constructor(props: Props) {
    super(props);
    this.onChangeSearchTitle = this.onChangeSearchTitle.bind(this);
    this.retrieveProducts = this.retrieveProducts.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActiveProduct = this.setActiveProduct.bind(this);
    this.removeAllProducts = this.removeAllProducts.bind(this);
    this.searchByTitle = this.searchByTitle.bind(this);

    this.state = {
      mealCategoriesFromApi: [],
      selectedMealCategoryId: 0,
      mealSubCategoriesFromApi: [],
      defaultMealCategories: [
        { id: 0, label: "Seleziona una categoria di prodotto" },
      ],
      defaultMealSubCategories: [
        {
          id: 0,
          label:
            "Seleziona una categoria specifica di prodotto, per categoria scelta",
        },
      ],
      selectedMealSubCategoryId: 0,
      mealSubCategoriesList: [],
      productsFromApi: [],
      filteredProductsList: [],
      mealCategoriesList: [],
      filteredProductsForList: [],
      // items: [
      //   {id: 1,title: 'How to train 1', description: 'Hiccup aspires to follow his tribe\'s tradition of becoming a dragon slayer.', available: true}, 
      //   {id: 2,title: 'How to train 2', description: 'Usodas red novlas to follow his tribe', available: true}, 
      //   {id: 3,title: 'How to train 3', description: 'DesOpdes coma reto cription', available: true}
      // ],
      items: [],
      currentProduct: null,
      currentIndex: 0,
      searchTitle: ''
    };
  }

  componentDidMount() {
    this.fetchMealCategories();
    this.fetchMealSubCategories();
    this.retrieveProducts();
  }

  onChangeSearchTitle(e: ChangeEvent<HTMLInputElement>) {
    const searchTitle = e.target.value;

    this.setState({
      searchTitle: searchTitle
    });
  }

  fetchMealCategories = () => {
    fetch(Constants.MEAL_CATEGORIES_FULL_API)
      .then((response) =>
        response
          .json()
          .then((data) => ({ status: response.status, body: data }))
      )
      .then((data) => {
        let fetchedMealCategoriesFromApi = data.body._embedded.mealCategories;
        this.setState({ mealCategoriesFromApi: fetchedMealCategoriesFromApi });
        this.prepareMealCategoriesListForSelect();
      });
  };

  prepareMealCategoriesListForSelect = () => {
    let fetchedMealCategoriesFromApi = [...this.state.mealCategoriesFromApi];
    let defaultMealCategories = [...this.state.defaultMealCategories];
    //console.log(defaultMealCategories);
    //console.log(fetchedMealCategoriesFromApi);
    let mealCategoriesListForSelect = defaultMealCategories.concat(
      fetchedMealCategoriesFromApi
    );
    this.setState({ mealCategoriesList: mealCategoriesListForSelect });
  };

  fetchMealSubCategories = () => {
    fetch(Constants.MEAL_SUB_CATEGORIES_FULL_API)
      .then((response) =>
        response
          .json()
          .then((data) => ({ status: response.status, body: data }))
      )
      .then((data) => {
        let fetchedMealSubCategoriesFromApi =
          data.body._embedded.mealSubCategories;
        this.setState({
          mealSubCategoriesFromApi: fetchedMealSubCategoriesFromApi,
        });
        //this.prepareMealSubCategoriesListForSelect(fetchedMealSubCategoriesFromApi);
        this.prepareMealSubCategoriesListForSelect();
      });
  };


  retrieveProducts() {
    ProductDataService.getAll()
      .then((response: any) => {
        this.setState({
          items: response.data,
          productsFromApi: response.data
        }
        );
        this.updatedFilteredProductsList();
        console.log(response.data);
      })
      .catch((e: Error) => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrieveProducts();
    this.setState({
      currentProduct: null,
      currentIndex: -1
    });
  }

  setActiveProduct(book: IProductData, index: number) {
    this.setState({
      currentProduct: book,
      currentIndex: index
    }, 
    );
    console.log(index + " - " + this.state.currentIndex);
  }

  removeAllProducts() {
    // ProductDataService.deleteAll()
    //   .then((response: any) => {
    //     console.log(response.data);
    //     toast.success("All items removed!");
    //     this.refreshList();
    //   })
    //   .catch((e: Error) => {
    //     console.log(e);
    //   });
    console.log("removeAllProducts")

  }

  searchByTitle() {
    console.log("searchByTitle")
    // this.setState({
    //   currentProduct: null,
    //   currentIndex: -1
    // });

    // ProductDataService.findByTitle(this.state.searchTitle)
    //   .then((response: any) => {
    //     this.setState({
    //       items: response.data
    //     });
    //     console.log(response.data);
    //   })
    //   .catch((e: Error) => {
    //     console.log(e);
    //   });
  }

  handleMealCategoryChange = (data: any) => {
    // console.log(data.target.value);
    this.setState(
      { selectedMealCategoryId: parseInt(data.target.value) },
      () => {
        this.prepareMealSubCategoriesListForSelect();
        this.updatedFilteredProductsList();
      }
    );
  };

  prepareMealSubCategoriesListForSelect = () => {
    // console.log("prepareMealSubCategoriesListForSelect.START");
    let fetchedMealSubCategoriesFromApi = [
      ...this.state.mealSubCategoriesFromApi,
    ];
    let defaultMealSubCategories = [...this.state.defaultMealSubCategories];
    // console.log(defaultMealSubCategories.length);
    // console.log(fetchedMealSubCategoriesFromApi);
    // console.log(this.state.selectedMealCategoryId === 0);
    const selectedMealCategoryId = this.state.selectedMealCategoryId;
    let mealSubCategoriesListForSelect = defaultMealSubCategories.concat(
      fetchedMealSubCategoriesFromApi.filter(
        (mealSubCategory) =>
          selectedMealCategoryId === 0 ||
          mealSubCategory.meal_category_id === selectedMealCategoryId
      )
    );
    // console.log(mealSubCategoriesListForSelect.length);
    this.setState({ mealSubCategoriesList: mealSubCategoriesListForSelect });
  };

  handleMealSubCategoryChange = (data: any) => {
    // console.log(data.target.value);
    this.setState(
      { selectedMealSubCategoryId: parseInt(data.target.value) },
      () => {
        //this.prepareMealSubCategoriesListForSelect();
        this.updatedFilteredProductsList();
      }
    );
  };

  updatedFilteredProductsList = () => {
    console.log("updatedFilteredProductsList - START");
    let productsFromApi = [...this.state.productsFromApi];
    let filteredProductsForList = productsFromApi.filter(
      (product) =>
        (this.state.selectedMealCategoryId === 0 ||
        product.meal_category_id === this.state.selectedMealCategoryId) 
        &&
        (this.state.selectedMealSubCategoryId === 0 ||
            product.meal_sub_category_id === this.state.selectedMealSubCategoryId)
        
    );
    console.log("updatedFilteredProductsList - DEBUG - filteredProductsForList.length: " + filteredProductsForList.length);
    const filteredProductsList = filteredProductsForList.map((product) => (
      <li key={product.id}>
        <img
          src={"./images/products/" + product.image_file_name}
          alt={product.product_name}
          width="50"
          height="50"
        />{" "}
        - {product.product_name}
        - 
        <img
          src={"./images/brand/" + product.logo_image_file_name}
          alt={product.brand_name}
          width="30"
          height="30"
        />
        - {product.unit_of_measure_label}.
         {product.measure}
        - € {product.list_prize}
        {product.unit_of_measure===2?(" - €"+(product.list_prize*1000/product.measure).toFixed(2)+"/kg"):""}
      </li>
    ));
    this.setState({ filteredProductsList: filteredProductsList });


    this.setState({ filteredProductsForList: filteredProductsForList });
    // console.log("updatedFilteredProductsList - END");
  };

  render() {
    const { searchTitle, items, currentProduct, currentIndex, filteredProductsForList } = this.state;

    return (
      <div className="list">
        {currentProduct ? (<div className="col-md-12 mb-5">
            <div className="row books-row">
              <div className="col-3">
                {/* <div className="cover"/> */}

                <div >
                        <img
                          src={"./images/products/" + currentProduct.image_file_name}
                          alt={currentProduct.product_name}
                          width="50"
                          height="50"
                          // className="col-3"
                        />
                  </div>

              </div>
              <div className="col-9">
              {/* <h4>Product</h4> */}
              {/* <div>
                <label>
                  <strong>Barcode:</strong>
                </label>{" "}
                {currentProduct.barcode_number}
              </div> */}
              <div>
                <label>
                  <strong>Product Name:</strong>
                </label>{" "}
                {currentProduct.product_name}
              </div>
              <div>
                <label>
                  <strong>Description:</strong>
                </label>{" "}
                {currentProduct.product_description}
              </div>
              </div>
            </div>
        </div>
        ) : ( '' )}
        <div className="row">
          <div className="col-sm-12"><h4>Lista prodotti</h4></div>
        </div>
        <div className="row">
          <div className="col-sm-12">
            <div className="input-group mb-3">
              <input
                type="text"
                className="form-control"
                placeholder="Ricerca per nome del prodotto"
                value={searchTitle}
                onChange={this.onChangeSearchTitle}
              />
              <div className="input-group-append">
                <button
                  className="btn search-btn btn-outline-secondary"
                  type="button"
                  onClick={this.searchByTitle}
                >
                  CERCA
                </button>
              </div>
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col-sm-12">
            <div className="input-group mb-3">
                <select
                  className="form-control"
                  name="selectedMealCategory"
                  onChange={this.handleMealCategoryChange}
                >
                  {this.state.mealCategoriesList.map((mealCategory) => (
                    <option key={mealCategory.id} value={mealCategory.id}>
                      {mealCategory.label}
                    </option>
                  ))}
                </select>
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col-sm-12">
            <div className="input-group mb-3">
                <select
                  className="form-control"
                  name="selectedMealSubCategory"
                  onChange={this.handleMealSubCategoryChange}
                >
                  {this.state.mealSubCategoriesList.map((mealSubCategory) => (
                    <option key={mealSubCategory.id} value={mealSubCategory.id}>
                      {mealSubCategory.label}
                    </option>
                  ))}
                </select>
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col-sm-12">
          <ul className="list-group">
            {filteredProductsForList.length > 0 ?
              filteredProductsForList.map((item: IProductData, index: number) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActiveProduct(item, index)}
                  key={index}
                >
                  <div className="left">{item.barcode_number}</div>
                  <div >
                        <img
                          src={"./images/products/" + item.image_file_name}
                          alt={item.product_name}
                          width="100"
                          height="100"
                        />
                  </div>
                  <div>
                        <img
                          src={"./images/brand/" + item.logo_image_file_name}
                          alt={item.brand_name}
                          width="70"
                          height="70"
                        />
                  </div>
                  <div>{item.product_name}</div>
                  <div>{item.product_description}</div>
                  <div>{item.unit_of_measure_label}. {item.measure} - € {item.list_prize}</div>
                  <div>{item.unit_of_measure===2?("€"+(item.list_prize*1000/item.measure).toFixed(2)+"/kg"):""}</div>
                  {/* <div className="right">
                    <Link
                    to={"/books/" + item.id}
                    className="badge badge-warning"
                  >
                    Edit
                  </Link>
                  </div> */}

                </li>
              )) : 
              <div className="nobooks-wrap">
                  <img src={nobooks} alt="No books" />
              </div>}
          </ul>
          {/* <div className="buttons-wrap">
              <Link to={"/books/add"} className="btn btn-info add-book-link">
                    Add Product
              </Link>
              {items.length > 0 && <button
                className="m-3 btn btn-sm btn-danger"
                onClick={this.removeAllProducts}
              >
                Remove All Products
              </button>}
          </div> */}
        </div>
        </div>
      </div>
    );
  }
}
