import React from "react";
import { useLocalState } from "../../util/useLocalStorage";
import { useState } from "react";

export default function LoginSection() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [jwt, setJwt] = useLocalState("", "jwt");

  function sendLoginRequest() {
    fetch("/api/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: username,
        password: password,
      }),
    })
      .then((res) => {
        if (res.status === 200) {
          return Promise.all([res.json(), res.headers]);
        } else {
          return Promise.reject("Wrong username or password");
        }
      })
      .then(([body, headers]) => {
        //   navigate user back to build tool after login
        setJwt(headers.get("authorization"));
        window.location.href = "/build";
      })
      .catch((message) => {
        //   alerts message to page (change to a modal maybe)
        alert(message);
      });
  }

  return (
    <div className="login-container">
      <div className="login-container__title">Log in</div>
      <label>Username</label>
      <input
        type="text"
        onChange={(event) => setUsername(event.target.value)}
      />
      <label>Password</label>
      <input
        type="password"
        onChange={(event) => setPassword(event.target.value)}
      />
      <button onClick={() => sendLoginRequest()}>Log in</button>
    </div>
  );
}
