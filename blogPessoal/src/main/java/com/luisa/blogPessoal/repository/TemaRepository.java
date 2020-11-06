package com.luisa.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisa.blogPessoal.model.Tema;
                                                  //Entidade , tipo do ID
public interface TemaRepository extends JpaRepository <Tema, Long> {
	public List <Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
		
}
