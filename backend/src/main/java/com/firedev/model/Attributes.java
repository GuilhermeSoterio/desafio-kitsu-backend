package com.firedev.model;

/**
 * Essa classe e responsavel por ser o modelo das entidades de atributos com o titulo.
 */
public class Attributes {
	private String canonicalTitle;
	/**
	 * Construtor sem argumentos
	 */
	public Attributes() {
	}
	/**
	 * Construtor com argumentos
	 * @param canonicalTitle o titulo
	 */
	public Attributes(String canonicalTitle) {
		this.canonicalTitle = canonicalTitle;
	}
	/**
	 * Obtem o titulo do Atributo
	 * @return um <code>String</code> especificando o titulo do anime/manga
	 */
	public String getCanonicalTitle() {
		return canonicalTitle;
	}
	/**
	 * Modifica o titulo do anime
	 * @param canonicalTitle titulo
	 */
	public void setCanonicalTitle(String canonicalTitle) {
		this.canonicalTitle = canonicalTitle;
	}
	
}
