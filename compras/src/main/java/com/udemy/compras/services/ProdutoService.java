package com.udemy.compras.services;

import com.udemy.compras.entities.Cliente;
import com.udemy.compras.entities.Produto;
import com.udemy.compras.repositories.ClienteRepository;
import com.udemy.compras.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto save(Produto p){
        return produtoRepository.save(p);
    }

    public Boolean deleteById(Long id){
        Optional<Produto> produtoInTheDatabase = produtoRepository.findById(id);
        if (!produtoInTheDatabase.isPresent()){
            return false;
        }
        produtoRepository.deleteById(id);
        return true;
    }
}
