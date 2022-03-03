import logo from './logo.svg';
import './App.css';
import MainSection from './Components/HomePage/MainSection/MainSection.jsx';
import { useEffect, useState } from 'react';

function App() {
 // make a fetch request to pokeapi
 const [pokemon, setPokemon] = useState([]);

  useEffect(() => { 
    fetch('https://pokeapi.co/api/v2/pokemon/celebi')
    .then(res => res.json())
    .then(data => {
      console.log(data.name);
      setPokemon(data.name);
    });
  })

   

  return (
    <div className="App">
      <MainSection pokemonName={pokemon}/>
    </div>
  );
}

export default App;
