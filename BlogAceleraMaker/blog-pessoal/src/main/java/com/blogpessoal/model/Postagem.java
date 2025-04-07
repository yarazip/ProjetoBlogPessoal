package com.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório!")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "O texto é obrigatório!")
    @Size(min = 10, max = 1000, message = "O texto deve ter entre 10 e 1000 caracteres")
    private String texto;

    @CreationTimestamp
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    @JsonIgnoreProperties("postagens")
    private Tema tema;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("postagens")
    private Usuario usuario;
}
