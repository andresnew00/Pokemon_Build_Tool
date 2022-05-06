/* eslint-disable react-hooks/rules-of-hooks */
import React, { useEffect } from "react";
import { useLocalState } from "../../../util/useLocalStorage";
import { useState } from "react";
import { Link } from "react-router-dom";

export default function mainSection(props) {
  const [jwt, setJwt] = useLocalState("", "jwt");
  const [builds, setBuilds] = useState(null);

  useEffect(() => {
    fetch("/api/builds", {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${jwt}`,
      },
      method: "GET",
    })
      .then((res) => {
        if (res.status === 200) {
          return res.json();
        }
      })
      .then((buildData) => {
        setBuilds(buildData);
      });
  }, []);

  function createBuild() {
    fetch("api/builds", {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${jwt}`,
      },
      method: "POST",
    })
      .then((res) => {
        if (res.status === 200) {
          return res.json();
        }
      })
      .then((build) => {
        window.location.href = `/builds/${build.id}`;
        console.log(build);
      });
  }
  return (
    <>
      <h1>Hello {props.pokemonName}!</h1>
      <div>
        {builds ? builds.map((build) => <p><Link to={`/builds/${build.id}`}>build #{build.id}</Link></p>) : <div></div>}
      </div>
      <button onClick={() => createBuild()}>Submit New Build</button>
    </>
  );
}
