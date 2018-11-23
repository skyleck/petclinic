import axios from 'axios'
import Owner from './Owner'
import React, { Component } from 'react'
import { Link,NavLink } from 'react-router-dom';

export class OwnerPage extends Component{

    state = {owners:[]}

    getOwner = async() => {
        const response = await axios.get('http://localhost:8080/api/v1/owners')
        return await response
    }

    setOwners = () => {
        this.getOwner()
            .then((response) => {
                let owners = []
                let i = 0;
                response.data.forEach(owner => {
                    owners.push(
                        <Owner key={owner.lastname}{...owner} i={i}/>
                    )
                    i++
                });
                console.log(owners)
                this.setState({owners})
        })
    }

    componentWillMount(){
        this.setOwners()
    }

    render(){
        return(
            <div className="container">
                <NavLink exact to="/addOwner"><button type="button">
                    Add Owner
                </button></NavLink>
                <div id="owners">
                    {this.state.owners}
                </div>
            </div>
        )
    }
}

export default OwnerPage;