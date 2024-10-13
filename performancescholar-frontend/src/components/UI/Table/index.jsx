import React, { useState, useEffect } from 'react';
import './styles.css';

export const Table = ({ dados }) => {
  const [notasAgrupadas, setNotasAgrupadas] = useState([]);
  const [atividades, setAtividades] = useState([]);

  // Agrupar as notas por aluno e coletar as atividades únicas
  useEffect(() => {
    if (dados) {
      // Agrupar as notas por aluno
      const agrupamentoPorAluno = dados.reduce((acc, curr) => {
        const alunoExistente = acc.find(aluno => aluno.nome === curr.nome);
        if (alunoExistente) {
          alunoExistente.notas.push({ atividade: curr.atividade, valor: curr.notas[0] });
        } else {
          acc.push({
            nome: curr.nome,
            notas: [{ atividade: curr.atividade, valor: curr.notas[0] }],
          });
        }
        return acc;
      }, []);

      setNotasAgrupadas(agrupamentoPorAluno);

      // Extrair atividades únicas
      const atividadesUnicas = [...new Set(dados.map(item => item.atividade))];
      setAtividades(atividadesUnicas);
    }
  }, [dados]);

  // Função para atualizar a nota do aluno
  const handleNotaChange = (nomeAluno, atividade, novoValor) => {
    setNotasAgrupadas(prevAlunos =>
      prevAlunos.map(aluno =>
        aluno.nome === nomeAluno
          ? {
              ...aluno,
              notas: aluno.notas.map(nota =>
                nota.atividade === atividade ? { ...nota, valor: parseFloat(novoValor) || '' } : nota
              ),
            }
          : aluno
      )
    );
  };

  return (
    <table className="tabela-alunos">
      <thead>
        <tr>
          <th>Aluno</th>
          {/* Gerar dinamicamente as colunas com base nas atividades */}
          {atividades.map((atividade, index) => (
            <th key={index}>{atividade}</th>
          ))}
        </tr>
      </thead>
      <tbody>
        {notasAgrupadas.map((aluno) => (
          <tr key={aluno.nome}>
            <td>{aluno.nome}</td>
            {/* Preencher as notas de acordo com as atividades */}
            {atividades.map((atividade, index) => (
              <td key={index}>
                <input
                  type="number"
                  value={
                    aluno.notas.find(nota => nota.atividade === atividade)?.valor || ''
                  }
                  onChange={(e) => handleNotaChange(aluno.nome, atividade, e.target.value)}
                  placeholder={
                    aluno.notas.find(nota => nota.atividade === atividade) === undefined ? 'Inserir nota' : ''
                  }
                />
              </td>
            ))}
          </tr>
        ))}
      </tbody>
    </table>
  );
};
