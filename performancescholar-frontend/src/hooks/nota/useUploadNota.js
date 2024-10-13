import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios";

const API_URL = 'http://localhost:8080';

const postData = async (data) => {
    const response = axios.put(API_URL + `/nota`, data);
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