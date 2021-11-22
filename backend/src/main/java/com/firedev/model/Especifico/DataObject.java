package com.firedev.model.Especifico;

import com.firedev.model.Anime;

public class DataObject extends Anime{
	private AttributesCompleted attributes;
	
	public DataObject() {
	}
	
	public DataObject(String id, String type, AttributesCompleted attributes) {
		super(id, type, attributes);
		this.attributes = attributes;
	}
 


	public AttributesCompleted getAttributes() {
		return attributes;
	}

	public void setAttributes(AttributesCompleted attributes) {
		this.attributes = attributes;
	}
	

}
