package com.firedev.model.Especifico;

import com.firedev.model.Anime;

public class DataObject {
	private String id;
	private String type;
	private AttributesCompleted attributes;
	
	public DataObject() {
	}
	
	public DataObject(String id, String type, AttributesCompleted attributes) {
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

	public AttributesCompleted getAttributes() {
		return attributes;
	}

	public void setAttributes(AttributesCompleted attributes) {
		this.attributes = attributes;
	}
	

}
