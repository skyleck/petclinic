import * as React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { Route, Switch } from 'react-router';
import HomePage from './components/Home/HomePage'
import Vets from './components/Vets/VetsPage';
import Owners from './components/Owner/OwnerPage'
import Menu from './components/Menu/Menu'

export default () => (
    <BrowserRouter>
        <div>
            <Menu />
            <Switch>
                <Route exact path="/" component={HomePage} />
                <Route path="/vets" component={Vets} />
                <Route path="/owners" component={Owners} />
            </Switch>
        </div>
    </BrowserRouter>
)