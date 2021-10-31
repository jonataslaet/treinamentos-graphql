package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String getHello(){
        return "Hello, graphql";
    }

    public Integer getSoma(Integer a, Integer b) {
        return a+b;
    }

    public Cliente getCliente(){
        return new Cliente("Jonatas", "jonataslaet@gmail.com");
    }

    public List<Cliente> getClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (int i = 0; i < 10; i++) {
            clientes.add(new Cliente("Cliente "+i+1, "j"+i+"@gmail.com"));
        }
        return clientes;
    }
}
