<h1 align="center">
  transacao-api
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=&message=Matheus-Olivatto&color=000000&labelColor=000000" alt="Matheus Olivatto" />
 <img src="https://img.shields.io/static/v1?label=&message=Desafio Jr&color=000000&labelColor=000000" alt="Desafio" />
</p>

Este projeto é uma API REST para gerenciar transações e calcular estatísticas das transações realizadas nos últimos 60 segundos. A API foi desenvolvida com Java e Spring Boot.


## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Swagger](https://swagger.io/)
- [Postman](https://www.postman.com/)


## Práticas adotadas

- API REST
- Consultas com Swagger
- Injeção de Dependências
- Tratamento de erros
- Containerização
- Observabilidade


## Variáveis de Ambiente

Para rodar esta aplicação, você precisa de:

- Java: JDK 17 ou superior.
- Maven: Versão 3.8.1 ou superior.
- Git: Para clonar o repositório.
- Docker (opcional): Caso queira rodar a aplicação em um container.


## Como Executar

1. Clone o Repositório

2. Compile o Projeto

```bash
 mvn clean install
```

3. Execute o Projeto

```bash
mvn spring-boot:run
```
4. Como Rodar em um Container (Opcional)

4.1. Crie a Imagem Docker
Certifique-se de que o Docker está instalado e execute:

```bash
docker build -t transacao-api
```

4.2. Execute o Container

```bash
docker run -p 8080:8080 transacao-api
```

## Documentação da API

#### Receber Transações

```http
  POST /transacao
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `valor` | `BigDecimal` | **Obrigatório**. O valor da transação 
| `dataHora` | `OffsetDateTime` | **Obrigatório**. O horário que a transação ocorreu

#### Limpar Transações

```http
  DELETE /transacao
```

#### Calcular Estatísticas

```http
  GET /estatistica
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `intervaloSegundos` | `integer` | **Não Obrigatório** O padrão default é 60s  |




## API Endpoints

A API poderá ser acessada em [localhost:8080](http://localhost:8080). 
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html]((http://localhost:8080/swagger-ui/index.html)). 

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io) ou a ferramenta [postman](https://www.postman.com/).

# Autor

Matheus Franco Olivatto

https://www.linkedin.com/in/matheus-franco-olivatto/
