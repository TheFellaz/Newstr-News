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
          name={topicIndex}
          value="true"
          checked={!isChecked}
          onChange={(e) => {
            setIsChecked(!isChecked);
            //e.target._valueTracker.setValue(isChecked);
            console.log(topicName, e.target._valueTracker.getValue());
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
          name={topicIndex}
          value="true"
          checked={isChecked}
          onChange={(e) => {
            setIsChecked(!isChecked);
            //e.target._valueTracker.setValue(!isChecked);
            console.log(topicName, e.target._valueTracker.getValue());
          }}
        ></input>
        <label htmlFor={topicName}>{topicName}</label>
      </div>
    );
  }
}

export default CheckboxComponent;
