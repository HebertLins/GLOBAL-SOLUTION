package br.com.fiap.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.model.Lembrete;


public interface LembreteRepository extends JpaRepository <Lembrete, Long>{
    
}
