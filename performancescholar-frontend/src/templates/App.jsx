import { Routes, Route } from 'react-router-dom';
import Login from '../components/Pages/LoginPage/index'; 
import { TurmaPage } from '../components/Pages/TurmaPage/index';
import  RegisterPage  from '../components/Pages/RegisterPage/index';
import { ActivityPage } from '../components/Pages/ActivityPage/index';
import { DesempenhoAlunoPage } from '../components/Pages/DesempenhoAlunoPage/index';
import { NotasPage } from '../components/Pages/NotasPage/index';
import './App.css';

function App() {
  return (
    <div>
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/turmaPage" element={<TurmaPage />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/activityPage/:idTurma" element={<ActivityPage />} />
      <Route path="/notasPage" element={<NotasPage />} />
      <Route path="/desempenho" element={<DesempenhoAlunoPage />} />
    </Routes>
  </div>
  );
}

export default App;
