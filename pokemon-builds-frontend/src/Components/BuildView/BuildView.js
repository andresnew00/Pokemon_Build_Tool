import React, { useEffect } from "react";

import { useLocalState } from "../../util/useLocalStorage";

export default function BuildView() {
  const buildId = window.location.href.split("/builds/")[1];

  const [build, setBuild] = React.useState(null);
  const [jwt, setJwt] = useLocalState("", "jwt");


  useEffect(() => {
    fetch(`/api/builds/${buildId}`, {
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
        setBuild(buildData);
    });
  }, []);

  return (
    <div>
      <h1>Build {buildId} this page is where the build will be and where you can modify it</h1>
      {build ? (
        <>
          {" "}
          <h2>Pokemon Name: {build.pokemonName}</h2>
        </>
      ) : (
        <></>
      )}
    </div>
  );
}
