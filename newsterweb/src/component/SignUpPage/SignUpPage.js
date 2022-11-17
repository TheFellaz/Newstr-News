import React from "react";
import axios from "axios";
import verifyEmailFormat from "../../utils/EmailUtil.js";
axios.defaults.withCredentials = true;

function SignUpPage() {
  return (
    <div>
      <h3>Sign Up page</h3>
      <input id="usernameID" placeholder="Your username"></input>
      <input id="email" placeholder="Your email"></input>
      <input id="password" type="password" placeholder="Password"></input>
      <input
        id="confirmPassword"
        type="password"
        placeholder="Confirm password"
      ></input>

      <button
        className="submitButton"
        onClick={() => {
          //check if passwords match
          let passwordInput = document.getElementById("password").value;
          let passwordComparison =
            document.getElementById("confirmPassword").value;
          let compareVal = passwordInput.localeCompare(passwordComparison);

          if (compareVal != 0) {
            alert("The Password and Confirm Password Fields must match");
            return 0;
          }

          //verify valid email address format
          let email = document.getElementById("email").value;
          let usernameInput = document.getElementById("usernameID").value;

          if (verifyEmailFormat(email) == false) {
            alert("Please enter a valid email Address");
            return 0;
          }

          // let news_types = document.getElementById("news_types").value;
          /*let signUpResponse = axios
            .post("http://localhost:8080/signUp", {
              withCredentials: true,
              email: email,
              password: passwordInput,
            })
            .then((res) => {
              alert(JSON.stringify(res.data));
            });*/

          alert(
            "username: " +
              usernameInput +
              "\nemail: " +
              email +
              "\npassword: " +
              passwordInput +
              "\npasswordConfirm: " +
              passwordComparison
          );
        }}
      >
        Sign Up
      </button>
    </div>
  );
}

export default SignUpPage;
