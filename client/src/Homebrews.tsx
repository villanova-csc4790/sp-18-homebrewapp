import * as React from 'react';

interface Homebrews {
  beerId: string
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
      <div>
        <h2>Homebrew List</h2>
        {beers.map((beer: Homebrews) =>
          <div key={beer.beerId}>
            {beer.beerStyle} <br/>
            {beer.description} <br/>
            {beer.abv} <br/>
            {beer.originalGravity} <br/>
            {beer.finalGravity} <br/> <br/>
          </div>
        )}
      </div>
    );
  }
}

export default Homebrews;