import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import TodoApp from './TodoApp'
import './index.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap-theme.css';


ReactDOM.render(
    <App/>,
    document.getElementById('root')
);

ReactDOM.render(
    <TodoApp/>,
    document.getElementById('bar')
)
