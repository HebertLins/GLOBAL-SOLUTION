package br.com.fiap.global.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.global.model.Comprovante;
import br.com.fiap.global.repository.ComprovanteRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/comprovante")
public class ComprovanteController {
    
        List<Comprovante> Comprovantes = new ArrayList<>();

    @Autowired
    ComprovanteRepository repository;

    @GetMapping
    public List<Comprovante> ListAll() {
        log.info("buscando todas comprovantes =D!");
        return repository.findAll();
    }

     @GetMapping("{id}")
    public ResponseEntity<Comprovante> ListById(@PathVariable Long id) {
        log.info("mostrar Comprovante com id " + id);
        return ResponseEntity.ok(getComprovanteById(id));

    }

    @PostMapping
    public ResponseEntity<Object> Insert(@RequestBody @Valid Comprovante Comprovante) {
        log.info("cadastrando Comprovante - " + Comprovante);
        repository.save(Comprovante);
        return ResponseEntity.status(HttpStatus.CREATED).body(Comprovante);
    }

    @PutMapping("{id}")
    public ResponseEntity<Comprovante> update(@PathVariable Long id, @RequestBody Comprovante Comprovante){
        log.info("atualizando dados do Movimentacao com id " + id);
        getComprovanteById(id);
        Comprovante.setId_comprovante(id);
        repository.save(Comprovante);

        return ResponseEntity.ok(Comprovante);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id){
        log.info("apagando Movimentacao com id " + id);
        repository.delete(getComprovanteById(id));
        return ResponseEntity.noContent().build();
    }

    private Comprovante getComprovanteById(Long id){
        return repository.findById(id).orElseThrow(() -> { 
             return new RuntimeException();
         });
        }

}
