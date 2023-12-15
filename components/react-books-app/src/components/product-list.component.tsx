import { Component, ChangeEvent } from "react";
import ProductDataService from "../services/product.service";
import { Link } from "react-router-dom";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import IProductData from '../types/product.type';
import nobooks from '../assets/nobooks.png';

type Props = {};

type State = {
  books: Array<IProductData>,
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
      // books: [
      //   {id: 1,title: 'How to train 1', description: 'Hiccup aspires to follow his tribe\'s tradition of becoming a dragon slayer.', available: true}, 
      //   {id: 2,title: 'How to train 2', description: 'Usodas red novlas to follow his tribe', available: true}, 
      //   {id: 3,title: 'How to train 3', description: 'DesOpdes coma reto cription', available: true}
      // ],
      books: [],
      currentProduct: null,
      currentIndex: 0,
      searchTitle: ''
    };
  }

  componentDidMount() {
    this.retrieveProducts();
  }

  onChangeSearchTitle(e: ChangeEvent<HTMLInputElement>) {
    const searchTitle = e.target.value;

    this.setState({
      searchTitle: searchTitle
    });
  }

  retrieveProducts() {
    ProductDataService.getAll()
      .then((response: any) => {
        this.setState({
          books: response.data
        });
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
    });
  }

  removeAllProducts() {
    // ProductDataService.deleteAll()
    //   .then((response: any) => {
    //     console.log(response.data);
    //     toast.success("All books removed!");
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
    //       books: response.data
    //     });
    //     console.log(response.data);
    //   })
    //   .catch((e: Error) => {
    //     console.log(e);
    //   });
  }

  render() {
    const { searchTitle, books, currentProduct, currentIndex } = this.state;

    return (
      <div className="list row">
        {currentProduct ? (<div className="col-md-12 mb-5">
            <div className="row books-row">
              <div className="col-3">
                <div className="cover"/>
              </div>
              <div className="col-9">
              <h4>Product</h4>
              <div>
                <label>
                  <strong>Barcode:</strong>
                </label>{" "}
                {currentProduct.barcode_number}
              </div>
              <div>
                <label>
                  <strong>Product Name:</strong>
                </label>{" "}
                {currentProduct.product_name}
              </div>
              <div>
                <label>
                  <strong>Product Name:</strong>
                </label>{" "}
                {currentProduct.product_description}
              </div>
              </div>
            </div>
        </div>
        ) : ( '' )}
        <div className="col-md-6">
          <h4>Product List</h4>
          </div>
        <div className="col-md-6">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Search by title"
              value={searchTitle}
              onChange={this.onChangeSearchTitle}
            />
            <div className="input-group-append">
              <button
                className="btn search-btn btn-outline-secondary"
                type="button"
                onClick={this.searchByTitle}
              >
                Search
              </button>
            </div>
          </div>
        </div>
        <div className="col-md-12">
          <ul className="list-group">
            {books.length > 0 ?
              books.map((book: IProductData, index: number) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActiveProduct(book, index)}
                  key={index}
                >
                  <div className="left">{book.barcode_number}</div>
                  <div>{book.product_name}</div>
                  <div>{book.product_description}</div>
                  
                  <div className="right">
                    <Link
                    to={"/books/" + book.id}
                    className="badge badge-warning"
                  >
                    Edit
                  </Link>
                  </div>

                </li>
              )) : 
              <div className="nobooks-wrap">
                  <img src={nobooks} alt="No books" />
              </div>}
          </ul>
          <div className="buttons-wrap">
              <Link to={"/books/add"} className="btn btn-info add-book-link">
                    Add Product
              </Link>
              {books.length > 0 && <button
                className="m-3 btn btn-sm btn-danger"
                onClick={this.removeAllProducts}
              >
                Remove All Products
              </button>}
          </div>
        </div>
      </div>
    );
  }
}
