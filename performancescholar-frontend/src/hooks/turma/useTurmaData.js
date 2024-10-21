import { useQuery } from "@tanstack/react-query";
import axios from "axios";
const API_URL = 'http://localhost:8080';

const fetchData = async () => {
    const response = await axios.get(API_URL + '/turma');
    return response;
};

export function useTurmaData() {
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['turma-data'],
        retry: 2
    });

    return {
        ...query,
        data: query.data?.data
    };
}