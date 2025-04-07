package com.blogpessoal.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@jakarta.validation.constraints.NotBlank(message = "O nome é obrigatório!")
	private String nome;

	@jakarta.validation.constraints.NotBlank(message = "O e-mail é obrigatório!")
	@jakarta.validation.constraints.Email(message = "O e-mail deve ser um email válido!")
	private String email;

	@jakarta.validation.constraints.NotBlank(message = "A senha é obrigatória!")
	@jakarta.validation.constraints.Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String senha;

	private String foto;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}