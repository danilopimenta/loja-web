package com.fatec.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VitrineController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/api/vitrine")
    public List<Produto> listar() {
        return produtoRepository.getProdutoEmDestaque();
    }

    //filtrar por nome de produto
    @PostMapping("/api/vitrine/buscar")
    public List<Produto> buscar(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
