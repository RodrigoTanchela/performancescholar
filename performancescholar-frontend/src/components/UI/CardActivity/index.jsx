import './styles.css'



export const CardActivity = ({ turma, idUsuario }) => {
    return (
      <div className='cardActivity-container'>
          <div className='container-atividades'>
            <img className="imagemActivity" src="/../../../src/assets/imagens/activity.png" alt="imagem da itividade "></img>
            <a className='link-cardActivity' href='https://www.canva.com/'>Turma 01</a>
          </div>
          <div className='crud-atividades'>
            <a className='inserirNota' href='www.google.com' >Inserir Nota</a>
            <a className='editarAtividade' href='www.google.com' >Editar</a>
            <a className='excluirAtividade' href='www.google.com' >Excluir</a>
          </div>     
      </div>  
        
    );
  };
