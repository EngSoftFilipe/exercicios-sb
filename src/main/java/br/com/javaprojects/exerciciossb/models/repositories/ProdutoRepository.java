package br.com.javaprojects.exerciciossb.models.repositories;

// import org.springframework.data.repository.CrudRepository; (Apenas CRUD)
// JpaRepository é uma versão mais completa do CrudRepository, (CRUD, páginação e ordenação)
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.javaprojects.exerciciossb.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
