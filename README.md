# Desafio CRUD de clientes  -  curso Java Spring Professional

# Spring Boot WEB - Spring DATA JPA - Banco de Dados H2 - Jakarta Bean Validation

## Desenvolvido utilizando o método de camadas, com as classes:
- entities
- repositories
- services
- controllers
- dto

## Tratamento de erros e validação de dados:
- Foi utilizado um método de captura e personalização de mensagens de erro, estendendo a classe RunTimeException para recurso não encontrado no pacote services;
- Foi criada uma classe CustomError, para customizar a mensagem de erro fornecida pelo sistema;
- Foram criadas as classes FieldMessage e ValidationError para customizar a mensagem de erro e listar os erros capturados no processo de validação; 
- Por fim, criada no pacote controllers.handlers a classe ExceptionHandlers capturando os erros e retornando o código HTTP correto mais específico para a exceção encontrada.

## Condições de validação:
- nome não pode ser vazio;
- data de nascimento não pode ser no futuro.

## Contém Seeding do Banco de dados H2 pelo arquivo import.sql

