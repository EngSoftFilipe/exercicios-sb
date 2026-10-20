package br.com.javaprojects.exerciciossb.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @PostMapping
    public @ResponseBody Produto novoProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProduto(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
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
}