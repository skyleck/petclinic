import React from 'react'
import Pet from '../Pet/Pet'

const Owner = ({lastname,firstname,address,city,telephone,pets,i}) => {

    const petsHTML = pets.map( pet =>
        <Pet key={pet.name}{...pet}/>
    )

    const getMod = i % 2;

    return(
        <div class="ownerPet">
            <div class={"owner" + getMod}>
                <div>
                    <div class="title">Name: </div>{lastname + ' ' + firstname}
                    <div class="title">Adress: </div> {address}
                </div>
                <div>
                    <div class="title">City: </div> {city}
                    <div class="title">Telephone: </div> {telephone}
                </div>
            </div>
            <div class="pets">
                {petsHTML}
            </div>
        </div>
    )
}

export default Owner

