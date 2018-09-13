package com.believexin.baiduapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrLine {

	@JsonProperty("location")
	public Object location;
	
	@JsonProperty("words")
	public String words;

	public Object getLocation() {
		return location;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}
}
