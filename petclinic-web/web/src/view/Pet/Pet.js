import React from 'react'

const Pets = ({name,birthdate,type}) => {
    return(
        <div>
            <div>
                name : {name}
                birthdate : {birthdate}
                typepet : {type}
            </div>
        </div>
    )
}

export default Pets