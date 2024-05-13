# Challenge LiterAlura

  Programa en consola que brinda informacion de libros consultados a una API y guardando dichas consultas en una base de datos PosgrestSQL.
  Se utilizaron los siguientes elementos:

## Spring Boot 3.2.3

Se utilizo este framework para iniciar el proyecto con la siguiente configuracion:
- `Java: 17`
- `Maven`
- `Spring Boot: 3.2.3`
- `Proyecto en JAR`

  Dependencias:
- `Spring Data JPA`
- `Postgres Driver`
- `Jackson Databind`

## Api Gutendex

  Gutendex es una API web sencilla y autohospedada para ofrecer información del catálogo de libros del Proyecto Gutenberg ,
  una biblioteca en línea de libros electrónicos gratuitos.
  
  Se utilizo Jackson Databind para trabajar con las respuestas de la Api
  
  Pagina Oficial:  [gutendex.com](https://gutendex.com/)

## PostgreSQL

Se utilizo una Base de datos relacional postgres para guardar la informacion de los libros buscados conectando con 
el Postgres Driver

Ademas se utilizo JPA para mapear los datos

Pagina oficial: [Postgres Documentation](https://www.postgresql.org/docs/)
