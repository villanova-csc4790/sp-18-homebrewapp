import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Homebrews from './Homebrews';
import Beer from './Beer.svg';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomebrewsEdit from './HomebrewsEdit';

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
                <Route path='/homebrews/:beerId' exact={true} component={HomebrewsEdit}/>
                <Route path='/homebrews/new' component={HomebrewsEdit}/>
            </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
