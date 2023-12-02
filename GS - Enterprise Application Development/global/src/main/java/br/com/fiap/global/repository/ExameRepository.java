package br.com.fiap.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.model.Exame;

public interface ExameRepository extends JpaRepository <Exame, Long>{
    
}
