import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
//import { res, validate } from "react-email-validator";
import "./LoginPage.css";
import verifyEmailFormat from "../../utils/EmailUtil";

function LoginPage(props) {
  async function logIn(email, pw) {
    if (!verifyEmailFormat(email)) {
      alert("Is not email");
      return;
    }
    const info = {
      email: email,
      pw: pw,
    };

    let response = await axios.post("http://localhost:8080/login", info, {
      withCredentials: true,
    });

    if (response.data.Correct === "No") {
      alert("Incorrect email or password");
    } else {
      localStorage.setItem("token", response.data.token);
      localStorage.setItem("userName", response.data.userName);
      window.location.href = "/user/" + response.data.userName;
    }
  }

  const onKeyUp = async (e) => {
    if (e.keyCode === 13) {
      let email = document.getElementById("idField").value;
      let pw = document.getElementById("pwField").value;
      logIn(email, pw);
    }
  };
  return (
    <div className="loginpage">
      <div className="loginDiv">
        <h1>Login to your account</h1>
        <label htmlFor="idField">Email</label>
        <br />
        <input id="idField" className="field" />
        <br />
        <label htmlFor="pwField">Password</label>
        <br />
        <input
          id="pwField"
          type="password"
          className="field"
          onKeyUp={onKeyUp}
        />
        <br />
        <button
          className="loginbtn"
          onClick={async () => {
            let email = document.getElementById("idField").value;
            let pw = document.getElementById("pwField").value;
            await logIn(email, pw);
          }}
        >
          Login now
        </button>
        <br />
        <span>
          Don't have an account? <Link to="/signup">SignUp</Link>
        </span>
      </div>
    </div>
  );
}

export default LoginPage;
