import { useTurmaAlunoData } from "../../../hooks/turma/useTurmaAlunoData";
import { Footer } from "../../Layout/Footer";
import { Heading } from "../../Layout/Heading";
import { Card } from "../../UI/Card";
import './styles.css';
import Cookies from 'js-cookie'

export const TurmaPage = () => {
  const  id = Cookies.get('id');
  const { data } = useTurmaAlunoData(id)


  return (
    <div className="turmaPage-container">
      <Heading text="Bem-vindo à Página Principal" />  {/* Título da página */}
      <section className="container-cards">
      {data ? (
        data.map((turmaData) => (
          <Card
            key={turmaData.id}  
            turma={turmaData.nome} 
            idTurma={turmaData.id}
          />
        ))
      ) : (
        <p>Carregando dados da turma...</p>  
      )}
      </section>
      <Footer />    
    </div>
  );
};
