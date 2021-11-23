package com.firedev.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.firedev.model.Pesquisa;

import feign.Param;
/**
 * Classe da camada de repositorio responsavel para acessar os dados do banco de dados MySQL
 *
 */
@Repository
public class PesquisaRepository {

	@PersistenceContext
    private EntityManager entityManager;
	/**
	 * Metodo para inserir valores das pesquisas do usuario no Banco de dados
	 * @param pesquisa, pesquisa realizada pelo usuario
	 */
	@Transactional
	public void insertBuscaNoBD(Pesquisa pesquisa) {
	    entityManager.createNativeQuery("INSERT INTO tb_pesquisa(id, moment, busca) VALUES (?,?,?)")
	      .setParameter(1, pesquisa.getId())
	      .setParameter(2, pesquisa.getMoment())
	      .setParameter(3, pesquisa.getBusca())
	      .executeUpdate();
	}

}