import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Home from './Pages/Home'
import Destinos from './Pages/Destinos'
import Promocoes from './Pages/Promocoes'
import Carrinho from './Pages/Carrinho';
import Cadastro from './Pages/Cadastro';
import Create from './Pages/Metodos/Create/create'
import Update from './Pages/Metodos/Update/update'
import Delete from './Pages/Metodos/Delete/delete'

export default function Routes() {
  return (
    <div>
      <Switch>
        <Route path='/' exact component={Home} />
        <Route path='/destinos' component={Destinos} />
        <Route path='/promocoes' component={Promocoes} />
        <Route path='/carrinho' component={Carrinho} />
        <Route path='/cadastro' component={Cadastro} />
        <Route path='/criarDestino' component={Create} />
        <Route path='/atualizarDestino' component={Update} />
        <Route path='/deletarDestino' component={Delete} />
      </Switch>
    </div>
  );
}