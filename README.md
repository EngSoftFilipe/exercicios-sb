# exercicios-sb
 
Estudos e testes com Spring Boot.
 
Projeto de aprendizado onde pratico os fundamentos do Spring Boot: web services, controllers, verbos HTTP, JPA, validação e um CRUD completo de produtos, com páginas em HTML, CSS e JavaScript consumindo a API.
 
## Tecnologias
 
- Java 21
- Spring Boot 4.1.1
- Maven
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Boot DevTools
- MySQL
- HTML
- CSS
- JavaScript
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
 
## Endpoints
 
### Produtos (`/api/produtos`)
 
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/produtos` | Lista todos os produtos |
| GET | `/api/produtos/{id}` | Busca um produto pelo id |
| POST / PUT | `/api/produtos` | Cria ou atualiza um produto (`nome`, `preco`) |
| PATCH | `/api/produtos/{id}` | Altera só os campos enviados (`nome`, `preco`) |
| DELETE | `/api/produtos/{id}` | Exclui um produto (204, ou 404 se não existir) |
 
### Outros exemplos
 
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/teste` e `/apresentacao` | Mensagem de apresentação |
| GET | `/calculadora/somar/{a}/{b}` (e subtrair, multiplicar, dividir) | Calculadora com `@PathVariable` |
| GET | `/clientes/{id}` e `/clientes/parametros?id=` | Exemplos com `@PathVariable` e `@RequestParam` |
| GET, POST, PUT, PATCH, DELETE | `/metodos` | Mostra qual verbo HTTP foi usado |
 
## Páginas
 
Abertas pela própria aplicação (porta 8080):
 
- `http://localhost:8080/formulario.html`: cadastra um produto (POST).
- `http://localhost:8080/editar-produto.html`: altera um produto (PATCH).
## Validações
 
- `nome`: obrigatório e não pode ficar em branco.
- `preco`: obrigatório e a partir de R$ 0,01.
## Configuração do banco
 
O arquivo `src/main/resources/application.properties` não é versionado (está no `.gitignore`) porque contém credenciais. Crie esse arquivo localmente com algo assim:
 
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```
 
O schema `springboot` precisa existir no MySQL. As tabelas são criadas pelo Hibernate.
 
## Anotações de estudo
 
- [MVC](docs/mvc.md)
- [CrudRepository](docs/crudrepository.md)
## Status
 
Em andamento, acompanhando o curso e evoluindo aula a aula.