package br.com.javaprojects.exerciciossb.models.repositories;

// import org.springframework.data.repository.CrudRepository; (Apenas CRUD)
// JpaRepository é uma versão mais completa do CrudRepository, (CRUD, páginação e ordenação)
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.javaprojects.exerciciossb.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
    // O spring decide o que buscar pelo nome do método, por isso o "Nome" ao invés de "Name"
    // Na classe Produto as variáveis estão todas em português
    // Para usar um nome qualquer no método, é preciso escrever a consulta com @Query (em JPQL)

    // O padrão de mercado é escrever código em inglês, juntar dois idiomas deixa bagunçado
    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
}