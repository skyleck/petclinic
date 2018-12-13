import React from 'react';
import axios from 'axios';
import ReactDOM from 'react-dom';


const Pets = ({id,name,birthdate,type}) => {

    let isDelete = false;
    
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
                console.log("yo");
                isDelete = true;
                ReactDOM.render(this,document.getElementById(id));
            })
    };
    
    let importImg = require('../../../public/Pets/'+type+'.png')

    return(
        <div>
            <div className={isDelete ? "petDelete" : "petsInfo"} id={id}>
                <img src={importImg} alt=""/>
                <div>
                    <div><span>Name :</span> {name}</div>
                    <div><span>Birthdate :</span> {birthdate}</div>
                    <div><span>Type :</span> {type}</div>
                </div>
                <div>
                    <div onClick={deletePet} className="deleteButton">X</div>
                </div>
            </div>
        </div>
    )
}

export default Pets