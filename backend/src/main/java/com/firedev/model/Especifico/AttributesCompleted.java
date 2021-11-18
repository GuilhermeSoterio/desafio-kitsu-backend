package com.firedev.model.Especifico;

import com.firedev.model.Attributes;

public class AttributesCompleted  extends Attributes{
	private String ratingRank;
	private String averageRaging;
	private String synopsis;
	private String episodeCount;
	
	public AttributesCompleted() {
	}
	
	public AttributesCompleted(String ratingRank, String averageRaging, String synopsis, String episodeCount) {
		super();
		this.ratingRank = ratingRank;
		this.averageRaging = averageRaging;
		this.synopsis = synopsis;
		this.episodeCount = episodeCount;
	}

	public String getRatingRank() {
		return ratingRank;
	}

	public void setRatingRank(String ratingRank) {
		this.ratingRank = ratingRank;
	}

	public String getAverageRaging() {
		return averageRaging;
	}

	public void setAverageRaging(String averageRaging) {
		this.averageRaging = averageRaging;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(String episodeCount) {
		this.episodeCount = episodeCount;
	}
	
	
	
}
