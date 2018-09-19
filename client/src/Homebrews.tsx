import * as React from 'react';
import './Homebrews.css';

interface Homebrews {
  beerId: string
  beerName: string
  beerStyle: string
  description: string
  usedOnlineRecipe: boolean
  abv: number
  originalGravity: number
  finalGravity: number
  specificGravity: number
}

interface HomebrewsProps {
}

interface HomebrewsState {
  beers: Array<Homebrews>;
  isLoading: boolean;
}

class Homebrews extends React.Component<HomebrewsProps, HomebrewsState> {

  constructor(props: HomebrewsProps) {
    super(props);

    this.state = {
      beers: [],
      isLoading: false
    };
  }

  public componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8082/homebrews')
      .then(response => response.json())
      .then(data => this.setState({beers: data, isLoading: false}));
  }

  public render() {
    const {beers, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="Brew-Data">
        <h2>Homebrew List</h2>
        {beers.map((beer: Homebrews) =>
        <div key={beer.beerId} className="Square">
          <div key={beer.beerId} className="Data">
            <h2>{beer.beerName}</h2>
            Beer Style: {beer.beerStyle} <br/>
            ABV: {beer.abv}% <br/>
            Original Gravity: {beer.originalGravity} <br/>
            Final Gravity: {beer.finalGravity} <br/>
            Description: {beer.description} <br/> <br/>
          </div>
        </div>
        )}
      </div>
    );
  }
}

export default Homebrews;