package com.clientbase.dao;

import static org.testng.AssertJUnit.assertFalse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.clientbase.model.Client;

@SpringBootTest
public class ClientRepositoryTest extends AbstractTestNGSpringContextTests {
  @Autowired ClientRepository clientRep;
	
  @Test
  public void findByFullnameTest() {
	 List<Client> intel_search = clientRep.findByFullname("Intel");
	 assertFalse(intel_search.isEmpty());
  }
}
