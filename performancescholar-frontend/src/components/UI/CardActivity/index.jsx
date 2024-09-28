import Button from '../Button';
import './styles.css'

export const CardActivity = ({ turma, idUsuario }) => {

    return (
      <div className='cardActivity-container'>
          <div className='container-atividades'>
            <img className="imagemActivity" src="/../../../src/assets/imagens/activity.png" alt="imagem da itividade "></img>
            <a className='link-cardActivity' href='https://www.canva.com/'>Turma 01</a>
            <div className='container-button'>
          </div>
            <a className='insert' href='www.google.com' ></a>
            <a className='editar' href='www.google.com' ></a>
            <a className='excluir' href='www.google.com' ></a>
          </div>     
      </div>    
    );
  };
