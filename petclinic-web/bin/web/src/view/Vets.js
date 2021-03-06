import React from "react"

interface Vet {
    lastname: string;
    firstname: string;
    speciality:string;
}

interface VetListProps{

}

interface VetListState{
    vets: Array<Vet>;
    isLoading: boolean;
}

const Vetviw = ({vet}) => (
    <p>
    {vet.lastname}
</p>
)

export class Vets extends React.Component<VetListProps, VetListState>{

    constructor(props: VetListProps){
        super(props);

        this.state = {
            vets: [],
            isLoading: false
        };
    }

    componentDidMount(){
        this.setState({isLoading: true})
        fetch('http://192.198.99.100:8080/api/v1/vets')
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
        {vets.map((vet: Vet) =>
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