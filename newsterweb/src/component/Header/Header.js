import React from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";
import "./Header.css";
import { BasicBtn, LoginButton, HomeButton } from "../../utils/Buttons/Buttons";
import { Link } from "react-router-dom";
import { useCookies } from "react-cookie";

function Header(props) {
  function handleHome() {
    if (
      document.getElementById("loginBtnId").innerText === "LOGOUT" &&
      localStorage.getItem("token") !== null
    ) {
      document.getElementById("loginBtnId").innerText = "LOGIN";
      localStorage.removeItem("token");
      localStorage.removeItem("userName");
      localStorage.removeItem("userTopics");
      localStorage.removeItem("userFrequency");
      window.location.href = "/";
    } else if (document.getElementById("loginBtnId").innerText === "LOGIN") {
      window.location.href = "/login";
    }
  }
  return (
    <div>
      <Row>
        <Col className="fontClass">
          <Link to={`/`}>
            <BasicBtn handleHome={handleHome} btnName={"HOME"} />
          </Link>
        </Col>

        <Col></Col>
        <Col></Col>
        <Col></Col>
        <Col></Col>
        <Col className="fontClass">
          {/* <Link to={`/login`}> */}
          {localStorage.getItem("token") !== null ? (
            <>
              <Button id="loginBtnId" onClick={handleHome}>
                LOGOUT
              </Button>
            </>
          ) : (
            <Button id="loginBtnId" onClick={handleHome}>
              LOGIN
            </Button>
          )}
          {/* </Link> */}
        </Col>
      </Row>
      <h1 className="fontClass">Newster News</h1>
    </div>
  );
}

export default Header;
