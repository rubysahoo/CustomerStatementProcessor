package com.rabobbank.statementProcessor.bean;

import org.json.simple.JSONArray;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class Result{
	String result;
	JSONArray errorRecords;

	public JSONArray geterrorRecords() {
		return errorRecords;
	}

	public void seterrorRecords(JSONArray array) {
		this.errorRecords = array;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Bean 
	public ObjectMapper objectMapper() {
		 return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);}
}
