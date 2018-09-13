package com.believexin.baiduapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrText {

	@JsonProperty("log_id")
	public long logId;
	
	@JsonProperty("words_result_num")
	public int wordsTesultNum;
	
	@JsonProperty("words_result")
	public OcrLine[] wordsResult;

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public int getWordsTesultNum() {
		return wordsTesultNum;
	}

	public void setWordsTesultNum(int wordsTesultNum) {
		this.wordsTesultNum = wordsTesultNum;
	}

	public OcrLine[] getWordsResult() {
		return wordsResult;
	}

	public void setWordsResult(OcrLine[] wordsResult) {
		this.wordsResult = wordsResult;
	}
	
}
