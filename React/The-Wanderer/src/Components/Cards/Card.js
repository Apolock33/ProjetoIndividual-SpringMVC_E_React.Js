import React from 'react';
import { Link } from 'react-router-dom';
import './Card.css'

export default function Cards(props) {
    return (
        <div>
            <div className="idCards" align='center'>
                <h3>Viagem { props.id }</h3>
            </div>
            <div className="cardImgContainer" align="center">
               <br/> <img className='cardImg' src={props.img} alt='CardImg' />
                <div className='info' align='center'>
                    <h1>{props.destino}</h1>
                    <h3>Preço: {props.preco}</h3>
                </div>
                <div className='Botoes'>
                    <Link className='Button' to='/criarDestino'>Criar</Link>
                    <Link className='Button' to='/atualizarDestino'>Atualizar</Link>
                    <Link className='Button' to='/deletarDestino'>Deletar</Link>
                </div>
            </div><br/>
        </div>
    );
}