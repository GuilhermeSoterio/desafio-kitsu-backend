package com.firedev.model;

import java.util.List;
/**
 * Essa classe e responsavel por ser o modelo da Data Response que possui a lista de animes.
 */
public class DataResponse {
	private List<Anime> data;
	/**
	 * Construtor DataResponse sem argumentos
	 */
	public DataResponse() {
	}
	/**
	 * Construtor DataResponse
	 * @param data
	 */
	public DataResponse(List<Anime> data) {
		this.data = data;
	}
	/**
	 * Obtem a lista de animes
	 * @return um <code>Array</code> especificando a lista de animes
	 */
	public List<Anime> getData() {
		return data;
	}
	/**
	 * Modifica a lista de animes
	 * @param data a lista de animes
	 */
	public void setData(List<Anime> data) {
		this.data = data;
	}
	
}
