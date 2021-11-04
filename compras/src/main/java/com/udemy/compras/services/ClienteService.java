package com.udemy.compras.services;

import com.udemy.compras.entities.Cliente;
import com.udemy.compras.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente c){
        return clienteRepository.save(c);
    }

    public Boolean deleteById(Long id){
        Optional<Cliente> clienteInTheDatabase = clienteRepository.findById(id);
        if (!clienteInTheDatabase.isPresent()){
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
}
