import * as React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { Route, Switch } from 'react-router';
import Vets from './components/Vets/Vets';

export default () => (
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Vets} />
            <Route path="/vets" component={Vets} />
        </Switch>
    </BrowserRouter>
)