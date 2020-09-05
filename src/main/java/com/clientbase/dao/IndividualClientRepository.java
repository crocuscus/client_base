package com.clientbase.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.clientbase.model.Client;
import com.clientbase.model.IndividualClient;

@Repository
public interface IndividualClientRepository extends JpaRepository<IndividualClient, Integer> {
	public default Pair<Boolean, String> canAddOrUpdateIndividualClient(Map<String, String> fields_dict) {
		String[] required_fields = {"first_name", "surname"};
		for (String field : required_fields) {
			String value = fields_dict.getOrDefault(field, "");
			if (value.isBlank())
				return Pair.of(false, "canAddOrUpdateIndividualClient: empty " + field);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		String passport_date = fields_dict.get("passport_date");
		if (passport_date != null) {
			try {
				formatter.parse(passport_date);
			} catch (ParseException e) {
				return Pair.of(false, "canAddOrUpdateIndividualClient: incorrect date format");
			}
		}
		return Pair.of(true, "ok");
	}	
		
	public default void addOrUpdateIndividualClient(Client id, Map<String, String> fields_dict) {
		IndividualClient client = new IndividualClient();
		client.setFirstName(fields_dict.get("first_name"));
		client.setSecondName(fields_dict.get("second_name"));
		client.setSurname(fields_dict.get("surname"));
		client.setPassport(fields_dict.get("passport"));
		client.setPassportFromWhom(fields_dict.get("passport_from_whom"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		String passport_date = fields_dict.get("passport_date");
		if (passport_date != null)
			client.setPassportDate(formatter.parse(passport_date));
		client.setClient(id);
		saveAndFlush(client);
	}

}
