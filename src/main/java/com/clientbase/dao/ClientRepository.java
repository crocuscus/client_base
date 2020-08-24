package com.clientbase.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clientbase.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	@Query(value = "select * from client where fullname @@ :name_part", nativeQuery = true)
	public List<Client> findByFullname(String name_part);	

		
}
