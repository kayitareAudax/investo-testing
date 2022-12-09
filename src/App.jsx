import React from 'react';
import { Route, Switch } from 'react-router-dom';
import './stylesheet/styles.css';
import { Home } from './components/Home';


import { GlobalProvider } from './context/GlobalState';
import { AddCompany } from './components/AddCompany';
import { EditCompany } from './components/EditCompany';
import {BrowserRouter} from 'react-router-dom'
function App() {
  return (
    <GlobalProvider>
      <BrowserRouter>
      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/add" component={AddCompany} exact />
        <Route path="/edit/:id" component={EditCompany} exact />
      </Switch>
      </BrowserRouter>
    </GlobalProvider>
  );
}

export default App;
