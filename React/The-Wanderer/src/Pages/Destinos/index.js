import React, { useEffect, useState } from 'react';
import api from '../../services/api'
import Footer from '../../Components/Footer';
import NavBar from '../../Components/NavBar';
import Cards from '../../Components/Cards/Card';
import service from '../../services/services'
import './Destinos.css';
import img1 from '../../assets/1.jpg';
import img2 from '../../assets/2.jpg';
import img3 from '../../assets/3.jpg';
import img5 from '../../assets/5.jpg';
import img6 from '../../assets/6.jpg';
import img7 from '../../assets/7.jpg';

export default function Destinos() {

  const [destinos, setDestinos] = useState();

  useEffect(() => {
    api.get("/destinos").then(({ data }) => {
      setDestinos(data)
    });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])
  console.log(destinos);
  

  return (
    <div>
      <div className='capad'>
        <div>
          <NavBar />
          <h4 className='descubrase'>Descubra-se, Viajante!</h4>
          <h1 className='textocentro'>O seu caminho é só seu. Venha desvenda-lo através dos destinos mais lindos e das aventuras mais épicas e memoráveis!</h1>
        </div>
      </div>
      <div className='fotos'>
        <img src={img1} alt='img1' />
        <img src={img2} alt='img2' />
        <img src={img3} alt='img3' />
        <img src={img5} alt='img4' />
        <img src={img6} alt='img3' />
        <img src={img7} alt='img4' />
      </div>
      <div className='tituloD'>
        <h1 >Destinos</h1>
      </div>
      <div className='cardContainer'>
        {destinos?.map((destino) => (
         <Cards
            key={destino.id}
            id={destino.id}
            destino={destino.destino}
            img={destino.img}
            preco={destino.preco}
          />
          
        ))}        
      </div>
      <div>
        <Footer />
      </div>
    </div>

  );
}