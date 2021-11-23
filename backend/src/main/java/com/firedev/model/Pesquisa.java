package com.firedev.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *Classe Responsavel por ser a entidade de persistencia do banco de dados que vai registrar as pesquisas 
 *
 */
@Entity
@Table(name = "tb_pesquisa")
public class Pesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Instant moment;
	private String busca;
	/**
	 * Construtor pesquisa sem argumentos
	 */
	public Pesquisa() {
	}
	/**
	 * Construtor pesquisa com argumentos.
	 * @param id identificador da pesquisa
	 * @param moment Data/hora da pesquisa
	 * @param busca Valor textual da pesquisa que o usuario fez
	 */
	public Pesquisa(String id, Instant moment, String busca) {
		super();
		this.id = id;
		this.moment = moment;
		this.busca = busca;
	}
	/**
	 * Obtem o id identificador
	 * @return um <code>String</code> Id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Modifica o id - identificador
	 * @param id especificando o id da pesquisa
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Obtem a Data e Hora
	 * @return um <code>Object</code> moment
	 */
	public Instant getMoment() {
		return moment;
	}
	/**
	 * Modifica a Data Hora.
	 * @param moment especificando a Data/hora da pesquisa
	 */
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	/**
	 * Obtem a busca do anime realizada pelo usuario
	 * @return um <code>String</code> busca
	 */
	public String getBusca() {
		return busca;
	}
	/**
	 * Modifica a pesquisa do usuario
	 * @param busca valor textual da pesquisa
	 */
	public void setBusca(String busca) {
		this.busca = busca;
	}
	
	
}
