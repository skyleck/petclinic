import * as React from 'react';
import { Link,NavLink } from 'react-router-dom';

export default class Menu extends React.Component {
    render() {
        return (
            <nav id="navBar">
                <ul>
                    <li>
                    <NavLink class="navLink" exact to="/">
                        Home
                    </NavLink>
                    </li>
                    <NavLink class="navLink" exact to="/vets">
                    <li>
                        Veterinarians
                    </li>
                    </NavLink>
                </ul>
            </nav>
        );
    }
}