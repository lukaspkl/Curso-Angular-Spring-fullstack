package org.example.clientes.rest;

import lombok.RequiredArgsConstructor;
import org.example.clientes.model.entity.Cliente;
import org.example.clientes.model.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Cliente salvar (@RequestBody @Valid Cliente cliente){
        return clienteRepository
                .save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharporId (@PathVariable Integer id){
        return clienteRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente nao Encontrado"));

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
                            HttpStatus.NOT_FOUND, "Cliente nao Encontrado"));


    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void atualizar (
            @PathVariable Integer id,@RequestBody @Valid Cliente clienteatualizado ){
            clienteRepository
                    .findById(id)
                    .map(c ->{
                        clienteatualizado.setId(c.getId());
                        return clienteRepository.save(clienteatualizado);


                    })
                    .orElseThrow(()-> new ResponseStatusException(NOT_FOUND, "Cliente nao Encontrado"));


    }
}
