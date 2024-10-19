# Sistema de Gerenciamento Hospitalar

Este projeto é uma API REST baseada em Spring Boot, projetada para gerenciar operações hospitalares. Ele permite que os
usuários gerenciem médicos e pacientes, e inclui recursos como autenticação segura, respostas padronizadas da API e
tratamento de erros. Este projeto foi desenvolvido como parte de uma jornada de aprendizado em Spring Boot, focando na
aplicação de boas práticas e na proteção de APIs com Spring Security.

## Funcionalidades

- **Gerenciamento de Médicos**: Operações de criação, leitura, atualização e exclusão (CRUD) para gerenciamento de
  médicos.
- **Autenticação e Autorização**: Implementação de autenticação baseada em JWT com Spring Security para acesso seguro.
- **Tratamento de Erros**: Gerenciamento centralizado de erros com `ControllerAdvice` para respostas consistentes e
  tratamento de exceções (ex.: erros 404, 400).
- **Padronização da API**: Códigos de resposta padronizados (ex.: 201 para criação bem-sucedida, 204 para exclusão).
- **Segurança**: Criptografia de senhas usando BCrypt e segurança stateless com tokens JWT.

## Estrutura do Projeto

A aplicação está organizada em três pacotes principais:

1. **Controller**: Gerencia as requisições e respostas HTTP.
    - `AuthenticationController`: Gerencia a autenticação e o login.
    - `DoctorsController`: Lida com o gerenciamento de médicos.

2. **Domain**: Contém a lógica de negócios e as entidades principais, como médicos e pacientes.

3. **Infraestrutura (infra)**: Configurações de infraestrutura, incluindo as configurações de segurança e tratamento de
   exceções.

## Fluxo de Autenticação

- O sistema utiliza Spring Security para autenticação e autorização, com sessões stateless gerenciadas por tokens JWT.
- As senhas são criptografadas usando BCrypt.
- Os tokens JWT são validados e analisados para autenticar os usuários em cada requisição.

## Tratamento de Erros

Respostas de erro personalizadas foram implementadas para gerenciar exceções comuns do HTTP, como
`EntityNotFoundException` para recursos ausentes e `MethodArgumentNotValidException` para requisições inválidas.

## Segurança

Os tokens JWT são gerenciados por meio de um `TokenService` que gera e valida tokens. O `RequestFilter` intercepta as
requisições para verificar os tokens e autenticar os usuários.

Destaques da configuração de segurança:

- Gestão de sessão stateless (cada requisição deve incluir um JWT válido).
- Criptografia de senha com BCrypt.
- Filtro personalizado `RequestFilter` para interceptar requisições e tratar a autenticação via token.

## Tecnologias Utilizadas

- **Java 23**
- **Spring Boot**
- **Spring Security**
- **JPA (Java Persistence API)**
- **JWT (JSON Web Tokens)**
- **BCrypt** para criptografia de senhas
- **Maven** para build do projeto e gerenciamento de dependências