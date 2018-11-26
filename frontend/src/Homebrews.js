import * as React from 'react';
import './Homebrews.css';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

class Homebrews extends React.Component{

  constructor(props) {
    super(props);

    this.state = {
      beers: [],
      isLoading: false
    };

    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8082/api/homebrews')
      .then(response => response.json())
      .then(data => this.setState({beers: data, isLoading: false}));
  }

  async remove(beerId) {
      await fetch('http://localhost:8082/api/homebrews/' + beerId, {
        method: 'DELETE',
        mode: 'cors',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      }).then(() => {
        let updatedBeers = [...this.state.beers].filter(i => i.beerId !== beerId);
        this.setState({beers: updatedBeers});
      });
    }

  render() {
    const {beers, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="Brew-Data">

      <Container fluid>
        <div className = "AddHomebrew">
        <ButtonGroup>
            <Button color="success" tag={Link} to="/homebrews/new">Add Homebrew</Button>
            <Button color="secondary" tag={Link} to="/Breweries">Breweries</Button>
            <Button color="secondary" tag={Link} to="/City">City</Button>
            <Button color="secondary" tag={Link} to="/Commercials">Commercials</Button>
        </ButtonGroup>
        </div>
      </Container>

        {beers.map((beer: Homebrews) =>
        <div key={beer.id} className="Square">
          <div key={beer.id} className="Data">
            <h2>{beer.beerName}</h2>
            Beer Style: {beer.beerStyle} <br/>
            ABV: {beer.abv}% <br/>
            Original Gravity: {beer.originalGravity} <br/>
            Final Gravity: {beer.finalGravity} <br/>
            Description: {beer.description} <br/> <br/>
            Average Abv: {beer.avgAbv} <br/> <br/>
            <Button size="sm" color="danger" onClick={() => this.remove(beer.beerId)}>Delete</Button>
          </div>
        </div>
        )}
      </div>
    );
  }
}

export default Homebrews;