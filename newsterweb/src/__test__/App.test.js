import React from "react";
import * as ReactDOM from "react-dom/client";
import App from "../App";
import "../App.css";

it("renders the application", () => {
  const div = document.createElement("div");
  const root = ReactDOM.createRoot(div);
  root.render(<App />);
  //ReactDOM.render(<App />, div);
});
