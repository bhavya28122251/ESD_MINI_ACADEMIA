import React from "react";
import LoginCard from "../components/LoginCard.jsx"; // Importing the Login Card component
import "../CSS/Login.css"; // Importing the CSS file

function LoginPage() {
  return (
    <div className="login-page">
      <h1 className="login-heading">Welcome to My Application</h1>
      <h2 className="login-title">Login to Continue</h2>
      <LoginCard />
    </div>
  );
}

export default LoginPage;
