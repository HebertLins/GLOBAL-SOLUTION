package br.com.fiap.global.controllers;

import br.com.fiap.global.model.Lembrete;
import br.com.fiap.global.model.Usuario.Instituicao;
import br.com.fiap.global.repository.InstituicaoRepository;
import br.com.fiap.global.repository.LembreteRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/lembrete")
public class LembreteController {

    List<Lembrete> Lembretes = new ArrayList<>();

    @Autowired
    LembreteRepository repository;

    @GetMapping
    public List<Lembrete> ListAll() {
        log.info("buscando todas Lembretes =D!");
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Lembrete> ListById(@PathVariable Long id) {
        log.info("mostrar Lembrete com id " + id);
        return ResponseEntity.ok(getLembreteById(id));

    }

    @PostMapping
    public ResponseEntity<Object> Insert(@RequestBody @Valid Lembrete Lembrete) {
        log.info("cadastrando Lembrete - " + Lembrete);
        repository.save(Lembrete);
        return ResponseEntity.status(HttpStatus.CREATED).body(Lembrete);
    }

    @PutMapping("{id}")
    public ResponseEntity<Lembrete> update(@PathVariable Long id, @RequestBody Lembrete Lembrete){
        log.info("atualizando dados do Lembrete com id " + id);
        getLembreteById(id);
        Lembrete.setId_lembrete(id);
        repository.save(Lembrete);

        return ResponseEntity.ok(Lembrete);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id){
        log.info("apagando Lembrete com id " + id);
        repository.delete(getLembreteById(id));
        return ResponseEntity.noContent().build();
    }

    private Lembrete getLembreteById(Long id){
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }

}
