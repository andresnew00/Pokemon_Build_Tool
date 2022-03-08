import logo from "./logo.svg";
import "./App.css";
import MainSection from "./Components/HomePage/MainSection/MainSection.jsx";
import { useEffect, useState } from "react";
import { useLocalState } from "./util/useLocalStorage";
import { Routes, Route, Switch } from "react-router-dom";
import LoginSection from "./Components/Login/LoginSection.js";
import BuildTool from "./Components/BuildTool/BuildTool.js";
import PrivateRoute from "./PrivateRoute/PrivateRoute.js";

function App() {
  const [jwt, setJwt] = useLocalState("", "jwt");
  const [pokemon, setPokemon] = useState([]);

  useEffect(() => {
    fetch("https://pokeapi.co/api/v2/pokemon/celebi")
      .then((res) => res.json())
      .then((data) => {
        console.log(data.name);
        setPokemon(data.name);
      });

  }, []);

  return (
    <Routes>
      <Route path="/" element={<MainSection pokemonName={pokemon} />} />
      <Route path="/login" element={<LoginSection />} />

      <Route
        path="/build"
        element={
          <PrivateRoute>
            <BuildTool />
          </PrivateRoute>
        }
      />
      {/* NOT FOUND PAGE */}
      <Route path="*" element={<div>Not Found</div>} />
    </Routes>
  );
}

export default App;
