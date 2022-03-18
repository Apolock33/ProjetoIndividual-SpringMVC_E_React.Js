import React, { useRef } from 'react';
import './create.css'
import Footer from '../../../Components/Footer'
import NavBar from '../../../Components/NavBar'
import api from '../../../services/api'
import { Link } from 'react-router-dom';

export default function Create() {
    const destino = useRef()
    const img = useRef()
    const preco = useRef()

    function create(event) {
        event.preventDefault()
        api.post('/destinos/add', {
            destino: destino.current.value,
            img: img.current.value,
            preco: preco.current.value
        }).then(() => {
            window.location.reload()
        }).catch(err => {
            console.error(err)
        }).then(() => {
            alert("Seu Novo Destino Foi Cadastrado")
        })
    }

    return (
        <div className="corpoCreate">
            <header>
                <NavBar />
            </header>
            <div className="centralização">
                <form className="CorpoForm" onSubmit={create}>
                    <div className="form">
                        <h1>Escolha Seu Destino</h1><br/>
                        <div className="inputs">
                            <div className="destino">
                                <label>Destino</label><br />
                                <input required type="text" className="destinoInput" ref={destino}/><br /><br />
                            </div>
                            <div className="img">
                                <label>Imagem</label><br />
                                <input required type="text" className="imagemInput" ref={img}/><br /><br />
                            </div>
                            <div>
                                <label>Preço</label><br />
                                <input required type="text" className="precoInput" ref={preco} /><br /><br />
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