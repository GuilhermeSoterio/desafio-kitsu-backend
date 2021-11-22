package com.firedev.model;

import java.util.List;

public class DataResponse {
	private List<Anime> data;

	public DataResponse() {
	}
	
	public DataResponse(List<Anime> data) {
		this.data = data;
	}

	public List<Anime> getData() {
		return data;
	}

	public void setData(List<Anime> data) {
		this.data = data;
	}
	
}
