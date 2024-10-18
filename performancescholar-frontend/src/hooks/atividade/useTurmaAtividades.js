import { useQuery } from "@tanstack/react-query";
import axios from "axios";


const fetchNotaDataById = async ({ queryKey }) => {
  const [, id] = queryKey;
  const response = await axios.get(`http://localhost:8080/atividade/turmaAtividades/${id}`);
  return response.data;
};

export const useTurmaAtividades = (id) => {
  return useQuery({
    queryKey: ['atividadeData', id],
    queryFn: fetchNotaDataById,
    enabled: !!id, 
  });
};
