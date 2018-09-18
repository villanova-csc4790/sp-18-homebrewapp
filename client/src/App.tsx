import * as React from 'react';
import './App.css';
import Homebrews from './Homebrews';

import Beer from './Beer.svg';

class App extends React.Component {

  public render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={Beer} className="App-logo" alt="logo" />
          <h1 className="App-title">Homebrew Application</h1>
        </header>
        <Homebrews />
      </div>
    );
  }
}

export default App;
