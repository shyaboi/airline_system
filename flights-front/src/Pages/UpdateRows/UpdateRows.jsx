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

const Delete = (props) => {

  const [table, setTable] = useState("");
  const [value, setValue] = useState("");
  const [where, setWhere] = useState("");
  const [tableData, setTableData] = useState([]);
  //   const [fetchData, setFetchData] = useState([]);

  const poster = () => {
    let url = "http://localhost:5555/admin/updateRow";
    xhr.open("POST", url, true);
    xhr.setRequestHeader(
      "Content-Type",
      "application/json"
    );
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            alert(xhr.responseText);
        }
    }
    
    xhr.send(table+","+value+","+where.toString());
  };

  const fetcher = (route) => {
    let r = '/all'+ route.charAt(0).toUpperCase() + route.slice(1) + "s"
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
        </Row>
        <Row className="mt-5 card">
          Enter a table to update from
          <Input
            onChange={(e) => setTable(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Enter a table"
          />
        </Row>
        <Row className="mt-5 card">
          Enter value you want input
          <Input
            onChange={(e) => setValue(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Example: iata_id='ZZZ'"
          />
        </Row>
        <Row className="mt-5 card">
          Enter an identifier to find the row you want changed
          <Input
            onChange={(e) => setWhere(e.target.value)}
            onKeyDown={handleKeyDown}
            type="table"
            name="input"
            id="exampleEmail"
            placeholder="Example: id=1"
          />
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
                  value={n}>{n}
                  
                    </ListGroupItem>
                    </Col>
      )}
      </Row>
      </Container>
    </Container>
  );
};

export default Delete;
