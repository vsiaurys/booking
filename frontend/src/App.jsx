// import { useState } from "react";
// import reactLogo from "./assets/react.svg";
// import viteLogo from "/vite.svg";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Main from "./components/Main";
import "./App.css";

export default function App() {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <Main />
      <footer className="mt-auto footer">
        <Footer />
      </footer>
    </div>
  );
}
