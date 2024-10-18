import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Footer } from "../../Layout/Footer";
import { Heading } from "../../Layout/Heading";
import { Table } from '../../UI/Table';
import './styles.css';
import { useNotaData } from '../../../hooks/nota/useNotaData';

export const NotasPage = () => {
  const { data: notaData, isLoading, error } = useNotaData(3);

  if (isLoading) return <p>Carregando...</p>;
  if (error) return <p>Erro: {error.message}</p>;

  const dadosParaTabela = Array.isArray(notaData) ? notaData.map(nota => ({
    id: nota.id,
    nome: nota.alunoNome,
    notas: [nota.valor],  
    atividade: nota.atividadeTitulo,
  })) : [];

  return (
    <section className="NotasPage-container">
      <Heading text={"Bem-vindo à Página Principal"} />
      <div className='tabela'>
        <Table dados={dadosParaTabela} />
      </div>
      <Footer />
    </section>
  );
};
