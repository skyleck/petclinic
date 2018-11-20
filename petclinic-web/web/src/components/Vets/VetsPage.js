import axios from 'axios'
import Vet from './Vet'
import React, { Component } from 'react'

export default class VetsPage extends Component{
    state = {
        vets:[],
        images:[]
    }

    getVets = async() => {
        const response = await axios.get('http://localhost:8080/api/v1/vets')
        return await response
    }

    setVets = () => {
        this.getVets()
            .then((response)=> {
                let vets = []
                response.data.forEach(vet => {
                    vets.push(
                        <Vet key={vet.lastname}{...vet}/>
                    )
                });
                console.log(vets)
                this.setState({vets})
            })
    }

    componentWillMount(){
        this.setVets()
    }

    render(){
        return(
            <div class="container">
                <div class="vetsView">
                    {this.state.vets}
                </div>
            </div>
        )
    }
}