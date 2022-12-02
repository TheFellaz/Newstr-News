import React from "react";
import useState from "react";
//import axios from "axios";
import { TOPICS } from "../../utils/TopicList";
import { RegisterUserInfoBtn } from "../../utils/Buttons/Buttons.js";
import "./UserProfilePage.css";
import { useParams } from "react-router-dom";
import CheckboxComponent from "./CheckboxComponent";

function UserProfilePage(props) {
  let userName = useParams().id;

  if (userName === undefined) {
    window.location.href = "/404NotFound";
    return -1; //not sure if this is dead code just making sure nothing weird happens after redirect
  } else {
    //verify token and username

    let userToken = "foo";
    /*let userInfoRequest = axios.post("http://localhost:8080/user", {
      token: userToken,
      userName: userName,
    });*/

    //let userObject = JSON.parse(userInfoRequest.data);
    let userObject = {
      topics: [1, 2, 3, 4],
      frequency: 2,
      email: "hey baby yeah",
    };

    let userTopicsList = userObject.topics;
    console.log("SIBAL");
    console.log(userTopicsList);
    let frequencySelection = userObject.frequency;
    let email = userObject.email;
    const frequencyOptions = [
      "Morning",
      "Morning and Evening",
      "Morning, Noon, and Evening",
    ];

    return (
      <div>
        <div id="topLeftUserInfoID">
          Welcome back, {userName}. <br />
          Your preferred email for news is currently {email}.
        </div>

        <form action="http://localhost:8080/register" method="post">
          <div id="topicListID">
            <h1>FUCK@</h1>

            {TOPICS.map((topicName, topicIndex) => {
              console.log(topicIndex);
              return GenerateTopicCheckbox(
                topicName,
                topicIndex,
                userTopicsList
              );
              /* let info = {
                topicName,
                topicIndex,
                userTopicsList,
              };
              return (
                <div>
                  <CheckboxComponent {...info} />
                  <h1>FUCK1</h1>
                </div>
              );*/
            })}
          </div>

          <fieldset id="frequencyOptionsID">
            <legend>Select an Email Frequency</legend>
            {frequencyOptions.map((frequencyOption, frequencyIndex) =>
              GenerateFrequencyRadio(
                frequencySelection,
                frequencyOption,
                frequencyIndex
              )
            )}
          </fieldset>

          {
            //<RegisterUserInfoBtn token={userToken} />
          }

          <input type="hidden" name="token" value={userToken} />

          <input type="submit" value="Save" />
        </form>
      </div>
    );
  }
}

function GenerateTopicCheckbox(topicName, topicIndex, userTopicList) {
  if (topicIndex in userTopicList) {
    return (
      <div>
        <input
          className="topicOption"
          id={topicName}
          type="checkbox"
          name={topicName}
          value="true"
          defaultChecked
        />
        <label htmlFor={topicName}>{topicName}</label>
      </div>
    );
  } else {
    return (
      <div>
        <input
          className="topicOption"
          id={topicName}
          type="checkbox"
          name={topicName}
          value="true"
        />
        <label htmlFor={topicName}>{topicName}</label>
      </div>
    );
  }
}

function GenerateFrequencyRadio(
  userFrequencySelection,
  frequencyOptionName,
  frequencyOptionIndex
) {
  if (frequencyOptionIndex === userFrequencySelection) {
    return (
      <div>
        <input
          className="frequencyOption"
          type="radio"
          id={frequencyOptionName}
          name="frequency"
          value={frequencyOptionIndex + 1}
          defaultChecked
        />
        <label htmlFor={frequencyOptionName}>{frequencyOptionName}</label>
      </div>
    );
  } else {
    return (
      <div>
        <input
          className="frequencyOption"
          type="radio"
          id={frequencyOptionName}
          name="frequency"
          value={frequencyOptionIndex + 1}
        />
        <label htmlFor={frequencyOptionName}>{frequencyOptionName}</label>
      </div>
    );
  }
}

export default UserProfilePage;
