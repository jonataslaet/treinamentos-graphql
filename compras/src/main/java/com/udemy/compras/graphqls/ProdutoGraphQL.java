package com.udemy.compras.graphqls;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.entities.Produto;
import com.udemy.compras.graphqls.inputs.ProdutoInput;
import com.udemy.compras.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto getProduto(Long id){
        return produtoService.findById(id);
    }

    public List<Produto> getProdutos(){
        return produtoService.findAll();
    }

    public Produto saveProduto(ProdutoInput produtoInput){
        ModelMapper modelMapper = new ModelMapper();
        Produto p = modelMapper.map(produtoInput, Produto.class);
        return produtoService.save(p);
    }

    public Boolean deletarProduto(Long id){
        return produtoService.deleteById(id);
    }
}
