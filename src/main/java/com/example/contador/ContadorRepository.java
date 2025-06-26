package com.example.contador;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContadorRepository extends MongoRepository<Contador, String> {
}