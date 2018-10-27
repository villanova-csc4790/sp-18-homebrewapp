import * as React from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

class CommercialBeers extends React.Component{

  constructor(props) {
    super(props);

    this.state = {
      beers: [],
      isLoading: false
    };

  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8082/api/Commercials')
      .then(response => response.json())
      .then(data => this.setState({beers: data, isLoading: false}));
  }

  render() {
    const {beers, isLoading} = this.state;
    console.log(beers);

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="Brew-Data">
        {beers.map((beer: CommercialBeers) =>
        <div key={beer.cbId} className="Square">
          <div key={beer.cbId} className="Data">
            <h2>{beer.name}</h2>
            ABV: {beer.abv}% <br/>
            Company: {beer.company} <br/>
          </div>
        </div>
        )}
      </div>
    );
  }
}

export default CommercialBeers;