import * as React from 'react';
import { Button, Container, Form, FormGroup, Input, Label, Table,
Dropdown, DropdownToggle, DropdownMenu, DropdownItem, ButtonGroup } from 'reactstrap';
import {BootstrapTable, th} from
       'react-bootstrap-table'
import { Link } from 'react-router-dom';
import './CommercialBeers.css';

class CommercialBeers extends React.Component{

    emptyBeer = {
        cbId: '',
        name: '',
        company: '',
        url: '',
        abv: '',
        style: '',
      };

  constructor(props) {
    super(props);

    this.state = {
      beers: [],
      isLoading: false,
      item: this.emptyBeer
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

  handleChange2 = (event) => {
      this.setState({ value2: event.target.value })
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

    return (
      <div className="Brew-Data">
      <ButtonGroup>
          <Button color="secondary" onClick= {this.handleSubmit}>Get Beers</Button>
          <Button color="secondary" tag={Link} to="/Homebrews">Home</Button>
      </ButtonGroup>
      <br/>
      <br/>
      <h2 id="label">Beer Style</h2>
      <FormGroup>
        <div class="form-group col-lg-2">
          <Input type="text" name="style" id="style"
                onChange={this.handleChange} autoComplete="The Name..."/>
        </div>
      </FormGroup>
        {beers.map((beer: CommercialBeers) =>
        <div key={beer.cbId}>
          <div key={beer.cbId}>
          <Table data={this.props.emptyBeer}  class="CommercialTable">
             <th width='100' isKey={true}> {beer.name} </th>
             <th width='150'> Company: {beer.company} <br/> </th>
             <th width='150'> ABV: {beer.abv} <br/> </th>
          </Table>
          </div>
        </div>
        )}
      </div>
    );
  }
}

export default CommercialBeers;