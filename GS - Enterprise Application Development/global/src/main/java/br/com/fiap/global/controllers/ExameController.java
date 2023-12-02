package br.com.fiap.global.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.global.model.Exame;
import br.com.fiap.global.repository.ExameRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/exame")
public class ExameController {
    
            List<Exame> Exames = new ArrayList<>();

    @Autowired
    ExameRepository repository;

    @GetMapping
    public List<Exame> ListAll() {
        log.info("buscando todas comprovantes =D!");
        return repository.findAll();
    }

     @GetMapping("{id}")
    public ResponseEntity<Exame> ListById(@PathVariable Long id) {
        log.info("mostrar Comprovante com id " + id);
        return ResponseEntity.ok(getExameById(id));

    }

    @PostMapping
    public ResponseEntity<Object> Insert(@RequestBody @Valid Exame Exame) {
        log.info("cadastrando Comprovante - " + Exame);
        repository.save(Exame);
        return ResponseEntity.status(HttpStatus.CREATED).body(Exame);
    }

    @PutMapping("{id}")
    public ResponseEntity<Exame> update(@PathVariable Long id, @RequestBody Exame Exame){
        log.info("atualizando dados do Movimentacao com id " + id);
        getExameById(id);
        Exame.setId_exame(id);
        repository.save(Exame);

        return ResponseEntity.ok(Exame);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id){
        log.info("apagando Movimentacao com id " + id);
        repository.delete(getExameById(id));
        return ResponseEntity.noContent().build();
    }

    private Exame getExameById(Long id){
        return repository.findById(id).orElseThrow(() -> { 
             return new RuntimeException();
         });
        }

}



