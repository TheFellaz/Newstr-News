import "./App.css";
import Router from "./Router";
import "bootstrap/dist/css/bootstrap.min.css";
import Layout from "./utils/Layout/Layout";
import Header from "./component/Header/Header";
import Footer from "./component/Footer/Footer";

function App() {
  return (
    <div className="App">
      {/* <Layout header={<Header />} footer={<Footer />} page={<Router />} /> */}
      <Router />
    </div>
  );
}

export default App;
