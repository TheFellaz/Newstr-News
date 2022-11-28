import React from "react";
import { TOPICS } from "../../utils/TopicList";
import "./UserProfilePage.css";

function UserProfilePage(props) {
  let username = "sexy";
  let userTopicsList = [0, 1, 2, 3, 4];
  let frequencySelection = 1;
  let email = "ayyyyyye lmao";
  const frequencyOptions = [
    "Morning",
    "Morning and Evening",
    "Morning, Noon, and Evening",
  ];
  return (
    <div>
      <div id="topLeftUserInfoID">
        Welcome back, {username}. <br />
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
