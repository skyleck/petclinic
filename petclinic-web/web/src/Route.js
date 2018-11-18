import * as React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { Route, Switch } from 'react-router';
import HomePage from './components/Home/HomePage'
import Vets from './components/Vets/Vets';

export default () => (
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={HomePage} />
            <Route path="/vets" component={Vets} />
        </Switch>
    </BrowserRouter>
)