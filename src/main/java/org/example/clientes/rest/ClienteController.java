package org.example.clientes.rest;

import lombok.RequiredArgsConstructor;
import org.example.clientes.model.entity.Cliente;
import org.example.clientes.model.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(CREATED)
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

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        clienteRepository
                .findById(id)
                    .map(c -> {
                        clienteRepository.delete(c);
                        return Void.TYPE;
                })
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND));


    }
}
