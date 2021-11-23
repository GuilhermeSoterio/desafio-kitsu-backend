package com.firedev.model.Especifico;


import com.firedev.model.Attributes;
	/**
	 * 
	 * @author Guilherme
	 *
	 */
public class AttributesCompleted  extends Attributes{
	private String ratingRank;
	private String averageRaging;
	private String synopsis;
	private String episodeCount;
	/**
	 * Construtor sem argumentos	
	 */
	public AttributesCompleted() {
	}
	/**
	 * Construtor com argumentos
	 * @param canonicalTitle Titulo do anime/manga
	 * @param ratingRank Valor de ranqueamento
	 * @param averageRaging Media de notas
	 * @param synopsis Descricao do anime
	 * @param episodeCount Numero de episodios
	 */
	public AttributesCompleted(String canonicalTitle, String ratingRank, String averageRaging, String synopsis, String episodeCount) {
		super(canonicalTitle);
		this.ratingRank = ratingRank;
		this.averageRaging = averageRaging;
		this.synopsis = synopsis;
		this.episodeCount = episodeCount;
	}
	/**
	 * Obtem o valor de ranqueamento
	 * @return <code>String</code> especificando o valor do ranquamento
	 */
	public String getRatingRank() {
		return ratingRank;
	}
	/**
	 * Modifica o valor do ranqueamento
	 * @param ratingRank valor de ranqueamento
	 */
	public void setRatingRank(String ratingRank) {
		this.ratingRank = ratingRank;
	}
	/**
	 * Obtem a media das notas
	 * @return <code>String</code> especificando a media de notas
	 */
	public String getAverageRaging() {
		return averageRaging;
	}
	/**
	 * Modifica a media das notas
	 * @param averageRaging media das notas
	 */
	public void setAverageRaging(String averageRaging) {
		this.averageRaging = averageRaging;
	}
	/**
	 * Obtem a sinopse do anime/manga
	 * @return <code>String</code> especificando o sinopse do anime/manga
	 */
	public String getSynopsis() {
		return synopsis;
	}
	/**
	 * Modifica a descricao do anime/manga
	 * @param synopsis sinopse do anime/manga
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	/**
	 * Obtem a contagem de episodios
	 * @return <cod>String</code> especificando a contagem de episodios
	 */
	public String getEpisodeCount() {
		return episodeCount;
	}
	/**
	 * Modifica a contagem de episodios do anime/manga
	 * @param episodeCount contagem episodio
	 */
	public void setEpisodeCount(String episodeCount) {
		this.episodeCount = episodeCount;
	}
	
	
	
}
