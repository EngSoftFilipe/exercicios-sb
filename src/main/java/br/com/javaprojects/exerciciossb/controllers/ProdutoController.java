package br.com.javaprojects.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaprojects.exerciciossb.models.Produto;
import br.com.javaprojects.exerciciossb.models.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;

@RestController 
@RequestMapping("/api/produtos") 
public class ProdutoController {

    @Autowired 
    private ProdutoRepository produtoRepository;
    
    // Não recomendado se tiver muitos produtos, subir 1 milhão de produtos de uma vez só pode derrubar a API
    // Em caso de muitos produtos, fazer uma consulta paginada
    @GetMapping
    public Iterable<Produto> obterProduto(){
        return produtoRepository.findAll();
    }

    // Consulta paginada
    @GetMapping(path = "/pagina/{numeroPagina}")
    public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina){
        Pageable pagina = PageRequest.of(numeroPagina, 5);
        return produtoRepository.findAll(pagina).getContent();
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    // Não recomendado fazer um método para duas tarefas
    // Pode acontecer de enviar um POST com id existente e sobrescrever ao invés de criar um novo produto
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    @PatchMapping("/{id}") 
    public Produto alterarDadosPendentes(
        @PathVariable int id,
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) @DecimalMin("0.01") Double preco){
            Produto produto = produtoRepository.findById(id).orElseThrow();

                if(nome != null){ produto.setNome(nome); }
                if(preco != null){ produto.setPreco(preco); }

            return produtoRepository.save(produto);
        }

    @DeleteMapping(path = "/{id}") 
    public ResponseEntity<Void> excluirProduto(@PathVariable int id){
        if(!produtoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}