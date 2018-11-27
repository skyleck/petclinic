import axios from 'axios';
import querystring from 'querystring'
import React, { Component } from 'react'

export class OwnerFormular extends Component{

    state = {
        lastname: '',
        firstname: '',
        address: '',
        city: '',
        telephone: '',

        lastnameState:true,
        firstnameState:true,
        addressState:true,
        cityState:true,
        telephoneState:true
    };

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

    validForm = () => {
        return this.state.lastnameState && this.state.firstnameState && this.state.addressState
                && this.state.cityState && this.state.telephoneState;
    };

    handleSubmit = event => {
        event.preventDefault();

        this.setState({
            lastnameState: this.validInput(this.state.lastname),
            firstnameState: this.validInput(this.state.firstname),
            addressState: this.validInput(this.state.address),
            cityState: this.validInput(this.state.city),
            telephoneState: this.validInput(this.state.telephone),
        });
        console.log(this.validInput(this.state.address));
        console.log(this.state.addressState);
        console.log(this.validForm());
        if(this.validForm()) {
            const owner = querystring.stringify({
                id: '-1',
                lastname: this.state.lastname,
                firstname: this.state.firstname,
                address: this.state.address,
                city: this.state.city,
                telephone: this.state.telephone
            });

            const config = {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'Accept': 'application/json;'
                }
            };
            console.log({owner});
            axios.post('http://localhost:8080/api/v1/addOwner', owner, config)
                  .catch((error) => {
                    console.log(error.response.data);
                    if(error.response.data === "TelephoneNumberNotValid"){
                        this.setState({
                            telephoneState: false
                        })
                    }
                });
        }
    };

    changeColor = () => {
        this.setState({
            test: !this.state.test
        })
    };

    render(){
        return(
            <div className="container">
            <form onSubmit={this.handleSubmit}>
                <label>
                    Lastname:
                    <input name="lastname" type="text" className={this.state.lastnameState ? " myInput" : "error"} value={this.state.lastname} onChange={this.handleChange} />
                </label>
                <label>
                    Firstname:
                    <input name="firstname" type="text" className={this.state.firstnameState ? " myInput" : "error"} value={this.state.firstname} onChange={this.handleChange}/>
                </label>
                <label>
                    Address:
                    <input name="address" type="text" className={this.state.addressState ? " myInput" : "error"} value={this.state.address} onChange={this.handleChange}/>
                </label>
                <label>
                    City:
                    <input name="city" type="text" className={this.state.cityState ? " myInput" : "error"} value={this.state.city} onChange={this.handleChange}/>
                </label>
                <label>
                    Telephone:
                    <input name="telephone" type="text" className={this.state.telephoneState ? " myInput" : "error"} value={this.state.telephone} onChange={this.handleChange}/>
                </label>
                <input type="submit" value="Add owner"/>
            </form>
            </div>
        )
    }
}

export default OwnerFormular;