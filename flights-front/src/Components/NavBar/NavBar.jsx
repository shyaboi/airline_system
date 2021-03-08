import {
    BrowserRouter as Router,
    Switch,
    Route,
    Redirect
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
  NavbarText
} from 'reactstrap';
import Login from '../../Pages/Login/Login'
import GetAll from '../../Pages/GetAllDB/GetAllDB'
import Delete from "../../Pages/DeleteRows/DeleteRows";
import Add from "../../Pages/AddRows/AddRows";


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
              <NavLink href="/delete">Delete from DB</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/add">Add to DB</NavLink>
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
      <Route exact path="/">
    <Redirect to="/login" />
</Route>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/getAll">
            <GetAll />
          </Route>
          <Route path="/delete">
            <Delete />
          </Route>
          <Route path="/add">
            <Add />
          </Route>
        </Switch>
    </Router>
  );
}

export default NavBar;