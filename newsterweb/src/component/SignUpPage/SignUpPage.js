import React from "react";
import axios from "axios";
import { SignUpBtn } from "../../utils/Buttons/Buttons.js";

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

      <SignUpBtn />
    </div>
  );
}

export default SignUpPage;
