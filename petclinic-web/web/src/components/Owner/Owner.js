import React from 'react'
import Pet from '../Pet/Pet'
import { Link,NavLink } from 'react-router-dom';

const Owner = ({id,lastname,firstname,address,city,telephone,pets,i}) => {

    const petsHTML = pets.map( pet =>
        <Pet key={pet.name}{...pet}/>
    )

    const getMod = i % 2;

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
                        <NavLink  exact to="/updateOwner">
                            <div className="updateButton"></div>
                        </NavLink>
                        <div className="deleteButton">X</div>
                    </div>
                    <div className="addButton">+</div>
                </div>
            </div>
            <div className="pets">
                {petsHTML}
            </div>
        </div>
    )
}

export default Owner

