import { useQuery } from "@tanstack/react-query";
import axios from "axios";


const fetchNotaDataById = async ({ queryKey }) => {
  const [, id] = queryKey; // Extrai o ID do queryKey
  const response = await axios.get(`http://localhost:8080/nota/buscarNotasAlunosId/${id}`);
  return response.data;
};

export const useNotaAlunoData = (id) => {
  return useQuery({
    queryKey: ['notaData', id],
    queryFn: fetchNotaDataById,
    enabled: !!id, 
  });
};
