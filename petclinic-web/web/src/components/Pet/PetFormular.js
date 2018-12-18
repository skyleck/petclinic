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
        typeState: true,
        errorState:true
    };

    componentWillMount(){
        this.init();
    }

    init = () =>{
        if(this.props.location.state !== undefined) {
            this.setState({
                name: this.props.location.state.pet.name,
                type: this.props.location.state.pet.type,
                birthdate: this.props.location.state.pet.birthdate
            });
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
            nameState: this.validInput(this.state.name),
            error:''
        });

        console.log(this.state.type);
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

        if(this.props.location.state !== undefined) {
            axios.put('http://localhost:8080/api/v1/updateOwner', pet, config)
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
        }
        else {
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
        }
    };
    
    render(){
        return(
            <div className="container">
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Name :
                        <input name="name" type="text" onChange={this.handleChange} className={this.state.nameState ? "myInput" : "error"} value={this.state.name}/>
                    </label>
                    <label>
                        birthdate :
                        <input name="birthdate" type="date" onChange={this.handleChange} className="myInput" value={this.state.birthdate}/>
                    </label>
                    <label>
                        Type:
                        <select name="type" value={this.state.type} onChange={this.handleChange} className="myInput">
                            <option value="bird">Bird</option>
                            <option value="cat">Cat</option>
                            <option value="dog">Dog</option>
                            <option value="hamster">Hamster</option>
                            <option value="lizard">Lizard</option>
                            <option value="rabbit">Rabbit</option>
                            <option value="snake">Snake</option>
                        </select>
                    </label>
                    <div className="textError">{this.state.error}</div>
                    <input type="submit" value={this.props.location.state !== undefined ? "Update pet" : "Add pet"}/>
                </form>
            </div>
        );
    }
}

export default PetFormular;