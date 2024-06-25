package com.moises.curso.springboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@RequestScope
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Client {

    @Value("${client.name}")
    private String name;
    @Value("${client.lastname}")
    private String last;

    public String getName() {
        return name;
    }
    public void setName(String client) {
        this.name = client;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    
}
