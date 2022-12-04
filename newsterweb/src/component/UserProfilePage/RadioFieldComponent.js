import React from "react";
import { useState } from "react";

function RadioFieldComponent(props) {
  const [selectedFrequency, setSelectedFrequency] = useState(
    props.initialFrequency
  );
  return (
    <div>
      <fieldset>
        <h1>Email Frequency</h1>

        <div>
          <input
            className="frequencyOption"
            type="radio"
            id="Morning"
            name="frequency"
            value="1"
            checked={1 == selectedFrequency}
            onChange={(e) => {
              setSelectedFrequency(e.target.value);
              console.log(selectedFrequency);
            }}
          />
          <label htmlFor="Morning">"Morning</label>
        </div>

        <div>
          <input
            className="frequencyOption"
            type="radio"
            id="Morning and Evening"
            name="frequency"
            value="2"
            checked={2 == selectedFrequency}
            onChange={(e) => {
              setSelectedFrequency(e.target.value);
              console.log(selectedFrequency);
            }}
          />
          <label htmlFor="Morning and Evening">Morning and Evening</label>
        </div>

        <div>
          <input
            className="frequencyOption"
            type="radio"
            id="Morning, noon, and Evening"
            name="frequency"
            value="3"
            checked={3 == selectedFrequency}
            onChange={(e) => {
              setSelectedFrequency(e.target.value);
              console.log(selectedFrequency);
            }}
          />
          <label htmlFor="Morning, noon, and Evening">
            "Morning, noon, and Evening"
          </label>
        </div>
      </fieldset>
    </div>
  );
}

/*const handleChange = (e) => {
  setSelectedFrequency(e.target.value);
  console.log(selectedFrequency);
};*/

export default RadioFieldComponent;
