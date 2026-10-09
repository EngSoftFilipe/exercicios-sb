# exercicios-sb
 
Estudos e testes com Spring Boot.
 
Projeto de aprendizado onde pratico os fundamentos do Spring Boot: web services, controllers, verbos HTTP e, nas próximas etapas, JPA e CRUD.
 
## Tecnologias
 
- Java 21
- Spring Boot 4.1.1
- Maven
- Spring Web
- Spring Boot DevTools
## Como executar
 
Na raiz do projeto (onde fica o `pom.xml`):
 
```
./mvnw spring-boot:run
```
 
No PowerShell do Windows:
 
```
.\mvnw spring-boot:run
```
 
A aplicação sobe em `http://localhost:8080`.
 
## Endpoints atuais
 
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/teste` e `/apresentacao` | Retorna uma mensagem de apresentação |
 
## Configuração do banco
 
O arquivo `src/main/resources/application.properties` não é versionado (está no `.gitignore`) porque pode conter credenciais. Ao configurar o banco, crie esse arquivo localmente.
 
## Status
 
Em andamento, acompanhando o curso e evoluindo aula a aula.