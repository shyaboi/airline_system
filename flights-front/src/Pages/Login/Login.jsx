import React, { useState, useEffect } from "react";

import {
  Col,
  Row,
  Button,
  Form,
  FormGroup,
  Label,
  Input,
  Container,
  Card,
  CardImg,
  CardText,
  CardBody,
  CardTitle,
  CardSubtitle,
  NavLink
} from "reactstrap";
import plane from '../../assets/images/plane.png'

const Login = (props) => {
  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const [auth, setAuth] = useState(Boolean);
  const [ninja, SetNinja] = useState("ninja");

const ok = ()=> {
  if (user&&password!="admin"){
  alert("You are clearly not an admin\nTry again...")}
  if (user&&password==="admin"){
    setAuth(true)
    SetNinja("ninjaVanish")
}}

useEffect(() => {
    if(ninja==="ninjaVanish")SetNinja("ninjaVanish")
},[]);

  return (
    <Container className={ninja}>
      <Row className={ninja}>
        <Col md={{size: 6, offset:3}} className={ninja}>
       <Card className={ninja}>
        <CardImg top className="img-fluid" src={plane} alt="Card image cap" />
        <CardBody>
          <CardTitle tag="h5">Utopia Airlines</CardTitle>
          <CardSubtitle tag="h6" className="mb-2 text-muted">Admin Login</CardSubtitle>
          <CardText>Login with your admin credentials below</CardText>
        </CardBody>
      </Card>
      </Col>
      </Row>
      <Row>
        <Col>
      <Form>
        <FormGroup>
          <Label for="exampleEmail">Username</Label>
          <Input
            onChange={(e) => setUser(e.target.value)}
            type="email"
            name="email"
            id="exampleEmail"
            placeholder="Employee"
          />
        </FormGroup>
        <FormGroup>
          <Label for="examplePassword">Password</Label>
          <Input
            onChange={(e) => setPassword(e.target.value)}
            type="password"
            name="password"
            id="examplePassword"
            placeholder="P@ssword!123"
          />
        </FormGroup>
       <NavLink redirect href="/getAll" > 
       <Button onClick={ok}>Submit</Button>
        </NavLink>
      </Form>
      </Col>
      </Row>
    </Container>
  );
};

export default Login;
