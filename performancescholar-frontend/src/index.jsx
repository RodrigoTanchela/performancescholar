import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './styles/global-styles.css'
//import Login from './components/Login/index.jsx'
import RegisterPage from './components/Pages/RegisterPage/index.jsx'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'

const queryClient = new QueryClient();

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <QueryClientProvider client={queryClient}>
      <RegisterPage></RegisterPage>
    </QueryClientProvider>
    
  </StrictMode>,
)
