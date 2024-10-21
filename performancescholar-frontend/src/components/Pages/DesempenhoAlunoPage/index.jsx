import { Bar, BarChart, CartesianGrid, Legend, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts';
import './styles.css';
import { Heading } from '../../Layout/Heading';
import { Footer } from '../../Layout/Footer';
import { useNotaAlunoData } from '../../../hooks/nota/useNotaAlunoData';
import Cookies from 'js-cookie';

export const DesempenhoAlunoPage = () => {
    const  id = Cookies.get('id');
    const { data } = useNotaAlunoData(id);

    return(
        <div className='desempenhoPage'>
            <Heading />
            <div className='grafico'>
                <ResponsiveContainer width="100%" height={300}>
                    <BarChart data={data} margin={{ top: 50, right: 30, left: 20, bottom: 5 }}>
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="atividadeTitulo" />
                        <YAxis domain={[0, 10]} tickCount={6} />
                        <Tooltip />
                        <Legend />
                        <Bar dataKey="valor" fill="#4681C1" />
                    </BarChart>
                </ResponsiveContainer>
            </div>
            <Footer />
        </div>
    );
}
