import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUpPage from "./component/SignUpPage/SignUpPage";
import NotFoundPage from "./component/NotFoundPage/NotFoundPage";
import LoginPage from "./component/LoginPage/LoginPage";
import MainPage from "./component/MainPage/MainPage";
import UserProfilePage from "./component/UserProfilePage/UserProfilePage";
// import Header from "./component/Header/Header";
import Footer from "./component/Footer/Footer";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
const Header = React.lazy(() => import("./component/Header/Header"));

function Router(props) {
  return (
    <Container>
      <BrowserRouter>
        <Row className="headerClass">
          <Header />
        </Row>
        <Row className="pageClass">
          <Routes>
            <Route path="/" element={<MainPage />} />
            <Route path="/signup" element={<SignUpPage />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/user" element={<UserProfilePage />} />
            <Route path="/user/:id" element={<UserProfilePage />} />
            <Route path="/404notfound" element={<NotFoundPage />} />
            <Route path="*" element={<NotFoundPage />} />
          </Routes>
        </Row>
        <Row className="footerClass">
          <Col>
            <Footer />
          </Col>
        </Row>
      </BrowserRouter>
    </Container>
  );
}

export default Router;
