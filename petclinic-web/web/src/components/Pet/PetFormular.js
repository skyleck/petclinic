import React, { Component } from 'react';
import axios from 'axios';
import querystring from 'querystring';

export class PetFormular extends Component{
    state = {
        name : '',
        type : '',
        birthdate : null,
        error:'',

        nameState: true,
        errorState:true
    }

    handleChange = event => {
        const target = event.target;
        const name = target.name;
        const value = target.value;
        this.setState({
            [name]: value
        });
    };
    
    validInput = (value) => {
        if(value === '')
            return false;
        return true
    };

    handleSubmit = event => {
        event.preventDefault();

        this.setState({
            nameState: this.validInput(this.state.name),
            error:''
        });

        const pet = querystring.stringify({
            name: this.state.name,
            type: this.state.type,
            birthdate: this.state.birthdate,
            ownerId: this.props.match.params.id
        });

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept': 'application/json;'
            }
        };

        axios.post('http://localhost:8080/api/v1/addPet', pet, config)
            .then(res => {
                this.setState({
                    errorState:false
                });
            })
            .catch((error => {
                this.setState({
                    error: "One or more field unfilled"
                })
                this.setState({
                    errorState: true
                })
            }))
    };
    
    render(){
        return(
            <div className="container">
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Name :
                        <input name="name" type="text" onChange={this.handleChange} className={this.state.nameState ? "myInput" : "error"}/>
                    </label>
                    <label>
                        birthdate :
                        <input name="birthdate" type="date" onChange={this.handleChange} className="myInput"/>
                    </label>
                    <label>
                        Type :
                        <input name="type" type="text" onChange={this.handleChange} className="myInput"/>
                    </label>
                    <div className="textError">{this.state.error}</div>
                    <input type="submit" value="Add pet"/>
                </form>
            </div>
        );
    }
}

export default PetFormular;