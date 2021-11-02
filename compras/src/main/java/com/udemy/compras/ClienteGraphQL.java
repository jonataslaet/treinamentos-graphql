package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente getCliente(Long id){
        return clienteService.findById(id);
    }

    public List<Cliente> getClientes(){
        return clienteService.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email){
        Cliente c = new Cliente(id, nome, email);
        return clienteService.save(c);
    }

    public Boolean deletarCliente(Long id){
        return clienteService.deleteById(id);
    }
}
