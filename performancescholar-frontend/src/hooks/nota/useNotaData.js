import { useQuery } from "@tanstack/react-query";
import axios from "axios";

// Função para buscar dados de nota por ID
const fetchNotaDataById = async ({ queryKey }) => {
  const [, id] = queryKey; // Extrai o ID do queryKey
  const response = await axios.get(`http://localhost:8080/nota/buscarNotasAlunos/${id}`);
  return response.data;
};

// Hook personalizado para buscar dados de nota por ID
export const useNotaData = (id) => {
  return useQuery({
    queryKey: ['notaData', id], // Chave única com o 'id'
    queryFn: fetchNotaDataById, // Função de busca que aceita um objeto
    enabled: !!id, // Só faz a consulta se o id for válido
  });
};
