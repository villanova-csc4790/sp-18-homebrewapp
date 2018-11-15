import * as React from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

class Breweries extends React.Component{

    emptyBrewery = {
        id: '',
        name: '',
        LatLng: '',
        milesFromCity: '',
      };

  constructor(props) {
    super(props);

    this.state = {
      beers: [],
      isLoading: false,
      item: this.emptyBrewery
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(event) {
      event.preventDefault();
      const {item} = this.state;
      await fetch('http://localhost:8082/api/Breweries', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        mode: 'cors',
        body: JSON.stringify(item),
      });
    }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8082/api/Breweries')
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
      <Button color="secondary" onClick= {this.handleSubmit}>Get Breweries</Button>
      <Button color="secondary" tag={Link} to="/City">City</Button>
      <Button color="secondary" tag={Link} to="/Homebrews">Home</Button>
        {beers.map((beer: Breweries) =>
        <div key={beer.id}>
          <div key={beer.id}>
          <Table>
           <thead>
            <tr className="Specific">
             <th> <h2>{beer.name}</h2> </th>
             <th> <h2>{beer.milesFromCity} miles</h2> </th>
            </tr>
           </thead>
          </Table>
          </div>
        </div>
        )}
      </div>
    );
  }
}

export default Breweries;