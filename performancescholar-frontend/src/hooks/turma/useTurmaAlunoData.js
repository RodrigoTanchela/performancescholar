import { useQuery } from "@tanstack/react-query";
import axios from "axios";


const fetchNotaDataById = async ({ queryKey }) => {
  const [, id] = queryKey; // Extrai o ID do queryKey
  const response = await axios.get(`http://localhost:8080/turma/buscarTurmaAlunos/${id}`);
  return response.data;
};

export const useTurmaAlunoData = (id) => {
  return useQuery({
    queryKey: ['turmaData', id],
    queryFn: fetchNotaDataById,
    enabled: !!id, 
  });
};
