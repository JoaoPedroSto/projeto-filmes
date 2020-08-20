package com.pessoal.infra.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pessoal.domain.entity.Elenco;

@Repository
public interface ElencoRepository extends MongoRepository<Elenco, String> {
	public Optional<Elenco> findByNome(String nome);
}
