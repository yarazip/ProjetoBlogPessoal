package com.blogpessoal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("unused")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    
   
    public Long getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setId(Long id) {
		this.id = id;
	}
  
}