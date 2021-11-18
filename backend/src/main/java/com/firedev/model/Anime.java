package com.firedev.model;

public class Anime {
	private String id;
	private String type;
	private Attributes attributes;
	
	
	public Anime() {
	}
	
	public Anime(String id, String type, Attributes attributes) {
		this.id = id;
		this.type = type;
		this.attributes = attributes;
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
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	
}
