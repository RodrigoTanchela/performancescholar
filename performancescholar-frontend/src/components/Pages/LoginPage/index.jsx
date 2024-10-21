import { useState } from 'react';
import './styles.css';
import { useNavigate } from 'react-router-dom';
import Input from "../../UI/Input/index.jsx"; // Verifique se o caminho está correto
import { useLoginUser } from '../../../hooks/user/useLoginUser.js';
import { Messagem } from '../../Layout/Messagem/index.jsx';
import Cookies from 'js-cookie'

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const { mutate } = useLoginUser();

  const handleSubmit = (e) => {
    e.preventDefault();

    const userData = {
      email,
      password,
    };

    mutate(userData, {
      onSuccess: (data) => {
        const token = data.token;
        const email = data.email
        const id = data.id
        Cookies.set('id', id);
        Cookies.set('email', email);
        Cookies.set('token', token);
        navigate('/turmaPage');
      },
      onError: () => {
        setError('Credenciais inválidas. Tente novamente.');
      },
    });
  };

  return (
    <div className="login-container">
      <h2>Login</h2>
      { error && <Messagem text = {`Erro ao logar verifique as informações`} type = "error"></Messagem>}
      <form onSubmit={handleSubmit}>
        <Input
          type="email"
          value={email}
          updateValue={setEmail}
          placeholder="Email"
        />
        <Input
          type="password"
          value={password}
          updateValue={setPassword}
          placeholder="Password"
        />
        <button className='submit' type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
