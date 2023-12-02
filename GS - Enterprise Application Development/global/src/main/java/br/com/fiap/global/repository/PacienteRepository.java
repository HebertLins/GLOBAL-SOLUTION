package br.com.fiap.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.model.Usuario.Paciente;

public interface PacienteRepository extends JpaRepository <Paciente, Long>{
    
}
