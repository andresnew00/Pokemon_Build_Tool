import logo from './logo.svg';
import './App.css';
import MainSection from './Components/HomePage/MainSection/MainSection.jsx';
import { useEffect, useState } from 'react';

function App() {

 const [pokemon, setPokemon] = useState([]);

  useEffect(() => { 
    fetch('https://pokeapi.co/api/v2/pokemon/celebi')
    .then(res => res.json())
    .then(data => {
      console.log(data.name);
      setPokemon(data.name);
    });

    fetch('/api/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "username": "andres",
        "password": "1234"
      })
    })
    .then((res) => Promise.all([res.json(), res.headers]))
    .then(([body, headers]) => {
      const authValue = headers.get('authorization');
      console.log(authValue);
      console.log(body);
    });
  })

   

  return (
    <div className="App">
      <MainSection pokemonName={pokemon}/>
    </div>
  );
}

export default App;
