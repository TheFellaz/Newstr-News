import React from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import "./Header.css";
import { BasicBtn, LoginButton, HomeButton } from "../../utils/Buttons/Buttons";
import { Link } from "react-router-dom";

function handleHome() {
  alert("move to Home");
}

function Header(props) {
  return (
    <div>
      <Row>
        <Col>
          <Link to={`/`}>
            <BasicBtn handleHome={handleHome} btnName={"HOME"} />
          </Link>
        </Col>

        <Col></Col>
        <Col></Col>
        <Col></Col>
        <Col></Col>
        <Col>
          <Link to={`/login`}>
            <BasicBtn handleHome={handleHome} btnName={"Login"} />
          </Link>
        </Col>
      </Row>
      <h1>Newster News</h1>
    </div>
  );
}

export default Header;
