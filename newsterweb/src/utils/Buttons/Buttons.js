import * as React from "react";
import Button from "react-bootstrap/Button";
import verifyEmailFormat from "../EmailUtil.js";
import axios from "axios";
import { useState } from "react";

function BasicBtn({ btnName, handleBtn }) {
  return <Button onClick={handleBtn}>{btnName}</Button>;
}

function RegisterUserInfoBtn(token) {
  const [checkedTopics, updateCheckedTopics] = useState(
    document.querySelectorAll(".topicOption")
  );
  const [selectedFrequency, updateSelectedFrequency] = useState(
    document.querySelector(".frequencyOption[checked='true']")
  );

  return (
    <Button
      className="RegisterUserInfoBtn"
      onClick={() => {
        updateCheckedTopics(document.querySelectorAll(".topicOption"));
        //get updated user data
        let TopicList = document.querySelectorAll(".topicOption[checked]");
        let newTopicList = [];
        TopicList.forEach((topic) => {
          if (topic.checked) {
          }
        });

        //  let newFrequencySelection =
        //  document.querySelector(".frequencyOption");

        updateSelectedFrequency(
          document.querySelectorAll(".frequencyOption[checked]")
        );

        console.log(checkedTopics);
        if (checkedTopics !== null) {
          console.log(checkedTopics[0]._valueTracker.getValue());
        }
        if (selectedFrequency !== null) {
          console.log(selectedFrequency);
        } else {
          console.log("damn it");
        }
        console.log(document.querySelectorAll(".frequencyOption"));
        //console.log(token);

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
      onClick={async () => {
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
          userName: usernameInput,
          email: emailInput,
          pw: passwordInput,
        };

        //make Sign up HTTP request to backend
        let signUpResponse = await axios.post(
          "http://localhost:8080/signup",
          userInfo,
          {
            withCredentials: true,
          }
        );
        // console.log(signUpResponse);
        if (signUpResponse.data == "Duplicate") {
          alert("Useremail already exists");
        } else {
          window.location.href = "/login";
        }
        // console.log(JSON.stringify(userInfo));
      }}
    >
      Sign Up
    </Button>
  );
}

export { BasicBtn, SignUpBtn, RegisterUserInfoBtn };
