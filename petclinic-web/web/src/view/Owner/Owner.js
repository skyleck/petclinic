import React from 'react'

const Owner = ({lastname,firstname,address,city,telephone,pets}) => {

    const petsName = pets.map( pet =>
        pet.name + " "
    )

    return(
        <tr>
            <td>{lastname + ' ' + firstname}</td>
            <td>{address}</td>
            <td>{city}</td>
            <td>{telephone}</td>
            <td>{petsName}</td>
        </tr>
    )
}

export default Owner

