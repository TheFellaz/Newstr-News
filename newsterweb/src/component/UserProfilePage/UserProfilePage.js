import React from "react";
import axios from "axios";
import { TOPICS } from "../../utils/TopicList";
import "./UserProfilePage.css";
import { useParams } from "react-router-dom";

function UserProfilePage(props) {
  let userName = useParams().id;

  if (userName === undefined) {
    window.location.href = "/404NotFound";
  } else {
    //verify token and username

    let userToken = "foo";
    let userInfoRequest = axios.post("http://localhost:8080/user", {
      token: userToken,
      userName: userName,
    });

    let userObject = JSON.parse(userInfoRequest.data);

    let userTopicsList = userObject.userTopicsList;
    let frequencySelection = userObject.frequencySelection;
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

        <div id="topicListID">
          {TOPICS.map((topicName, topicIndex) =>
            GenerateTopicCheckbox(topicName, topicIndex, userTopicsList)
          )}
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
      </div>
    );
  }
}

function GenerateTopicCheckbox(topicName, topicIndex, userTopicList) {
  if (topicIndex in userTopicList) {
    return (
      <div>
        <input
          id={topicName}
          type="checkbox"
          name={topicName}
          value="true"
          defaultChecked
        ></input>
        <label for={topicName}>{topicName}</label>
      </div>
    );
  } else {
    return (
      <div>
        <input
          id={topicName}
          type="checkbox"
          name={topicName}
          value="true"
        ></input>
        <label for={topicName}>{topicName}</label>
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
      <div className="frequencyOption">
        <input
          type="radio"
          id={frequencyOptionName}
          name="frequency"
          value={frequencyOptionIndex + 1}
          defaultChecked
        ></input>
        <label for={frequencyOptionName}>{frequencyOptionName}</label>
      </div>
    );
  } else {
    return (
      <div className="frequencyOption">
        <input
          type="radio"
          id={frequencyOptionName}
          name="frequency"
          value={frequencyOptionIndex + 1}
        ></input>
        <label for={frequencyOptionName}>{frequencyOptionName}</label>
      </div>
    );
  }
}

export default UserProfilePage;
