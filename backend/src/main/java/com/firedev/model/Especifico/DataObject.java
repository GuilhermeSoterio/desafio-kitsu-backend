package com.firedev.model.Especifico;

import com.firedev.model.Anime;

public class DataObject {
	private String id;
	private String type;
	private Anime anime;
	
	public DataObject() {
	}
	
	public DataObject(String id, String type, Anime anime) {
		super();
		this.id = id;
		this.type = type;
		this.anime = anime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}
	
	
}
