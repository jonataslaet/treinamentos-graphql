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
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email){
        Cliente c = new Cliente(id, nome, email);
        return clienteRepository.save(c);
    }

    public Boolean deletarCliente(Long id){
        Optional<Cliente> clienteInTheDatabase = clienteRepository.findById(id);
        if (!clienteInTheDatabase.isPresent()){
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
}
