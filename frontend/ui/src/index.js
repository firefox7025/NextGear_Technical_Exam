import React from "react";
import ReactDOM from "react-dom";
import App from "./components/Home/js/App";
import TodoApp from "./components/TodoApp";
import "./index.css";


ReactDOM.render(
    <App/>,
    document.getElementById('root')
);

ReactDOM.render(<TodoApp />, document.getElementById('todo'));