import React from 'react'

const Pets = ({name,birthdate,type}) => {

    let importImg = require('../../../public/Pets/'+type+'.png')

    return(
        <div>
            <div className="petsInfo">
                <img src={importImg} alt=""/>
                <div>
                    <div><span>Name :</span> {name}</div>
                    <div><span>Birthdate :</span> {birthdate}</div>
                    <div><span>Type :</span> {type}</div>
                </div>
            </div>
        </div>
    )
}

export default Pets