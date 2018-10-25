import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import './HomebrewsEdit.css';

//TODO: Add some backend validation check for this
let idCount = 0;

class HomebrewsEdit extends Component {

  emptyBeer = {
    beerId: '',
    beerName: '',
    beerStyle: '',
    description: '',
    usedOnlineRecipe: '',
    abv: '',
    originalGravity: '',
    finalGravity: '',
    specificGravity: ''
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyBeer
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

//  async componentDidMount() {
//    fetch('http://localhost:8082/api/homebrews/' + this.emptyBeer.beerId)
//          .then(response => response.json())
//          .then(data => this.setState({beers: data, isLoading: false}));
//          console.log(this.props.match.params.id);
//  }

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
    await fetch('http://localhost:8082/api/homebrews', {
      method: (item.beerId) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      mode: 'cors',
      body: JSON.stringify(item),
    });
    this.props.history.push('/homebrews');
  }

  render() {
    const {item} = this.state;
    const title = <h2>{item.beerId ? 'Edit Homebrew' : 'Add Homebrew'}</h2>;
    return <div>
      <Container>
       {title}
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label for="beerId" className="BeerLabels">Beer Id</Label>
            <Label className = "BeerLabels" onChange={this.handleChange}>{item.beerId}</Label>
            <Label type="number" name="beerId" id="beerId" value={item.beerId || ''}
                   onChange={this.handleChange} autoComplete="The Name..."/>
          </FormGroup>
          <FormGroup>
            <Label for="beerName" className="BeerLabels">Beer Name</Label>
            <Input type="text" name="beerName" id="beerame"
                   onChange={this.handleChange} autoComplete="The Name..."/>
          </FormGroup>
          <FormGroup>
            <Label for="beerStyle" className="BeerLabels">Beer Style</Label>
            <Input type="text" name="beerStyle" id="beerStyle" value={item.beerStyle || ''}
                   onChange={this.handleChange} autoComplete="A Beer..."/>
          </FormGroup>
          <FormGroup>
            <Label for="desc" className="BeerLabels">Description</Label>
            <Input type="text" name="description" id="desc" value={item.description || ''}
                   onChange={this.handleChange} autoComplete="Description..."/>
          </FormGroup>
          <FormGroup>
            <Label for="abv" className="BeerLabels">ABV</Label>
            <Input type="number" name="abv" id="abv" value={item.abv || ''}
                   onChange={this.handleChange} autoComplete="ABV..."/>
          </FormGroup>
          <FormGroup>
            <Label for="originalGravity" className="BeerLabels">Original Gravity</Label>
            <Input type="number" name="originalGravity" id="originalGravity" value={item.originalGravity || ''}
                   onChange={this.handleChange} autoComplete="Original Gravity..."/>
          </FormGroup>
          <FormGroup>
            <Label for="finalGravity" className="BeerLabels">Final Gravity</Label>
            <Input type="number" name="finalGravity" id="finalGravity" value={item.finalGravity || ''}
                   onChange={this.handleChange} autoComplete="Final Gravity..."/>
          </FormGroup>
          <FormGroup>
            <Label for="specificGravity" className="BeerLabels">Specific Gravity</Label>
            <Input type="number" name="specificGravity" id="specificGravity" value={item.specificGravity || ''}
                   onChange={this.handleChange} autoComplete="Specific Gravity..."/>
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/homebrews">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  }
}

export default withRouter(HomebrewsEdit);