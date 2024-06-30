// import { useState } from "react";
// import "./Header.css";
// import { Link, useNavigate } from "react-router-dom";

export default function Header() {
  return (
    <div className="header-container">
      <nav className="container navbar navbar-expand-lg navbar-dark">
        <div className="container d-flex justify-content-between align-items-center">
          <p className="logo my-auto navbar-brand">
            <img
              src="./images/logo_2.png"
              alt="Logo with words: Recipe Sharing Platform stacked on each other with pot with steam on top. "
            />
          </p>
          <button
            className="navbar-toggler"
            type="button"
            aria-label="Menu"
            onClick={toggleNavbar}
          >
            <span className="navbar-toggler-icon"></span>
          </button>
        </div>
      </nav>
    </div>
  );
}
