import React from 'react';
import './delete.css'
import Footer from '../../../Components/Footer'
import NavBar from '../../../Components/NavBar'

import { Link } from 'react-router-dom';

export default function Delete() {
    

    return (
        <div className="corpoCreate">
            <header>
                <NavBar />
            </header>
            <div className="centralização">
                <form className="CorpoForm" >
                    <div className="form">
                        <h1>Escolha Seu Destino</h1><br />
                        <div className="inputs">
                            <div className="destino">
                                <label>Numero Da Viagem</label><br />
                                <input required type="text" className="idInput" /><br /><br />
                            </div>
                            
                            <div className="botoesCreate">
                                <input type="submit" className='submit' value='Enviar' />
                                <Link className="link" to='/destinos'><input type='button' className="submit" value='voltar'></input></Link>
                            </div>
                        </div>
                    </div>
                </form>

            </div>

            <footer>
                <Footer />
            </footer>
        </div>
    );
}