import * as React from "react";
import Button from "react-bootstrap/Button";
import verifyEmailFormat from "../EmailUtil.js";
import axios from "axios";
import { useState } from "react";

function BasicBtn({ btnName, handleBtn }) {
  return <Button onClick={handleBtn}>{btnName}</Button>;
}

function RegisterUserInfoBtn(token) {
  const [checkedTopics, updateCheckedTopics] = useState(null);
  return (
    <Button
      className="RegisterUserInfoBtn"
      onClick={() => {
        updateCheckedTopics(document.querySelectorAll(".topicOption[checked]"));
        //get updated user data
        let TopicList = document.querySelectorAll(".topicOption[checked]");
        let newTopicList = [];
        TopicList.forEach((topic) => {
          if (topic.checked) {
          }
        });

        let newFrequencySelection = document.querySelector(
          ".frequencyOption[checked]"
        );

        console.log(checkedTopics);
        console.log(newFrequencySelection);
        console.log(token);

        //format into object to send
      }}
    >
      Save
    </Button>
  );
}

function SignUpBtn() {
  return (
    <Button
      className="SignUpBtn"
      onClick={() => {
        //check if passwords match
        let passwordInput = document.getElementById("password").value;

        let passwordComparison =
          document.getElementById("confirmPassword").value;

        let compareVal = passwordInput.localeCompare(passwordComparison);

        if (compareVal !== 0) {
          alert("The Password and Confirm Password Fields must match");
          return -1;
        }

        //verify valid email address format
        let emailInput = document.getElementById("email").value;
        let usernameInput = document.getElementById("usernameID").value;

        if (verifyEmailFormat(emailInput) === false) {
          alert("Please enter a valid email Address");
          return -2;
        }

        //create JSON object to send in request
        const userInfo = {
          username: usernameInput,
          email: emailInput,
          password: passwordInput,
        };

        //make Sign up HTTP request to backend
        let signUpResponse = axios
          .post("http://localhost:8080/signUp", {
            newUserInfo: userInfo,
          })

          .then(() => {
            window.location.href = "/login";
          })
          .catch((error) => {
            if (error.response.status === 409) {
              alert(
                "This email is already in use. Please use a different one lmao"
              );
            }
          });
        //console.log(JSON.stringify(userInfo));
      }}
    >
      Sign Up
    </Button>
  );
}

export { BasicBtn, SignUpBtn, RegisterUserInfoBtn };
