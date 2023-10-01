package com.linuxtips.produtos_api.services;

import com.amazonaws.services.kms.model.NotFoundException;
import com.linuxtips.produtos_api.model.Produto;
import com.linuxtips.produtos_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public Produto buscarProdutoPorId(String produtoID) {
        Optional<Produto> produto = produtoRepository.findById(produtoID);
        if(produto.isPresent()){
            return produto.get();
        }
        throw new NotFoundException("Não foi possivel encontrar o produto");
    }

    public Iterable<Produto> buscarTodosOsProdutos() {
        Iterable<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public String excluir(String produtoID) {
        Optional<Produto> produto = produtoRepository.findById(produtoID);
        if(!produto.isPresent()){
            throw new NotFoundException("Não foi possivel encontrar o produto");
        }
        produtoRepository.delete(produto.get());
        return "Produto excluido do cadastro com sucesso";
    }


    public Produto atualizar(String produtoId, Produto produto) {
      Optional<Produto> produto1 = produtoRepository.findById(produtoId);
      if(!produto1.isPresent()){
          throw new NotFoundException("Id do produto invalido");
      }
      produto1.get().updateProduto(produto);
      return produtoRepository.save(produto1.get());
    }

}
