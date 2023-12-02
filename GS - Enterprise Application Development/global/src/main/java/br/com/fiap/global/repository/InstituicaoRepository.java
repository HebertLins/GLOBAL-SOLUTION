package br.com.fiap.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.model.Usuario.Instituicao;


public interface InstituicaoRepository extends JpaRepository <Instituicao, Long>{
    
}
