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
var xhr = new XMLHttpRequest();

const Update = (props) => {

  const [table, setTable] = useState("");
  const [id, setID] = useState("");
  const [item, setItem] = useState("");
  const [value, setValue] = useState("");
  const [tableData, setTableData] = useState([]);
  //   const [fetchData, setFetchData] = useState([]);

  const poster = () => {
    let url = `http://localhost:5555/admin/${table}/${item}/${id}`;
    xhr.open("PUT", url, true);
    xhr.setRequestHeader(
      "Content-Type",
      "application/json"
    );
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            alert(xhr.responseText);
        }
    }
    
    xhr.send(value);
  };

  const fetcher = () => {
    let r = table
    fetchy(`http://localhost:5555/admin/${r}`).then(async (data) => {
      let d = await data;
      console.log(d)
      setTableData(d)
    });
  };


  const del = ()=> {

    poster()
    setTimeout(() => {
        
        fetcher(table)
    }, 100);

  }




  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      //   fetcher();
    }
  };

  return (
    <Container>
      <Container className="mt-5">
        <Row className="card">
          <h1>You are admin</h1>
        </Row>
        <Row className="card">
          <h3>Update Something</h3>
        </Row >
        <Row>
        <Col className="mt-5 card" >
          Enter a table to update from
          <Input
            onChange={(e) => setTable(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Enter a table"
          />
        </Col>
        <Col className="mt-5 card">
          Enter an identifier to find the item to be changed
          <Input
            onChange={(e) => setItem(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Example: id"
          />
        </Col>
          </Row>
          <Row>
        <Col className="mt-5 card">
          Enter the Value ID of the identifier to be changed
          <Input
            onChange={(e) => setID(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Example: 2"
          />
        </Col>
        
        <Col className="mt-5 card">
          Enter a value to change your found item to
          <Input
            onChange={(e) => setValue(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Example: 3"
          />
        </Col>
        </Row>
      </Container>
      <Row className="card">
        <Button  onClick={del}>Update Row</Button>
      </Row>
      <Container className="card mt-5">
            Info From {table}
      <Row className="mt-5">
      {tableData.map((n) =>
      <Col className="db">
        <ListGroupItem key={n.toString()}
                  className="card"
                  value={n}>{n.toString()}
                  
                    </ListGroupItem>
                    </Col>
      )}
      </Row>
      </Container>
    </Container>
  );
};

export default Update;
