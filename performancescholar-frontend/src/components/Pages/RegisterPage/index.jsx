import { useEffect, useState } from 'react';
import './styles.css';
import Input from "../../UI/Input/index.jsx";
import { Messagem } from "../../Layout/Messagem/index.jsx";
import { useCreateUser } from '../../../hooks/user/useCreateUser.js';

const RegisterPage = () => {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState(''); 
  const [senha, setSenha] = useState('');
  const [tipo, setTipo] = useState('ALUNO');
  const [dataCriacao, setDataCriacao] = useState('');
  const [ativo, setAtivo] = useState(true); 
  const [especialidade, setEspecialidade] = useState('');
  const { mutate, isSuccess, isLoading } = useCreateUser();


  const handleSubmit = (e) => {
    e.preventDefault();
    const userData = {
      nome,
      email,
      senha,
      tipo,
      dataCriacao,
      ativo
    };
    if (tipo === 'PROFESSOR' && especialidade != null) {
      userData.especialidade = especialidade; 
    }
    mutate(userData)
    
    setTimeout(() => {
      console.log("Recarregando a página após o tempo de espera...");
      window.location.reload(); 
    }, 2000); 
  };

  return (
    <div className="register-container">
      <h2>Cadastro</h2>
      { isSuccess && <Messagem text = {`usuario ${nome} criado com sucesso`} type = "success"></Messagem>}
      <form onSubmit={handleSubmit}>
        <Input
          label='nome'
          type="text"
          value={nome}
          updateValue ={setNome}
          placeholder="Nome"
          required={true}
        />
        <Input
          label='email'
          type="email"
          value={email}
          updateValue ={setEmail}
          placeholder="Email"
          required={true}
        />
        <Input
          label='senha'
          type="password"
          value={senha}
          updateValue ={setSenha}
          placeholder="Senha"
          required={true}
        />

        {/* Seletor de Tipo */}
        <label htmlFor="tipo">Tipo de usuário</label>
        <select 
          id="tipo" 
          name="tipo" 
          value={tipo}
          onChange={(e) => setTipo (e.target.value)}
          className="section"
        >
          <option id='aluno' value="ALUNO">Aluno</option>
          <option id='administrador' value="ADMINISTRADOR">Administrador</option>
          <option id='professor' value="PROFESSOR">Professor</option>
        </select>

        <Input
          label='dataCriacao'
          type="date"
          value={dataCriacao}
          updateValue={setDataCriacao}
          placeholder="Data de criação"
          required={true}
        />

        <label htmlFor="ativo">Usuário está ativo?</label>
        <select 
          id="ativo" 
          name="ativo" 
          onChange={(e) => setAtivo(e.target.value === 'true')}
          className="section"
        >
          <option value="true">Sim</option>
          <option value="false">Não</option>
        </select>

        {tipo === "PROFESSOR" && (
          <Input
            label='especialidade'
            type="text"
            value={especialidade}
            updateValue = { setEspecialidade}
            placeholder="Especialidade"
            required={true}
          />
        )}

        <button type="submit" className="btn-secondary">
          {isLoading ? 'postando...' : 'postar'}
        </button>
      </form>
    </div>
  );
};

export default RegisterPage;
