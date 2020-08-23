package com.clientbase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientbase.model.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {
	
}
