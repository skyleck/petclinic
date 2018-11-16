import React from 'react'

const Owner = ({lastname,firstname,address,city,telephone}) => {
    return(
        <tr>
            <td>{lastname + ' ' + firstname}</td>
            <td>{address}</td>
            <td>{city}</td>
            <td>{telephone}</td>
        </tr>
    )
}

export default Owner

