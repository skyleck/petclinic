import React from 'react'
import Pet from '../Pet/Pet'
import { Link,NavLink } from 'react-router-dom';

const Owner = ({id,lastname,firstname,address,city,telephone,pets,i}) => {

    let gear = 'gearWhite';
    let importImg = require('../../../public/'+gear+'.png');

    const petsHTML = pets.map( pet =>
        <Pet key={pet.name}{...pet}/>
    );

    const getMod = i % 2;

    const owner = {
        id: id,
        lastname: lastname,
        firstname: firstname,
        address: address,
        city: city,
        telephone: telephone,
    };

    return(
        <div className="ownerPet">
            <div className={"owner" + getMod}>
                <div>
                    <div className="title">Name: </div>{lastname + ' ' + firstname}
                    <div className="title">Adress: </div> {address}
                </div>
                <div>
                    <div className="title">City: </div> {city}
                    <div className="title">Telephone: </div> {telephone}
                </div>
                <div className="buttonContainer">
                    <div className="buttonsOwner">
                        <NavLink exact to={{pathname: '/updateOwner/', state:{owner:owner}}}>
                            <div className="updateButton">
                                <img src={importImg} alt=""/>
                            </div>
                        </NavLink>
                        <div className="deleteButton">X</div>
                    </div>
                    <a href={`/addPet/${id}`} className="addButton">+</a>
                </div>
            </div>
            <div className="pets">
                {petsHTML}
            </div>
        </div>
    )
};

export default Owner

