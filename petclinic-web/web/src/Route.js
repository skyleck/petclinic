import * as React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { Route, Switch } from 'react-router';
import HomePage from './components/Home/HomePage'
import Vets from './components/Vets/VetsPage';
import Owners from './components/Owner/OwnerPage';
import AddOwner from './components/Owner/OwnerFormular';
import AddPet from './components/Pet/PetFormular';
import Menu from './components/Menu/Menu';

export default () => (
    <BrowserRouter>
        <div>
            <Menu />
            <Switch>
                <Route exact path="/" component={HomePage} />
                <Route path="/vets" component={Vets} />
                <Route path="/owners" component={Owners} />
                <Route path="/addOwner" component={AddOwner}/>
                <Route path="/updateOwner/" component={AddOwner} owner = {(props) => { return this.location.state}}/>
                <Route path="/addPet/:id" component={AddPet}/>
                <Route path="/updatePet/" component={AddPet} pet = {(props) => { return this.location.state}}/>
            </Switch>
        </div>
    </BrowserRouter>
)