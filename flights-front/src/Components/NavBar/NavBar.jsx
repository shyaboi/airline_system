import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
import React, { useState } from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText
} from 'reactstrap';
import Login from '../../Pages/Login/Login'
import GetAll from '../../Pages/GetAllDB/GetAllDB'


const NavBar = (props) => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
      <Router>
    <div>
      <Navbar color="light" light expand="md">
        <NavbarBrand href="/">Welcome Admin</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink href="/getALL">Select All DB</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/login">Login</NavLink>
            </NavItem>
           
          </Nav>
          <NavbarText>Utopia Airlines</NavbarText>
        </Collapse>
      </Navbar>




    </div>
      <Switch>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/getAll">
            <GetAll />
          </Route>
        </Switch>
    </Router>
  );
}

export default NavBar;