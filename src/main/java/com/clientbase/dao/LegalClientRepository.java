package com.clientbase.dao;


import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.clientbase.model.Client;
import com.clientbase.model.LegalClient;

@Repository
public interface LegalClientRepository extends JpaRepository<LegalClient, Integer> {
	public default Pair<Boolean, String> canAddOrUpdateLegalClient(Map<String, String> fields_dict) {
		String[] required_fields = {"tin"};
		for (String field : required_fields) {
			String value = fields_dict.getOrDefault(field, "");
			if (value.isBlank())
				return Pair.of(false, "canAddOrUpdateLegalClient: empty " + field);
		}
		return Pair.of(true, "ok");
	}
	
	public default void addOrUpdateLegalClient(Integer id, Map<String, String> fields_dict) {
		LegalClient client = new LegalClient();
		client.setShortName(fields_dict.get("short_name"));
		client.setTin(fields_dict.get("tin"));
		client.setClientId(id);
		saveAndFlush(client);
	}
}
