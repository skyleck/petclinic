import React from 'react';
import axios from 'axios';
import ReactDOM from 'react-dom';
import { Link,NavLink } from 'react-router-dom';
import Owner from '../Owner/Owner';

const Pets = ({id,name,birthdate,birthdateString,type,ownerId}) => {

    let isDelete = false;
    let gear = 'gearWhite';
    let importGear = require('../../../public/'+gear+'.png');
    
    const pet = {
        id: id,
        name: name,
        birthdate: birthdate,
        birthdateString: birthdateString,
        type: type,
        ownerId: ownerId
    };
    
    const config = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Accept': 'application/json;'
        }
    };

    const deletePet = event => {
        axios.delete('http://localhost:8080/api/v1/deletePet', {
            params : { idPet : id }
        }, config)
            .then(res => {
                isDelete = true;
                ReactDOM.render(this,document.getElementById(id));
            })
    };
    
    let importImg = require('../../../public/Pets/'+type+'.png');

    return(
        <div>
            <div className={isDelete ? "petDelete" : "petsInfo"} id={id}>
                <img className="imgPet" src={importImg} alt=""/>
                <div>
                    <div><span>Name :</span> {name}</div>
                    <div><span>Birthdate :</span> {birthdateString}</div>
                    <div><span>Type :</span> {type}</div>
                </div>
                <div>
                    <NavLink exact to={{pathname: '/updatePet/', state:{pet:pet}}}>
                        <div className="updateButton">
                            <img src={importGear} alt=""/>
                        </div>
                    </NavLink>
                    <div onClick={deletePet} className="deleteButton">X</div>
                </div>
            </div>
        </div>
    )
}

export default Pets