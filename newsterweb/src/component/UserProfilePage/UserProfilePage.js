import React from "react";
import { TOPICS } from "../../utils/TopicList";
import "./UserProfilePage.css";

function UserProfilePage(props) {
  let username = "me, baby";
  let userTopicsList = [0, 1, 2, 3, 4];
  let frequencySelection =  1;
  let email = "ayyyyyye lmao";
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
    </div>
  );
}

function GenerateTopicCheckbox(topicName, topicIndex, userTopicList) {
  {
    if (topicIndex in userTopicList) {
      return (
        <div>
          <input
            id="{topicName}ID"
            type="checkbox"
            name="{topicName}"
            value="true"
            defaultChecked
          ></input>
          <label for="topicName}ID">{topicName}</label>
        </div>
      );
    } else {
      return (
        <div>
          <input
            id="{topicName}ID"
            type="checkbox"
            name="{topicName}"
            value="true"
          ></input>
          <label for="topicName}ID">{topicName}</label>
        </div>
      );
    }
  }
}

function GenerateFrequencyCheckboxes(userFrequencySelection) {
  let frequencyOptions = ["Morning", "Morning and Evening", "Morning, Noon, and Evening"];
  let returnString = "";

  for(index = 0, index < 3, index++) {
    if((index + 1) == userFrequencySelection) {
      returnString += '<input type="checkbox" id=' + 
      frequencyOptions[index] + 
      ' name="frequency" value="' +
      (index + 1) +
      '" defaultChecked></input>\n
      <label for="'
    })

  }

}

export default UserProfilePage;
