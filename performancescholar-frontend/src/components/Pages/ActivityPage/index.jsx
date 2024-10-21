import { Footer } from "../../Layout/Footer"
import { Heading } from "../../Layout/Heading"
import { CardActivity } from "../../UI/CardActivity"
import './styles.css'
import { NavLinks } from '../../UI/NavLink';
import { useTurmaAtividades } from '../../../hooks/atividade/useTurmaAtividades';
import { useParams } from "react-router-dom";

const linksData = [
    {
      children: 'Alunos',
      link: '/home',
      newTab: false,
    },
    {
      children: 'Media Turma',
      link: '/desempenho',
      newTab: false,
    },
    {
      children: 'Inserir Atividade',
      link: '/contact',
      newTab: true, 
    },
  ];

export const ActivityPage = () => {
  const { idTurma } = useParams();
  const { data } = useTurmaAtividades(idTurma)

    return(    
            <section className="activityPage-container">
            <NavLinks classLink={"links-relatorio"} links={linksData} /> {}
            <Heading text={"Bem-vindo à Página Principal"}></Heading>
            <div className="containersAtividades-cards">
              {data ? (
                data.map((atividadeData) => (
                  <CardActivity
                    key={atividadeData.id}  
                    titulo={atividadeData.titulo} 
                />
                ))
              ) : (
              <p>Carregando dados da turma...</p>  
              )}
            </div>
            <Footer></Footer>
            </section>  
    )
}