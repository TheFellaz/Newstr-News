import React from "react";
import useState from "react";
//import axios from "axios";
import { TOPICS } from "../../utils/TopicList";
import { RegisterUserInfoBtn } from "../../utils/Buttons/Buttons.js";
import "./UserProfilePage.css";
import { useParams } from "react-router-dom";
import CheckboxComponent from "./CheckboxComponent";
import RadioFieldComponent from "./RadioFieldComponent";
import axios from "axios";

async function getUser() {
  let info = {
    token: localStorage.getItem("token"),
  };
  let response = await axios.post("http://localhost:8080/userInfo", info, {
    withCredentials: true,
  });

  console.log(response.data.topics);
  let topicList = [];
  let topicStrList = response.data.topics.split(" ");
  for (let i = 0; i < topicStrList.length; i++) {
    topicList.push(parseInt(topicStrList[i]));
  }
  console.log(topicList);
  console.log(response.data.freq);
  let userObject = {
    topics: topicList,
    frequency: response.data.freq,
  };
  return userObject;
}

function UserProfilePage(props) {
  let userName = useParams().id;
  if (userName === undefined) {
    window.location.href = "/404NotFound";
    return -1; //not sure if this is dead code just making sure nothing weird happens after redirect
  }
  //verify token and username

  // const frequencyOptions = [
  //   "Morning",
  //   "Morning and Evening",
  //   "Morning, Noon, and Evening",
  // ];
  // let userObject = getUser();

  let userObject = {
    topics: [1, 2, 3],
    frequency: 2,
  };
  let userTopicsList = userObject.topics;
  let frequencySelection = userObject.frequency;

  function checkTopic() {
    const testElements = document.getElementsByClassName("topicOption");
    let topicsList = "";
    for (let i = 0; i < testElements.length; i++) {
      if (testElements[i].checked) {
        topicsList += i + 1 + " ";
      }
    }
    return topicsList;
  }

  function checkFreq() {
    const testElements = document.getElementsByClassName("frequencyOption");
    let freq = "";
    for (let i = 0; i < testElements.length; i++) {
      if (testElements[i].checked) {
        freq = i + 1;
        break;
      }
    }
    return freq;
  }

  async function registerPreference() {
    let topicsList = checkTopic();
    let freq = checkFreq();
    console.log(topicsList);
    console.log(freq);
    let registerInfoRequest = await axios.post(
      "http://localhost:8080/register",
      {
        token: localStorage.getItem("token"),
        topics: topicsList,
        frequency: freq,
      }
    );
    if (registerInfoRequest.data.Correct === "Yes") {
      alert("Successfully registered your preferences!");
    }
  }
  let response = getUser();
  return (
    <div>
      <div id="topLeftUserInfoID">
        Welcome back, {userName}. <br />
      </div>

      <div id="topicListID">
        <h1>TopicList</h1>

        {TOPICS.map((topicName, topicIndex) => {
          console.log(topicIndex);

          let info = {
            topicName,
            topicIndex,
            userTopicsList,
          };
          return <CheckboxComponent {...info} />;
        })}
      </div>

      <br />
      <br />

      <RadioFieldComponent initialFrequency={frequencySelection} />
      <button
        onClick={async () => {
          await registerPreference();
        }}
      >
        Save
      </button>
    </div>
  );
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
  //const [selectedFrequency, setSelectedFrequency] = useState(
  //  userFrequencySelection
  //);
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
