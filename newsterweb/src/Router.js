import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUp from "./component/SignUpPage/SignUp";
import NotFound from "./component/NotFound/NotFound";
import LoginPage from "./component/LoginPage/LoginPage";
import MainPage from "./component/MainPage/MainPage";
import UserProfilePage from "./component/UserProfilePage/UserProfilePage";

function Router(props) {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/user" element={<UserProfilePage />} />
        <Route path="/user/:id" element={<UserProfilePage />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
