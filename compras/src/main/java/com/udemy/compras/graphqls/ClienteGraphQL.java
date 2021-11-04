package com.udemy.compras.graphqls;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.graphqls.inputs.ClienteInput;
import com.udemy.compras.services.ClienteService;
import com.udemy.compras.entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public Cliente saveCliente(ClienteInput clienteInput){
        ModelMapper modelMapper = new ModelMapper();
        Cliente c = modelMapper.map(clienteInput, Cliente.class);
        return clienteService.save(c);
    }

    public Boolean deletarCliente(Long id){
        return clienteService.deleteById(id);
    }
}
