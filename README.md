<img src="https://img.shields.io/badge/STATUS-EM DESENVOLVIMENTO-orange"/>

# Sistema de Gestão de Inventário

![java](https://img.shields.io/badge/-Java-white?style=for-the-badge&logo=openjdk&color=000000&logoColor=white)
![spring](https://img.shields.io/badge/-Spring_Boot-white?style=for-the-badge&logo=Spring-Boot&color=6DB33F&logoColor=white)
![angular](https://img.shields.io/badge/-Angular-white?style=for-the-badge&logo=angular&color=DD0031&logoColor=white)
![typescript](https://img.shields.io/badge/-TypeScript-white?style=for-the-badge&logo=typescript&color=3178C6&logoColor=white)
![sqlite](https://img.shields.io/badge/-SQLite-white?style=for-the-badge&logo=sqlite&color=003B57&logoColor=white)

Este é um projeto fullstack de **Sistema de Gestão de Inventário**, desenvolvido com **Spring Boot** no backend e **Angular** no frontend.

O projeto tem como objetivo simular um sistema real de controle de estoque, permitindo o gerenciamento de produtos por meio de operações CRUD: criação, listagem, atualização e exclusão de produtos.

A aplicação foi desenvolvida com foco em praticar conceitos importantes de desenvolvimento fullstack, como criação de API REST, organização em camadas, persistência de dados com JPA/Hibernate, uso de DTOs, tratamento de exceções, integração entre frontend e backend e construção de interface com Angular Material.

## Endpoints da API

A API oferece os seguintes endpoints para gerenciamento de produtos:

- `GET /products`: Retorna todos os produtos cadastrados.
- `GET /products/{id}`: Retorna um produto pelo ID.
- `GET /products/search?name={name}`: Busca produtos pelo nome.
- `POST /products`: Cria um novo produto.
- `PUT /products/{id}`: Atualiza um produto existente pelo ID.
- `DELETE /products/{id}`: Exclui um produto pelo ID.


## Como executar o projeto

### Primeiro rodar o back-end:

1. Clone este repositório para o seu ambiente de desenvolvimento:

```bash
git clone https://github.com/tiagoabra5/SistemaGestaoInventario.git
```
2. Navegue até o diretório do projeto:

```bash
cd Sistema/
```
3. Execute o aplicativo Spring Boot usando o Maven:

  terminal
```bash
mvnw.cmd spring-boot:run
```
  se o primeiro não funcionar, tente esse:
```bash
mvnw spring-boot:run
```

### Depois de rodar o back-end, precisa rodar o front-end:

1. Navegue até o diretório do projeto:

```bash
cd sistema-ui/
```
2. Execute o frontend Angular usando o npm:

  execute nessa ordem:
```bash
npm install 
```
```bash
npx.cmd ng serve
```
O aplicativo estará disponível em http://localhost:4200

## Autor

Este projeto foi desenvolvido por Tiago Abraão com o objetivo de estudar e praticar desenvolvimento fullstack, utilizando Java, Spring Boot, Angular, TypeScript e banco de dados relacional. Além de funcionar como um sistema de gestão de inventário, o projeto também foi criado para aprofundar meus conhecimentos em Java, API REST, JPA/Hibernate, integração entre frontend e backend e construção de aplicações.
