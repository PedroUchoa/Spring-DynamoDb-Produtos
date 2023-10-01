package com.linuxtips.produtos_api.repository;

import com.linuxtips.produtos_api.model.Produto;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProdutoRepository extends CrudRepository<Produto,String> {




}
