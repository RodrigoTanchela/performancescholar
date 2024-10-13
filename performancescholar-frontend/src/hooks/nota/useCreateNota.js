import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios";

const API_URL = 'http://localhost:8080';

const postData = async (data) => {
    const response = axios.post(API_URL + `/nota/create`, data);
    return response.data;
}

export const useCreateUser = () =>  {
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 1,
        onSuccess: () => {
            queryClient.invalidateQueries(['user-data']);
        }
    });

    return mutate;
}