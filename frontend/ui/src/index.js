import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap-theme.css';



// There are multiple ways to implement this component. This is one.
var VacancySign = React.createClass({
    render: function() {
        var text;
        if (this.props.hasvacancy) {
            text = 'Vacancy';
        } else {
            text = 'No Vacancy';
        }
        return <div>{text}</div>;
    }
});

/**
 // Here is another implementation.
 var VacancySign = React.createClass({
  render: function() {
    // Notice how we use a ternary expression, which is a valid JavaScript expression.
    // Uncomment and try using this implementation. Inspect the DOM result. How is it different?
    return <div>{this.props.hasvacancy ? '' : 'No '}Vacancy</div>;
  }
});
 **/


ReactDOM.render(
    <VacancySign hasvacancy={true} />,
    document.getElementById('container')
);
