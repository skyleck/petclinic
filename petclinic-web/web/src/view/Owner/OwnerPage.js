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
                response.data.forEach(owner => {
                    owners.push(
                        <Owner key={owner.lastname}{...owner}/>
                    )
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
                <table>
                    <thead>
                        <tr >
                            <th class="th4">Name</th>
                            <th class="th4">Address</th>
                            <th class="th4">City</th>
                            <th class="th4">Telephone</th>
                            <th class="th4">Pets</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.owners}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default OwnerPage;