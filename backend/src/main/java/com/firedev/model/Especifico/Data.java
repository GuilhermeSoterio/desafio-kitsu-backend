package com.firedev.model.Especifico;
/**
 * Classe que representa um objeto de Data necessaria para percorrer ate um anime/manga especifico
 */
public class Data {
	private DataObject data;
	/**
	 * Construtor sem argumentos
	 */
	public Data() {
	}
	/**
	 * Construtor com argumentos
	 * @param data
	 */
	public Data(DataObject data) {
		this.data = data;
	}
	/**
	 * Obtem o objeto Data
	 * @return <code>Object</code> Objeto que representa a Data
	 */
	public DataObject getData() {
		return data;
	}
	/**
	 * Modifica o objeto data
	 * @param data
	 */
	public void setData(DataObject data) {
		this.data = data;
	}
	
	
}
