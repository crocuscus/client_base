package com.clientbase.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clientbase.model.Client;
import com.clientbase.model.ClientContact;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query(value = "select * from client where fullname @@ :name_part", nativeQuery = true)
	public List<Client> findByFullname(String name_part);	

	
	@Transactional
	public default Pair<Optional<Client>, String> addOrUpdateClient(Integer id,	Boolean clientType, Map<String, String> fields_dict, String fullname, List<ClientContact> contacts, LegalClientRepository legalRep, IndividualClientRepository indiRep) throws ParseException {
		if (clientType == null)
			return Pair.of(Optional.empty(), "addOrUpdateClient: empty client type");
		if (id != null && this.findById(id).get().getClientType() != clientType)
			return Pair.of(Optional.empty(), "addOrUpdateClient: can't change client type");
		if (fullname == null)
			return Pair.of(Optional.empty(), "addOrUpdateClient: empty fullname");

		Client client = new Client();
		client.setClientType(clientType);
		client.setFullname(fullname);
		client.setClientContacts(contacts);
		if (id != null)
			client.setClientId(id);

		if (clientType) {
			var can = legalRep.canAddOrUpdateLegalClient(fields_dict);
			if (!can.getFirst()) {
				return Pair.of(Optional.empty(), "addOrUpdateClient: " + can.getSecond());
		    } else {
				client = saveAndFlush(client);
				legalRep.addOrUpdateLegalClient(client.getClientId(), fields_dict);
			}
		} else {
			var can = indiRep.canAddOrUpdateIndividualClient(fields_dict);
			if (!can.getFirst()) {
				return Pair.of(Optional.empty(), "addOrUpdateClient: " + can.getSecond());
		    } else {
				client = saveAndFlush(client);
				indiRep.addOrUpdateIndividualClient(client.getClientId(), fields_dict);
			}
		}
		
		return Pair.of(Optional.of(client), "ok");
	}

		
}
