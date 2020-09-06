package com.clientbase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientbase.model.Client;
import com.clientbase.model.ClientContact;

public interface ClientContactRepository extends JpaRepository<ClientContact, Integer> {
	public List<ClientContact> findByClient(Client client);
}
