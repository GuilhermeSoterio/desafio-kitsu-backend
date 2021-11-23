package com.firedev.model.Especifico;

import java.util.ArrayList;
import java.util.List;

import com.firedev.model.Anime;
import com.firedev.model.Attributes;
import com.firedev.model.DataResponse;

/**
 * Classe pai da API para percorrer os demais objetos dos animes, manga e episodios especificos
 *
 */
public class DataObject {
	private String id;
	private String type;
	private AttributesCompleted attributes;
	/**
	 * Construtor sem argumentos
	 */
	public DataObject() {
	}
	/**
	 * Construtor com argumentos
	 * @param id identificador do DataObject
	 * @param type tipagem do anime ou manga
	 * @param attributes atributos do anime ou manga
	 */
	public DataObject(String id, String type, AttributesCompleted attributes) {
		this.id = id;
		this.type = type;
		this.attributes = attributes;
	}
	/**
	 * Obtem o identificador
	 * @return um <code>String</code> especificando o identificador DataObject
	 */
	public String getId() {
		return id;
	}
	/**
	 * Modifica o identificador
	 * @param id identificador
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Obtem o tipagem anime/manga
	 * @return <code>String</code> especificando o tipo de anime/manga
	 */
	public String getType() {
		return type;
	}
	/**
	 * Modifica o tipo anime ou manga
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Objeto de atributos mais detalhado
	 * @return <code>Object</code> Atributos
	 */
	public AttributesCompleted getAttributes() {
		return attributes;
	}
	/**
	 * Modifica o objeto Atributos completo
	 * @param attributes. Atributos completo
	 */
	public void setAttributes(AttributesCompleted attributes) {
		this.attributes = attributes;
	}
	

}
