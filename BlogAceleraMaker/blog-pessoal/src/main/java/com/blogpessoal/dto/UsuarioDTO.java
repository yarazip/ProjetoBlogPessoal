package com.blogpessoal.dto;

import com.blogpessoal.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @NotBlank(message = "O email é obrigatório!")
    @Email(message = "O email deve ser válido!")
    private String email;

    private String foto;

    @NotBlank(message = "A senha é obrigatória!")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nome, String email, String foto, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.foto = foto;
        this.senha = senha;
    }

    public Usuario toUsuario() {
        Usuario u = new Usuario();
        u.setId(this.id);
        u.setNome(this.nome);
        u.setEmail(this.email); 
        u.setFoto(this.foto);
        u.setSenha(this.senha);
        return u;
    }

    public static UsuarioDTO from(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail()); 
        dto.setFoto(usuario.getFoto());
        dto.setSenha("********");
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
