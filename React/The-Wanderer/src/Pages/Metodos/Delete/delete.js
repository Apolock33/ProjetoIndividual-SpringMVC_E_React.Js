import React from 'react';
import './delete.css'
import Footer from '../../../Components/Footer'
import NavBar from '../../../Components/NavBar'
import api from '../../../services/api'

import { Link } from 'react-router-dom';

export default function Delete() {

    function deletar(id) {
        api.delete(`/destinos/${id}`, (req, res) => {
            console.log(req.body)
            res.send(req.body)
        })
            .then(() =>
                window.location.reload())
            .catch((err) => console.log(err));
    }
    return (
        <div className="corpoCreate">
            <header>
                <NavBar />
            </header>
            <div className="centralização">
                <form className="CorpoForm" onSubmit={deletar}>
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