import * as React from 'react';
import './Homebrews.css';
import axios from 'axios';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';

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
  console.log(beerId);
      await fetch('api/homebrews/3', {
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
        <h2>Homebrew List</h2>
        {beers.map((beer: Homebrews) =>
        <div key={beer.id} className="Square">
          <div key={beer.id} className="Data">
            <h2>{beer.beerName}</h2>
            Beer Style: {beer.beerStyle} <br/>
            ABV: {beer.abv}% <br/>
            Original Gravity: {beer.originalGravity} <br/>
            Final Gravity: {beer.finalGravity} <br/>
            Description: {beer.description} <br/> <br/>
            <Button size="sm" color="danger" onClick={() => this.remove(beer.beerId)}>Delete</Button>

          </div>
        </div>
        )}
      </div>
    );
  }
}

export default Homebrews;