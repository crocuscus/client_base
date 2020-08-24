package com.clientbase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clientbase.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
	@Query(value = "select * from service where prescence_flag = true", nativeQuery = true)
	public List<Service> getAllPrescence();
}