import * as React from 'react';
import { Link,NavLink } from 'react-router-dom';

export default class Menu extends React.Component {
    render() {
        return (
            <nav id="navBar">
                <ul>
                    <li>
                    <NavLink id="home" className={window.location.href == "http://localhost:3000/" ? "active" : "#navLink"} exact to="/">
                        <p>
                            Home
                        </p>
                    </NavLink>
                    </li>
                    <li>
                        <NavLink className={window.location.href == "http://localhost:3000/vets/" ? "active" : "#navLink"} exact to="/vets">
                            <p>
                                Veterinarians
                            </p>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink className={window.location.href == "http://localhost:3000/owners/" ? "active" : "#navLink"} exact to="/owners">
                            <p>
                                Owners
                            </p>
                        </NavLink>
                    </li>
                </ul>
            </nav>
        );
    }
}