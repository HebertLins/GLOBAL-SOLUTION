package br.com.fiap.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.model.Comprovante;

public interface ComprovanteRepository extends JpaRepository <Comprovante, Long> {
    
}
