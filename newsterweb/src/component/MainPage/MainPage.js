import React from "react";
import "./MainPage.css";
import { Link } from "react-router-dom";
import { BasicBtn } from "../../utils/Buttons/Buttons";

function MainPage(props) {
  const aboutInfo =
    "The Web App Getting news from an unbiased source is difficult and relying on one source can lead to confirmation bias. In addition, politics dominate the news cycle, so that means finding specific topics can prove difficult. With Newster, users can customize their daily news delivery and receive it in their email inbox. No more jumping around from website to website. With Newstr, all of the sources are brought together.";
  return (
    <div>
      <div className="InfoClass">{aboutInfo}</div>
      <img src="mainPage.png" className="mainPageImg"></img>
      <h1 className="fontClass">Do you want to Join Newster News??</h1>

      <br />
      <br />
      {localStorage.getItem("token") !== null ? (
        <Link to={`/user/${localStorage.getItem("userName")}`}>
          <BasicBtn btnName={"User Page"} />
        </Link>
      ) : (
        <Link to={`/signup`}>
          <BasicBtn btnName={"Sign Up"} />
        </Link>
      )}
    </div>
  );
}

export default MainPage;
