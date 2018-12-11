import axios from 'axios';
import querystring from 'querystring'
import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'

export class OwnerFormular extends Component{

    state = {

        lastname: '',
        firstname: '',
        address: '',
        city: '',
        telephone: '',
        error: '',

        lastnameState: true,
        firstnameState: true,
        addressState: true,
        cityState: true,
        telephoneState: true,
        errorState: true
    };

    componentWillMount(){
        this.init();
    }

    init = () =>{
        if(this.props.location.state !== undefined) {
            this.setState({
                lastname: this.props.location.state.owner.lastname,
                firstname: this.props.location.state.owner.firstname,
                address: this.props.location.state.owner.address,
                city: this.props.location.state.owner.city,
                telephone: this.props.location.state.owner.telephone
            });
            console.log(this.props.location.state.owner.lastname);
        }
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

    handleSubmit = event => {
        event.preventDefault();

        this.setState({
            lastnameState: this.validInput(this.state.lastname),
            firstnameState: this.validInput(this.state.firstname),
            addressState: this.validInput(this.state.address),
            cityState: this.validInput(this.state.city),
            telephoneState: this.validInput(this.state.telephone),
            error:'',
        });
        const owner = querystring.stringify({
            id: this.props.location.state !== undefined ? this.props.location.state.owner.id : '-1',
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
        axios.post('http://localhost:8080/api/v1/addOwner', owner, config)
            .then(res => {
                this.setState({
                    errorState:false
                });
            })
            .catch((error) => {
                console.log(error.response.data);
                if(error.response.data === "TelephoneNumberNotValid"){
                    this.setState({
                        telephoneState: false,
                        error:"Telephone number not valid",
                    })
                }else {
                    this.setState({
                        error: "One or more field unfilled"
                    })
                }
                this.setState({
                    errorState:true
                })
            });
    };

    renderRedirect = () => {
        console.log(this.state.errorState);
        if(!this.state.errorState){
            return <Redirect to='/owners'/>
        }
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
                <div className="textError">{this.state.error}</div>
                {this.renderRedirect()}
                <input type="submit" value={this.props.location.state !== undefined ? "Update owner" : "Add owner"}/>
            </form>
            </div>
        )
    }
}

export default OwnerFormular;