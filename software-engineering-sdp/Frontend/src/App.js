// Done by Jannatul 
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom"

import Home from "./Allpages/Home";
import Add from "./Allpages/Add";
import Recipe from "./Allpages/Recipe";
import Login from "./Allpages/Login";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer"
import SignupForm from "./components/signupForm"


function App() {
  return (
    <Router>
      <Navbar />
      <div className="container main">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/recipe" element={<Recipe />} />
          <Route path="/add" element={<Add />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignupForm />} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
}

export default App;
