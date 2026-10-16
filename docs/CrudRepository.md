# CrudRepository
 
O `CrudRepository` é uma interface pronta do Spring Data que já traz os métodos básicos para mexer no banco de dados. Quando um repository estende ela, ele herda esses métodos sem precisar escrever nenhuma linha de SQL.
 
**CRUD** são as quatro operações básicas: **C**reate (criar), **R**ead (ler), **U**pdate (atualizar) e **D**elete (apagar).
 
## Como usar
 
```java
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
```
 
- `Produto`: a entidade (tabela) que esse repository cuida.
- `Integer`: o tipo do id dessa entidade.
A interface fica vazia, e mesmo assim funciona: o Spring escreve o código dos métodos quando a aplicação liga.
 
## Métodos principais
 
| Método | O que faz |
|---|---|
| `save(objeto)` | Cria um novo, ou atualiza se já tiver id |
| `findAll()` | Busca todos |
| `findById(id)` | Busca um pelo id |
| `deleteById(id)` | Apaga pelo id |
| `count()` | Conta quantos existem |
| `existsById(id)` | Diz se aquele id existe |
 
## Exemplo no controller
 
```java
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
 
    @Autowired
    private ProdutoRepository produtoRepository;
 
    @PostMapping
    public Produto novoProduto(@RequestParam String nome) {
        Produto produto = new Produto(nome);
        produtoRepository.save(produto);
        return produto;
    }
 
    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }
}
```
 
## Observações
 
- O `findAll()` devolve um `Iterable`, que é qualquer coisa que dá para percorrer item por item.
- O `JpaRepository` é um primo maior: tem tudo do `CrudRepository` e mais recursos, como paginação e retorno em `List`.
**Resumo:** o `CrudRepository` entrega pronto o criar, ler, atualizar e apagar, e você só diz qual entidade e qual tipo de id.