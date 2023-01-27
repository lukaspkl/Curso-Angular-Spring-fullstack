package org.example.clientes.rest;

import org.example.clientes.model.entity.Cliente;
import org.example.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@RequestBody Cliente cliente){
        return clienteRepository
                .save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharporId (@PathVariable Integer id){
        return clienteRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND));

    }
}
