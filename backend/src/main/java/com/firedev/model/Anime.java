package com.firedev.model;

/**
 * Essa classe e responsavel por ser o modelo das entidades de animes e mangas se diferenciando pelo atributo type
 */

public class Anime {
	private String id;
	private String type;
	private Attributes attributes;
	
	/**
	 * Construtor sem argumentos
	 */
	public Anime() {
	}
	/**
	 * Construtor com parâmetros
	 * @param id Atributo Identificador
	 * @param type Tipo que define se o objeto é um anime ou manga
	 * @param attributes Objeto de atributos
	 */
	public Anime(String id, String type, Attributes attributes) {
		this.id = id;
		this.type = type;
		this.attributes = attributes;
	}
	/**
	 * Obtem o id do anime/ou manga
	 * @return um <code>String</code> especificando o anime
	 */
	public String getId() {
		return id;
	}
	/**
	 * Modifica o id do anime/ou manga
	 * @param id o identificador do anime/manga
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Obtem o tipo: anime/ou manga
	 * @return um <code>String</code> tipo
	 */
	public String getType() {
		return type;
	}
	/**
	 * Modifica a tipagem que especifica se a entidade é anime ou manga
	 * @param type o tipo de anime/manga
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Obtem o Atributos do anime/manga
	 * @return <Object>Attributes</Object> do anime/manga
	 */
	public Attributes getAttributes() {
		return attributes;
	}
	/**
	 * Modifica o Atributo do anime/manga
	 * @param attributes o Atributo dos animes/mangas
	 */
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	
}
