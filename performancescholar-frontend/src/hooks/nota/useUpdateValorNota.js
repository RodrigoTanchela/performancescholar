import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios";

const API_URL = 'http://localhost:8080';

const postData = async (data) => {
    // Use await para garantir que a requisição Axios seja concluída antes de retornar
    const response = await axios.put(API_URL + `/nota/updateValorNota`, data);
    return response.data;
}

export const useUpdateValorNota = () =>  {
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 1,
        onSuccess: () => {
            queryClient.invalidateQueries(['nota-data']); // Invalida a query após o sucesso para refetch
        },
        onError: (error) => {
            console.error("Erro ao atualizar a nota:", error);
        }
    });

    return mutate;
}
