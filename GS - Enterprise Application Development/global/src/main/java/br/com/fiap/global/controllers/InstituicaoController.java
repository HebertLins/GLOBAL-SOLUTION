package br.com.fiap.global.controllers;

import br.com.fiap.global.model.Comprovante;
import br.com.fiap.global.model.Usuario.Instituicao;
import br.com.fiap.global.repository.ComprovanteRepository;
import br.com.fiap.global.repository.InstituicaoRepository;
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
@RequestMapping("/instituicao")
public class InstituicaoController {

    List<Instituicao> Instituicoes = new ArrayList<>();

    @Autowired
    InstituicaoRepository repository;

    @GetMapping
    public List<Instituicao> ListAll() {
        log.info("buscando todas Instituicoes =D!");
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Instituicao> ListById(@PathVariable Long id) {
        log.info("mostrar Instituicao com id " + id);
        return ResponseEntity.ok(getInstituicaoById(id));

    }

    @PostMapping
    public ResponseEntity<Object> Insert(@RequestBody @Valid Instituicao Instituicao) {
        log.info("cadastrando Instituicao - " + Instituicao);
        repository.save(Instituicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(Instituicao);
    }

    @PutMapping("{id}")
    public ResponseEntity<Instituicao> update(@PathVariable Long id, @RequestBody Instituicao Instituicao){
        log.info("atualizando dados do Movimentacao com id " + id);
        getInstituicaoById(id);
        Instituicao.setId_usuario(id);
        repository.save(Instituicao);

        return ResponseEntity.ok(Instituicao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id){
        log.info("apagando Instituicao com id " + id);
        repository.delete(getInstituicaoById(id));
        return ResponseEntity.noContent().build();
    }

    private Instituicao getInstituicaoById(Long id){
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
    }

}
