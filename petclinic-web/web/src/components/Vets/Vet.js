import React from 'react'

const Vet = ({lastname,firstname,speciality}) => {
    let importImg = require('../../../public/Vets/'+lastname+'.jpg')
    return(
        <div>
        <figure>
            <img src={importImg} alt=""/>
            <figcaption>
                <div>{lastname + " " + firstname}</div>
                <div>{speciality}</div>
            </figcaption>
        </figure>
        </div>
    )
}

export default Vet