package com.rabobbank.statementProcessor.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonParseException;
import com.rabobbank.statementProcessor.bean.Customer;
import com.rabobbank.statementProcessor.bean.Result;

@Service
public class CustomerService {
	@Autowired
	Customer cust;
	@Autowired
	Result res;
	@Autowired
	HttpServletResponse status;

	public Result parseRequest(ArrayList<Customer> cust) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		try {
			for (Customer customer : cust) {
				float startalance = customer.getStartBalance();
				float mutation = customer.getMutation();
				float endBalance = startalance + mutation;
				int reference = customer.getReference();

				// Duplicate reference
				if (hm.containsKey(reference)) {
					hm.put(reference, reference + 1);
					// Correct end balance
					if (endBalance == reference) {
						JSONObject jsonObject = new JSONObject();
						JSONArray array = new JSONArray();

						jsonObject.put("reference", "reference_of_error_record");
						jsonObject.put("accountNumber", "account_number_of_error_record");
						array.add(jsonObject);
						res.seterrorRecords(array);
						res.setResult("DUPLICATE_REFERENCE");

						return res;
					}
					// Incorrect end balance
					else {
						JSONObject jsonObject = new JSONObject();
						JSONObject jsonObject1 = new JSONObject();
						JSONArray array = new JSONArray();

						jsonObject.put("reference", "reference_of_duplicate_record");
						jsonObject.put("accountNumber", "account_number_of_duplicate_record");
						jsonObject1.put("reference", "reference_of_inCorrectEndBalance_record");
						jsonObject1.put("accountNumber", "account_number_of_ inCorrectEndBalance _record");
						array.add(jsonObject);
						array.add(jsonObject1);
						res.seterrorRecords(array);
						res.setResult("DUPLICATE_REFERENCE _INCORRECT_END_BALANCE");

						return res;
					}
				}
				// No duplicate
				else {
					// Correct end balance

					if (endBalance == customer.getEndBalance()) {
						JSONObject jsonObject = new JSONObject();
						JSONArray array = new JSONArray();
						res.seterrorRecords(array);
						res.setResult("SUCCESSFUL");

						return res;
					}
					// Incorrect end balance
					else {
						JSONObject jsonObject = new JSONObject();
						JSONArray array = new JSONArray();

						jsonObject.put("reference", "reference_of_error_record");
						jsonObject.put("accountNumber", "account_number_of_error_record");
						array.add(jsonObject);
						res.seterrorRecords(array);
						res.setResult("INCORRECT_END_BALANCE");

						return res;
					}
				}

			}
		} catch (JsonParseException e) {
			e.printStackTrace();

			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			res.seterrorRecords(array);
			res.setResult("BAD_REQUEST");
			status.setStatus(400);

			return res;

		} catch (Exception e) {
			e.printStackTrace();

			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			res.seterrorRecords(array);
			res.setResult("INTERNAL_SERVER_ERROR");
			status.setStatus(500);

			return res;

		}

		return res;
	}
}
