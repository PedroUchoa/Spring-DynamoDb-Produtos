package com.linuxtips.produtos_api.controllers;

import com.linuxtips.produtos_api.model.Produto;
import com.linuxtips.produtos_api.repository.ProdutoRepository;
import com.linuxtips.produtos_api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @PostMapping("/produtos")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        Produto produto1 = produtoService.salvar(produto);
        return ResponseEntity.ok().body(produto1);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") String produtoId){
        Produto produto = produtoService.buscarProdutoPorId(produtoId);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/produtos")
    public ResponseEntity<Iterable<Produto>> buscarTodosOsProdutos(){
        Iterable<Produto> produtos = produtoService.buscarTodosOsProdutos();
        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") String produtoId){
        String texto = produtoService.excluir(produtoId);
        return ResponseEntity.ok().body(texto);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable("id") String produtoId, @RequestBody Produto produto){
        Produto produto1 = produtoService.atualizar(produtoId,produto);
        return ResponseEntity.ok().body(produto1);
    }

}
