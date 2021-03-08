import React, { useState } from "react";
import {
  Button,
  Input,
  Container,
  Col,
  Row,
  ListGroupItem,
} from "reactstrap";

import fetchy from "../../Utils/Fetcher";

const GetAllDB = (props) => {
  const [route, setRoute] = useState("");
  const [fetchData, setFetchData] = useState([]);

  const fetcher = (r) => {
    r = "/all" + route.charAt(0).toUpperCase() + route.slice(1) + "s";
    fetchy(`http://localhost:5555/admin/${r}`).then(async (data) => {
      let d = await data;
      setFetchData(d);
    });
  };

  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      fetcher();
    }
  };

  return (
    <Container>
      <Container className="mt-5">
        <Row className="card">
          <h1>You are admin</h1>
        </Row>
        <Row className="card">
          <h3>Get all the things</h3>
        </Row>
        <Row className="mt-5 card">
          Enter what you want all of
          <Input
            onChange={(e) => setRoute(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Enter a table"
          />
        </Row>
      </Container>
      <Row className="card">
        <Button onClick={fetcher}>Get All</Button>
      </Row>
      <Container className="card mt-5">
        Info From {route}
        <Row className="mt-5">
          {fetchData.map((n) => (
            <Col className="db">
              <ListGroupItem key={n.toString()} className="card" value={n}>
                {n}
              </ListGroupItem>
            </Col>
          ))}
        </Row>
      </Container>
    </Container>
  );
};

export default GetAllDB;
