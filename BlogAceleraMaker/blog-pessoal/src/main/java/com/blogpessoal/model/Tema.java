package com.blogpessoal.model;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Getter
@Setter

@Entity
@Table(name = "tb_temas")
public class Tema {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória!")
    private String descricao;

    @OneToMany(mappedBy = "tema")
    @JsonIgnoreProperties("tema")
    private List<Postagem> postagem;

}