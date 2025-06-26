package com.example.contador;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contador {

    @Id
    private String id;
    private int valor;

    public Contador() {}

    public Contador(int valor) {
        this.valor = valor;
    }
    
    public Contador(String id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}