# 📘 Blog Pessoal - BackEnd
## Montreal - AceleraMaker

Este projeto é uma aplicação web completa para gerenciamento de postagens em um blog, permitindo cadastro de usuários, autenticação via JWT, criação de temas e postagens. Foi desenvolvido com foco em segurança, boas práticas de desenvolvimento e documentação clara via Swagger.

---

## 🚀 Tecnologias Utilizadas

- ✅ Java 17+
- ✅ Spring Boot
- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ Spring Security
- ✅ JWT (JSON Web Token)
- ✅ MySQL (ou PostgreSQL)
- ✅ Maven
- ✅ Swagger/OpenAPI

---

## ⚙️ Configuração Inicial

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/yarazip/ProjetoBlogPessoal.git
   cd blog-pessoal


2. **Configurar o banco de dados
     No arquivo src/main/resources/application.properties, configure:**

### properties
```
spring.datasource.url=jdbc:mysql://localhost:3307/blog_pessoal
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🗂️ Modelagem do Domínio

### 👤 Usuario
- `id`: Long  
- `nome`: String  
- `email`: String  
- `senha`: String (criptografada com BCrypt)  
- `tipo`: String (ex: "ADMIN" ou "USER")  

### 📝 Postagem
- `id`: Long  
- `titulo`: String  
- `conteudo`: String  
- `data`: LocalDateTime  
- `tema`: Tema  
- `autor`: Usuario  

### 🧩 Tema
- `id`: Long  
- `descricao`: String  
- `postagens`: List<Postagem>  

---

## 🔐 Segurança

- **Autenticação**: via e-mail e senha  
- **Autorização**: token JWT enviado no header das requisições  
- **Filtro de segurança**: intercepta todas as rotas protegidas  
- **Senhas**: armazenadas com criptografia BCrypt  
- **Spring Security**: configurado com `JwtAuthenticationFilter`, `UserDetailsServiceImpl` e `BasicSecurityConfig`

---

## 📑 Endpoints da API

### 🔐 Autenticação (`/api/auth`)
- `POST /login` – Login e geração do token JWT  
- `POST /register` – Registro de novo usuário  

### 👥 Usuário (`/api/usuarios`)
- `POST /` – Cadastrar usuário  
- `PUT /{id}` – Atualizar usuário  
- `DELETE /{id}` – Deletar usuário  
- `POST /login` – Autenticar e gerar JWT  

### 📝 Postagem (`/api/postagens`)
- `GET /` – Listar todas as postagens  
- `GET /filtro?autor={id}&tema={id}` – Filtrar postagens por autor e/ou tema  
- `POST /` – Criar nova postagem  
- `PUT /{id}` – Atualizar postagem  
- `DELETE /{id}` – Excluir postagem  

### 🧩 Tema (`/api/temas`)
- `GET /` – Listar todos os temas  
- `POST /` – Criar novo tema  
- `PUT /{id}` – Atualizar tema  
- `DELETE /{id}` – Deletar tema  



## 🔍 Swagger / OpenAPI

- **Documentação automática dos endpoints REST**  
- Acesse via:  http://localhost:8181/swagger-ui/index.html

---

## 🧪 Testes

- Testes manuais realizados com **Postman** e **Insomnia**  
- Estrutura preparada para testes unitários e de integração com **JUnit**

---


| Critérios                             | ✔️ Implementado |
|-------------------------------------|-----------------|
| Segurança com JWT                   | ✅              |
| Documentação via Swagger            | ✅              |
| Boas práticas (DTO, validação, exceções) | ✅         |

---

## ✅ Boas Práticas Aplicadas

- 📦 **DTOs**: abstração e transferência segura de dados  
- 🔐 **Segurança**: tokens JWT, criptografia e controle de acesso  
- 📑 **Validações**: com `@Valid` e anotações do Bean Validation  
- 🧹 **Código limpo**: seguindo arquitetura MVC + Service Layer  

---

## 🔐 Confidencialidade

> **Restrito**: Este projeto deve ser utilizado apenas para fins **acadêmicos** ou **aprendizado pessoal**.

---


## 👨‍💻 Autor

**Yara Rosa**  
Estudante de Análise e Desenvolvimento de Sistemas  
GitHub: [https://github.com/yarazip](https://github.com/yarazip)  

---

