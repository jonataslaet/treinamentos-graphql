package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String getHello(){
        return "Hello, graphql";
    }

    public Integer getSoma(Integer a, Integer b) {
        return a+b;
    }
}
