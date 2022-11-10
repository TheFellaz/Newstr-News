import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUpPage from "./component/SignUpPage/SignUpPage";
import NotFoundPage from "./component/NotFound/NotFoundPage";
import LoginPage from "./component/LoginPage/LoginPage";
import MainPage from "./component/MainPage/MainPage";
import UserProfilePage from "./component/UserProfilePage/UserProfilePage";

function Router(props) {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/signup" element={<SignUpPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/user" element={<UserProfilePage />} />
        <Route path="/user/:id" element={<UserProfilePage />} />
        <Route path="*" element={<NotFoundPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
