package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
}
