package com.clientbase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientbase.model.Client;
import com.clientbase.model.ClientContact;

@Repository
public interface ClientContactRepository extends JpaRepository<ClientContact, Integer> {
	public List<ClientContact> findByClient(Client client);
}
