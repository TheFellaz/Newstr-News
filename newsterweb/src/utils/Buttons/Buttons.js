import * as React from "react";
import Button from "react-bootstrap/Button";

function BasicBtn({ btnName, handleBtn }) {
  return <Button onClick={handleBtn}>{btnName}</Button>;
}

export { BasicBtn };
