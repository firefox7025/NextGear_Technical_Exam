import React, {Component} from "react";
import "../css/App.css";
import "../css/font-awesome.min.css";
import Form from "../../../components/CreateStudentForm/js/Form"


function footer() {
    return (
        <footer id="footer">
            <span>NextGear Technical Exam</span>
        </footer>
    );
}



class App extends Component {
    render() {
        return (
            <div id="wrapper">
                <div id="bg"></div>
                <div id="overlay"></div>
                <div id="main">
                    <header id="header">
                        <h1>NextGear Student Registry</h1>
                        <nav>
                            <ul>
                                <li><a href="#">Create</a></li>
                                <li><a href="#">Read</a></li>
                                <li><a href="#">Update</a></li>
                                <li><a href="#">Delete</a></li>
                            </ul>
                        </nav>
                        <Form/>
                    </header>
                    {footer()}
                </div>
            </div>
        );
    }
}


export default App;
