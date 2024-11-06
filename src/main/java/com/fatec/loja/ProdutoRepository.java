package com.fatec.loja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends
JpaRepository<Produto, Integer>{
    @Query(value = "select * from produto where destaque > 0", nativeQuery = true)
    List<Produto> getProdutoEmDestaque();

    @Query(value = "select * from produto where nome like %?1%", nativeQuery = true)
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
