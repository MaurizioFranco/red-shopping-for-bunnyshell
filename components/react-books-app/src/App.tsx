import { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import BookAdd from "./components/book-add.component";
import Book from "./components/book.component";
import BookList from "./components/book-list.component";
import ProductList from "./components/product-list.component";
import logo from '../src/assets/logo.png'

class App extends Component {
  render() {
    return (
      <div>
        <ToastContainer
          position="top-right"
          autoClose={5000}
          hideProgressBar={false}
          newestOnTop={false}
          closeOnClick
          rtl={false}
          pauseOnFocusLoss
          draggable
          pauseOnHover
        />
        {/* Same as */}
        <ToastContainer />
        <nav className="navbar navbar-expand navbar-dark">
          <div className="container">
                <div className="wrap">
                <div className="logo">
                  <Link to={"/books"} className="navbar-brand">
                    <img src={logo} className="logo" alt="Bunnyshell" />
                  </Link>
                </div>
                <div className="navbar-nav">
                  <li className="nav-item">
                    <Link to={"/books"} className="nav-link">
                      Books
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link to={"/books/add"} className="nav-link">
                      Add Book
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link to={"/product/add"} className="nav-link">
                      Aggiungi prodotto
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link to={"/price/add"} className="nav-link">
                      Aggiungi prezzo
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link to={"/products"} className="nav-link">
                      Prodotti e Prezzi
                    </Link>
                  </li>
                  
                </div>
            </div>
          </div>
        </nav>

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/books"]} component={BookList} />
            <Route exact path="/books/add" component={BookAdd} />
            <Route path="/books/:id" component={Book} />
            <Route exact path={["/products"]} component={ProductList} />
            {/* <Route exact path="/products/add" component={ProductAdd} /> */}
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
