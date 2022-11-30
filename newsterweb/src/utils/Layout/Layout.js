import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

function Layout(props) {
  return (
    <Container>
      <Row className="headerClass">{props.header}</Row>
      <Row className="pageClass">{props.page}</Row>
      <Row className="footerClass">
        <Col>{props.footer}</Col>
      </Row>
    </Container>
  );
}

export default Layout;
