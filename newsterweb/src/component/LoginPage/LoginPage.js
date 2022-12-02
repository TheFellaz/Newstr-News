import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { res, validate } from "react-email-validator";
import "./LoginPage.css";

function LoginPage(props) {
  async function logIn(email, pw) {
    if (!validate(email)) {
      alert("Is not email");
      return;
    }
    /*
    private String userName;
    private String email;
    private String pw;
    private int[] topics = null;
    private int frequency = 0;
    private String token = null;
    */
    const info = {
      email: email,
      pw: pw,
      // userName: null,
      // topics: null,
      // frequency: 0,
      // token: null,
    };

    let response = await axios.post("http://localhost:8080/login", info, {
      withCredentials: true,
    });

    console.log(response);

    let ret = response.data;
    if (response.status !== 200) {
      alert(`${ret.status}`);
    } else {
      window.location.href = "/";
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
