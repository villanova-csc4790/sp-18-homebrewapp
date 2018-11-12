import * as React from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import './CommercialBeers.css';

class CommercialBeers extends React.Component{

    emptyBeer = {
        cbId: '',
        name: '',
        company: '',
        url: '',
        abv: '',
      };

  constructor(props) {
    super(props);

    this.state = {
      beers: [],
      isLoading: false,
      item: this.emptyBeer
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(event) {
      event.preventDefault();
      const {item} = this.state;
      await fetch('http://localhost:8082/api/Commercials', {
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
      <Button color="secondary" onClick= {this.handleSubmit}>Get Beers</Button>
        {beers.map((beer: CommercialBeers) =>
        <div key={beer.cbId}>
          <div key={beer.cbId}>
          <Table>
           <thead>
            <tr className="Specific">
             <th> <h2>{beer.name}</h2> </th>
             <th> Company: {beer.company} <br/> </th>
             <th> ABV: {beer.abv}% <br/> </th>
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

export default CommercialBeers;