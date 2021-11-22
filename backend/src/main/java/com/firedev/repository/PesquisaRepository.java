package com.firedev.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.firedev.model.Pesquisa;

import feign.Param;

@Repository
public class PesquisaRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertBuscaNoBD(Pesquisa pesquisa) {
	    entityManager.createNativeQuery("INSERT INTO tb_pesquisa(id, moment, busca) VALUES (?,?,?)")
	      .setParameter(1, pesquisa.getId())
	      .setParameter(2, pesquisa.getMoment())
	      .setParameter(3, pesquisa.getBusca())
	      .executeUpdate();
	}

}