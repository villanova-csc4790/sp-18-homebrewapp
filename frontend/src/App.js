import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Homebrews from './Homebrews';
import CommercialBeers from './CommercialBeers';
import Beer from './Beer.svg';
import { BrowserRouter as Router, Route, Switch, Button, Link } from 'react-router-dom';
import HomebrewsEdit from './HomebrewsEdit';
import Breweries from './Breweries';
import City from './City';


class App extends React.Component {

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={Beer} className="App-logo" alt="logo" />
          <h1 className="App-title">Homebrew Application</h1>
        </header>
        <Router>
            <Switch>
                <Route path='/homebrews' exact={true} component={Homebrews}/>
                <Route path='/Commercials' exact={true} component={CommercialBeers}/>
                <Route path='/homebrews/:beerId' exact={true} component={HomebrewsEdit}/>
                <Route path='/homebrews/new' component={HomebrewsEdit}/>
                <Route path='/Breweries' component={Breweries}/>
                <Route path='/City' component={City}/>
            </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
