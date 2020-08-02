package com.rabobbank.statementProcessor.bean;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Customer {
	@JsonProperty(value = "Reference")
	int reference;
	@JsonProperty(value = "AccountNumber")
	String accountNumber;
	@JsonProperty(value = "Description")
	String description;
	@JsonProperty(value = "Start Balance")
	float startBalance;
	@JsonProperty(value = "Mutation")
	float mutation;
	@JsonProperty(value = "End Balance")
	float endBalance;

	public Customer() {
		super();
	}

	public Customer(int reference, String accountNumber, String description, int startBalance, float mutation,
			float endBalance) {
		super();
		this.reference = reference;
		this.accountNumber = accountNumber;
		this.description = description;
		this.startBalance = startBalance;
		this.mutation = mutation;
		this.endBalance = endBalance;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(float startBalance) {
		this.startBalance = startBalance;
	}

	public float getMutation() {
		return mutation;
	}

	public void setMutation(float mutation) {
		this.mutation = mutation;
	}

	public float getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(float endBalance) {
		this.endBalance = endBalance;
	}

}
