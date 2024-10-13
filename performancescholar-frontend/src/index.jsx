import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './styles/global-styles.css'
//import Login from './components/Login/index.jsx'
//import RegisterPage from './components/Pages/RegisterPage/index.jsx'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { NotasPage } from './components/Pages/NotasPage';
//import { ActivityPage } from './components/Pages/ActivityPage';
//import { Table } from './components/UI/Table';
//import { TurmaPage } from './components/Pages/TurmaPage/index.jsx';

const queryClient = new QueryClient();

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <QueryClientProvider client={queryClient}>
      <NotasPage></NotasPage>
    </QueryClientProvider>
  </StrictMode>,
)
