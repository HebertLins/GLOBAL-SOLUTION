package br.com.fiap.global.controllers;

import br.com.fiap.global.model.Lembrete;
import br.com.fiap.global.model.Usuario.Paciente;
import br.com.fiap.global.repository.LembreteRepository;
import br.com.fiap.global.repository.PacienteRepository;
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
@RequestMapping("/paciente")
public class PacienteController {

    List<Paciente> Pacientes = new ArrayList<>();

    @Autowired
    PacienteRepository repository;

    @GetMapping
    public List<Paciente> ListAll() {
        log.info("buscando todas Pacientes =D!");
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Paciente> ListById(@PathVariable Long id) {
        log.info("mostrar Paciente com id " + id);
        return ResponseEntity.ok(getPacienteById(id));

    }

    @PostMapping
    public ResponseEntity<Object> Insert(@RequestBody @Valid Paciente Paciente) {
        log.info("cadastrando Paciente - " + Paciente);
        repository.save(Paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Paciente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente Paciente){
        log.info("atualizando dados do Paciente com id " + id);
        getPacienteById(id);
        Paciente.setId_usuario(id);
        repository.save(Paciente);

        return ResponseEntity.ok(Paciente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id){
        log.info("apagando Lembrete com id " + id);
        repository.delete(getPacienteById(id));
        return ResponseEntity.noContent().build();
    }

    private Paciente getPacienteById(Long id){
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }

}
