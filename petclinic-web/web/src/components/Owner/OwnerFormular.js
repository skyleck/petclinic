import axios from 'axios';
import querystring from 'querystring'
import React, { Component } from 'react'

export class OwnerFormular extends Component{
    state = {
        lastname: '',
        firstname: '',
        address: '',
        city: '',
        telephone: ''
    };

    handleChange = event => {
        const target = event.target;
        const name = target.name;
        const value = target.value;
        this.setState({
            [name]: value
        });
    }

    handleSubmit = event => {
        event.preventDefault();

        const owner = querystring.stringify({
            id: "-1",
            lastname: this.state.lastname,
            firstname: this.state.firstname,
            address: this.state.address,
            city: this.state.city,
            telephone: this.state.telephone,
            end : "null"
        });

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept': 'application/json;'
            }
        };
        console.log({owner});
        axios.post('http://localhost:8080/api/v1/addOwner',{owner},config)
    }

    render(){
        return(
            <form onSubmit={this.handleSubmit}>
                <label>
                    Lastname:
                    <input name="lastname" type="text" value={this.state.lastname} onChange={this.handleChange} />
                </label>
                <label>
                    Firstname:
                    <input name="firstname" type="text" value={this.state.firstname} onChange={this.handleChange}/>
                </label>
                <label>
                    Address:
                    <input name="address" type="text" value={this.state.address} onChange={this.handleChange}/>
                </label>
                <label>
                    City:
                    <input name="city" type="text" value={this.state.city} onChange={this.handleChange}/>
                </label>
                <label>
                    Telephone:
                    <input name="telephone" type="text" value={this.state.telephone} onChange={this.handleChange}/>
                </label>
                <input type="submit" value="Add owner"/>
            </form>
        )
    }
}

export default OwnerFormular;