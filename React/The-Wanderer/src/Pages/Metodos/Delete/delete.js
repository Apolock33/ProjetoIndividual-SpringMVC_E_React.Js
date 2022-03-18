import React, { useRef } from 'react';
import './delete.css'
import Footer from '../../../Components/Footer'
import NavBar from '../../../Components/NavBar'
import api from '../../../services/api'
import { Link } from 'react-router-dom';

export default function Update() {
    const id = useRef()

    function update(event) {
        event.preventDefault()
        api.delete('/destinos/delete/{id}', {
            id: id.current.value
        }).then(() => {
            window.location.reload()
        }).catch(err => {
            console.error(err)
        }).then(() => {
            alert("Seu Destino Foi Atualizado")
        })
    }

    return (
        <div className="corpoCreate">
            <header>
                <NavBar />
            </header>
            <div className="centralização">
                <form className="CorpoForm" onSubmit={update}>
                    <div className="form">
                        <h1>Mude Seu Destino</h1><br />
                        <div className="inputs">
                            <div className="id">
                                <label>Id</label><br />
                                <input required type="text" className="idInput" ref={id} /><br /><br />
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