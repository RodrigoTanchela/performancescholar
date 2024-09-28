import './styles.css'

export const Card = ({ turma, idUsuario }) => {

    return (
      <div className='card-container'>
          <img className="imagemTurma" src="/../../../src/assets/imagens/sala-escola.jpg" alt="imagem turma "></img>
          <a className='link-card' href='https://www.canva.com/'>Turma 01</a>
      </div>    
    );
  };
