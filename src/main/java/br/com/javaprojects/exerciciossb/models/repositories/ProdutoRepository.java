package br.com.javaprojects.exerciciossb.models.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.javaprojects.exerciciossb.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
}
