package com.example.contador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class ContadorController {

    private final ContadorRepository contadorRepository;

    // Injeção via construtor
    public ContadorController(ContadorRepository contadorRepository) {
        this.contadorRepository = contadorRepository;
    }

    @GetMapping("/contador")
    public Map<String, Integer> getContador() {
        Contador contador = contadorRepository.findAll().stream().findFirst().orElse(null);
        int valor = (contador == null) ? 0 : contador.getValor();
        Map<String, Integer> resp = new HashMap<>();
        resp.put("valor", valor);
        return resp;
    }

    @PostMapping("/contador/incrementar")
    public Map<String, Integer> incrementar() {
        Contador contador = contadorRepository.findAll().stream().findFirst().orElse(null);
        if (contador == null) {
            contador = new Contador(1);
        } else {
            contador.setValor(contador.getValor() + 1);
        }
        contadorRepository.save(contador);

        Map<String, Integer> resp = new HashMap<>();
        resp.put("valor", contador.getValor());
        return resp;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        Map<String, Object> response = new HashMap<>();
        try {
            long count = contadorRepository.count();
            response.put("status", "ok");
            response.put("mensagem", "Conectado ao MongoDB. Total de registros: " + count);
        } catch (Exception e) {
            response.put("status", "erro");
            response.put("mensagem", "Erro na conexão com o MongoDB: " + e.getMessage());
        }
        return response;
    }
}
