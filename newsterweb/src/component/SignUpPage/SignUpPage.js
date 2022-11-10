import React from "react";
import axios from "axios";
axios.defaults.withCredentials = true;

function SignUpPage() {
  return (
    <div>
      <h3>Sign Up page</h3>
      <input placeholder="your email"></input>
      <input placeholder="Password"></input>
      <select name="types" id="news_types">
        <option value="None">None</option>
        <option value="Sports">Sports</option>
        <option value="Politics">Politics</option>
        <option value="Economics">Economics</option>
        <option value="Business">Business</option>
      </select>

      <button
        className="submitButton"
        onClick={() => {
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
