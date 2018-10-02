import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import './HomebrewsEdit.css';

class HomebrewsEdit extends Component {

  emptyBeer = {
    beerId: 3,
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
//    if (this.props.match.params.beerId !== 'new') {
//      const beer = await fetch(`/api/homebrews/${this.props.match.params.id}`);
//      this.setState({item: beer});
//    }
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
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
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
            <Input type="text" name="beerId" id="beerId" value={item.beerId || ''}
                   onChange={this.handleChange} autoComplete="The Name..."/>
          </FormGroup>
          <FormGroup>
            <Label for="beerName" className="BeerLabels">Beer Name</Label>
            <Input type="text" name="beerName" id="beerame" value={item.beerName || ''}
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
            <Label for="og" className="BeerLabels">Original Gravity</Label>
            <Input type="number" name="og" id="og" value={item.originalGravity || ''}
                   onChange={this.handleChange} autoComplete="Original Gravity..."/>
          </FormGroup>
          <FormGroup>
            <Label for="fg" className="BeerLabels">Final Gravity</Label>
            <Input type="number" name="fg" id="fg" value={item.finalGravity || ''}
                   onChange={this.handleChange} autoComplete="Final Gravity..."/>
          </FormGroup>
          <FormGroup>
            <Label for="sg" className="BeerLabels">Specific Gravity</Label>
            <Input type="number" name="sg" id="sg" value={item.specificGravity || ''}
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