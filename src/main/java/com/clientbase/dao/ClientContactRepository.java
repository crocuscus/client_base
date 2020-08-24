package com.clientbase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientbase.model.ClientContact;

public interface ClientContactRepository extends JpaRepository<ClientContact, Integer> {

}
