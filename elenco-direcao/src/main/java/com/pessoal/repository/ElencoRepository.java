package com.pessoal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pessoal.model.Elenco;

@Repository
public interface ElencoRepository extends MongoRepository<Elenco, String> {
	public Optional<Elenco> findByNome(String nome);
}
