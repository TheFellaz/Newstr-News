import React from "react";
import { useState } from "react";

function CheckboxComponent(props) {
  let topicName = props.topicName;
  let topicIndex = props.topicIndex;
  let userTopicsList = props.userTopicsList;
  const [isChecked, setIsChecked] = useState(false);

  const handleChange = () => {
    setIsChecked(!isChecked);
    console.log(isChecked);
  };

  let tmpList = userTopicsList;

  if (topicIndex in userTopicsList) {
    return (
      <div>
        <input
          className="topicOption"
          id={topicName}
          type="checkbox"
          name={topicName}
          value="true"
          checked={!isChecked}
          onChange={(e) => {
            setIsChecked(!isChecked);
            console.log(topicName, isChecked);
          }}
        ></input>
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
          checked={isChecked}
          onChange={(e) => {
            setIsChecked(!isChecked);
          }}
        ></input>
        <label htmlFor={topicName}>{topicName}</label>
      </div>
    );
  }
}

export default CheckboxComponent;
