import React from "react";
import { Navigate } from "react-router-dom";
import { useLocalState } from "../util/useLocalStorage";

export default function PrivateRoute({ children }) {
  const [jwt, setJwt] = useLocalState("", "jwt");
  return jwt ? children : <Navigate to={"/login"} />;
}
