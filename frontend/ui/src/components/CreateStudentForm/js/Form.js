import React from "react";
import "../css/StudentForm.css";

class Form extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isGoing: true,
            firstName: 'firstName',
            lastName: 'lastName'
        };

        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    render() {
        return (
            <form action="http://localhost:8080/students"  method="get">
                <br />
                <label>
                    First Name: &nbsp;&nbsp;&nbsp;&nbsp;
                    <input
                        name="firstName"
                        type="text"
                        value={this.state.firstName}
                        style={{height: 40, borderColor: 'gray', borderWidth: 1, color: 'black'}} />
                </label>
                <br />
                <label>
                    Last Name: &nbsp;&nbsp;&nbsp;&nbsp;
                    <input
                        name="lastName"
                        type="text"
                        value={this.state.lastName}
                        style={{height: 40, borderColor: 'gray', borderWidth: 1, color: 'black'}} />
                </label>
                <br /><br />
                <input
                    value="Submit"
                    type="submit"
                    style={{height: 40, width: 140, borderColor: 'gray', borderWidth: 1, color: 'black'}}/>
            </form>
        );
    }
}

export default Form;