import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, ButtonGroup, Container, Form, FormGroup, Input, Label } from 'reactstrap';

class City extends Component {

  city = {
    id: '',
    name: '',
    radius: ''
  }

  constructor(props) {
    super(props);
    this.state = {
      item: this.city
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
      const target = event.target;
      const value = target.value;
      const name = target.name;
      let item = {...this.state.item};
      item[name] = value;
      this.setState({item});
    }

  async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;
    await fetch('http://localhost:8082/api/City', {
      method: (item.beerId) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      mode: 'cors',
      body: JSON.stringify(item),
    });
  }

  render() {
    const {item} = this.state;
    return <div>
      <Container>
        <Form onSubmit={this.handleSubmit}>
        <FormGroup>
             <Label for="name">City</Label>
             <Label className = "name" onChange={this.handleChange}>{item.id}</Label>
             <Label type="number" name="id" id="id" value={item.id || ''}
                   onChange={this.handleChange} autoComplete="The Name..."/>
             </FormGroup>
          <FormGroup>
            <Input type="text" name="name" id="name"
                   onChange={this.handleChange} autoComplete="The Name..."/>
          </FormGroup>
          <FormGroup>
            <Label for="radius">Radius (miles)</Label>
            <Input type="number" name="radius" id="radius"
                   onChange={this.handleChange} autoComplete="The Name..."/>
          </FormGroup>
          <ButtonGroup>
              <Button color="primary" type="submit">Save</Button>{' '}
              <Button color="secondary" tag={Link} to="/Breweries">Breweries</Button>
              <Button color="secondary" tag={Link} to="/Homebrews">Home</Button>
          </ButtonGroup>
        </Form>
      </Container>
    </div>
  }
}

export default City;