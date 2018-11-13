import React from "react"
/*
interface Vet {
    lastname: string;
    firstname: string;
    speciality:string;
}
*/
/*
interface VetListProps{

}*/

/*
interface VetListState{
    vets: Array<Vet>;
    isLoading: boolean;
}
*/

export class Vets extends React.Component{

    /*constructor(props: VetListProps){
        super(props);

        this.state = {
            vets: [],
            isLoading: false
        };
    }*/

    //test
    state = {
        vets: [],
        isLoading: false
    }
    //fin du test

    componentDidMount(){
        this.setState({isLoading: true})
        fetch('http://localhost:8080/api/v1/vets')
            .then(response => response.json())
            .then(data => this.setState({vets: data, isLoading: false}));
    }

    render(){
        const {vets, isLoading} = this.state;

        if(isLoading){
            return <p>Loading...</p>;
        }

        return(
            <div>
                <h2>Veterinarians</h2>
                <table id="vets">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Specialities</th>
                        </tr>
                    </thead>
                    {vets.map((vet) =>
                        <tr>
                            <td>{vet.firstname} {vet.lastname}</td>
                            <td>{vet.speciality}</td>
                        </tr>
                    )}
                </table>
            </div>
        );
    }
}

export default Vets;