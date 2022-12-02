import * as React from "react";
import Button from "react-bootstrap/Button";
import verifyEmailFormat from "../EmailUtil.js";
import axios from "axios";

function BasicBtn({ btnName, handleBtn }) {
  return <Button onClick={handleBtn}>{btnName}</Button>;
}

async function SignUp(userName, email, pw, pwComparison) {
  //check if passwords match

  let compareVal = pw.localeCompare(pwComparison);

  if (compareVal != 0) {
    alert("The Password and Confirm Password Fields must match");
    return -1;
  }

  //verify valid email address format

  if (verifyEmailFormat(email) == false) {
    alert("Please enter a valid email Address");
    return -2;
  }

  //create JSON object to send in request
  const userInfo = {
    username: userName,
    email: email,
    pw: pw,
  };

  //make Sign up HTTP request to backend
  let signUpResponse = await axios.post(
    "http://localhost:8080/signup",
    userInfo,
    {
      withCredentials: true,
    }
  );
  if (signUpResponse.status !== 200) {
    alert("This email is already in use. Please use a different one lmao");
  } else {
    // window.location.href = "/login";
    alert("Sign up successful!");
  }
}

function SignUpBtn() {
  return (
    <Button
      className="SignUpBtn"
      onClick={async () => {
        let passwordInput = document.getElementById("password").value;
        let passwordComparison =
          document.getElementById("confirmPassword").value;
        let emailInput = document.getElementById("email").value;
        let userNameInput = document.getElementById("usernameID").value;
        await SignUp(
          userNameInput,
          emailInput,
          passwordInput,
          passwordComparison
        );
      }}
    >
      Sign Up
    </Button>
  );
}

export { BasicBtn, SignUpBtn };
