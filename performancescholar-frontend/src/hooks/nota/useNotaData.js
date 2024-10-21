import { useQuery } from "@tanstack/react-query";
import axios from "axios";

const fetchNotaDataById = async ({ queryKey }) => {
  const [, id] = queryKey;
  const response = await axios.get(`http://localhost:8080/nota/buscarNotasAlunos/${id}`);
  return response.data;
};

export const useNotaData = (id) => {
  return useQuery({
    queryKey: ['notaData', id],
    queryFn: fetchNotaDataById,
    enabled: !!id,
  });
};
