import React from "react";
import axios from "axios";
axios.defaults.withCredentials = true;

function verifyEmailFormat(email) {
  const emailFormatRegex = new RegExp('.+@.+\.(edu)|(com)|(net)|(org)|(gov)');

  return emailFormatRegex.test(email);
}

function SignUpPage() {
  return (
    <div>
      <h3>Sign Up page</h3>
      <input placeholder="Your username"></input>
      <input placeholder="Your email"></input>
      <input id="password" type="password" placeholder="Password"></input>
      <input id="confirmPassword" type="password" placeholder="Confirm password"></input>

      <button
        className="submitButton"
        onClick={() => {
          
          //check if passwords match
          let passwordInput = document.getElementById("password").value;
          let passwordComparison = document.getElementById("confirmPassword").value;
          let compareVal = passwordInput.localeCompare(compareVal);

          if(compareVal != 0) {
            alert("The Password and Confirm Password Fields must match");
            return 0;
          }

          if(email)

          // let email = document.querySelector("input").value;
          // let news_types = document.getElementById("news_types").value;
          let news = axios
            .get("http://localhost:8080/signin", {
              withCredentials: true,
              // email: email,
              // news_types: news_types,
            })
            .then((res) => {
              alert(JSON.stringify(res.data));
            });

          // alert("email : " + email + "\nnews_types: " + news_types);
        }}
      >
        Get News
      </button>
    </div>
  );
}

export default SignUpPage;
