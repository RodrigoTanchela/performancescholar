import { useNavigate } from 'react-router-dom';
import './styles.css'

export const Card = ({ turma, idTurma }) => {
  const navigate = useNavigate();
  const handleCardClick = () => {
    navigate(`/activityPage/${idTurma}`); 
  };

  return (
    <div className='card' onClick={handleCardClick}>
      <img className="imagemTurma" src="/../../../src/assets/imagens/sala-escola.jpg" alt="imagem turma" />
      <p className='link-card'>{turma}</p>
    </div>    
  );
};
