package com.performancescholar.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.performancescholar.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nome", unique = false, nullable = false, length = 255)
    private String nome;
	
	@Column(name = "email", unique = false, nullable = false, length = 255)
    private String email;
	
	@Column(name = "senha", unique = false, nullable = false, length = 255)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private Role papel;
    
    private LocalDateTime dataDeCriacao;
    
    @Column(name = "enabled")
    private Boolean ativo;
    
	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String senha, Role papel, LocalDateTime dataDeCriacao,
			Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.papel = papel;
		this.dataDeCriacao = dataDeCriacao;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Role getPapel() {
		return papel;
	}
	public void setPapel(Role papel) {
		this.papel = papel;
	}
	
	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}
	
	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, dataDeCriacao, email, id, nome, papel, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(dataDeCriacao, other.dataDeCriacao)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && papel == other.papel && Objects.equals(senha, other.senha);
	}
	
	
    
}
