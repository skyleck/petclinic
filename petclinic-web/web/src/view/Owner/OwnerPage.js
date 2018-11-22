import axios from 'axios'
import Owner from './Owner'
import React, { Component } from 'react'

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
            <div>
                <h2>Owners</h2>
                <div id="owners">
                    {this.state.owners}
                </div>
            </div>
        )
    }
}

export default OwnerPage;