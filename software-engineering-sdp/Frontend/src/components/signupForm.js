// Done by Wasik and Jannatul

import "./signupForm.css"
import {Link} from "react-router-dom";
import React, { useState } from "react";

const SignupForm = () => {
    const [firstName,setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
    
        // Send the username and password to the backend
        sendCredentials(firstName, lastName, username, email, password);
      };
    
      const sendCredentials = (firstName, lastName, username, email, password) => {
        const axios = require("axios");
    
    async function sendCredentials(firstName, lastName, username,email, password) {
      try {
        const data = {
          firstName: firstName,
          lastName: lastName,
          username: username,
          password: password,
          email: email,
          
        };
    
        const response = await axios.post("http://localhost:8080/login", data);
        console.log("Credentials sent to the backend:", response.data);
        // Process the response from the backend as needed
      } catch (error) {
        console.error("Error sending credentials:", error);
      }
    }
    
    // Call the sendCredentials function with the desired username and password
    sendCredentials("exampleUser", "examplePassword");
      };


    return(
        <div className="cover-sign">
            <h1>Sign Up</h1>
            <input type="text" placeholder="First Name" value={firstName}
          onChange={(e) => setFirstName(e.target.value)}/>
          <input type="text" placeholder="Last Name" value={lastName}
          onChange={(e) => setLastName(e.target.value)}/>
            <input type="text" placeholder="User Name" value={username}
          onChange={(e) => setUsername(e.target.value)}/>
            <input type="text" placeholder="Email" value={email}
          onChange={(e) => setEmail(e.target.value)} />
            <input type="password" placeholder="Password" value={password}
          onChange={(e) => setPassword(e.target.value)} />
            <button id="SignUpbutton">Sign Up</button>
            <div className="already-account">
          <Link to="/login">Already have an account?</Link>
           </div> 
            
        </div>
      
         
    )
}

export default SignupForm