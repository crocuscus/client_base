package com.clientbase.dao;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotSame;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.springframework.data.util.Pair;

import com.clientbase.model.Client;
import com.clientbase.model.IndividualClient;

@SpringBootTest
public class ClientRepositoryTest extends AbstractTestNGSpringContextTests {
  @Autowired ClientRepository clientRep;
  @Autowired LegalClientRepository legalRep;
  @Autowired IndividualClientRepository indiRep;
	
  @Test
  public void findByFullnameTest() {
	 List<Client> intel_search = clientRep.findByFullname("Intel");
	 assertFalse(intel_search.isEmpty());
  }
  
  
  @Test
  public void addOrUpdateTestLegal() {
	
	// test simple adding of new client
	Pair<Optional<Client>, String> testClientOne = null, testClientTwo = null;
	testClientOne = clientRep.addOrUpdateClient(
		null, false, Map.of("tin", "111111"), "Sator", List.of(), legalRep, indiRep
	);
	assertFalse("null after CREATE", testClientOne == null);
	assertFalse(testClientOne.getSecond(), testClientOne.getFirst().isEmpty());
	Client client1 = testClientOne.getFirst().get();
	
	testClientTwo = clientRep.addOrUpdateClient(
		client1.getClientId(), false, Map.of("tin", "111111"), "Sator Tenet", List.of(), legalRep, indiRep
	);
    assertFalse("null after UPDATE", testClientTwo == null);
	assertFalse(testClientTwo.getSecond(), testClientTwo.getFirst().isEmpty());  
	Client client2 = testClientTwo.getFirst().get();
	
	assertEquals("id must me equal after update", client1.getClientId(), client2.getClientId());
	assertNotSame("name must be updated", client1.getFullname(), client2.getFullname());
	
	// delete client
	legalRep.deleteById(client1.getClientId()); 
	clientRep.deleteById(client1.getClientId());
	
	testClientTwo = clientRep.addOrUpdateClient(
		null, false, Map.of("team", "111111"), "test", List.of(), legalRep, indiRep
	);
    assertTrue("no tin, shout be null object", testClientTwo.getFirst().isEmpty());
    
    testClientTwo = clientRep.addOrUpdateClient(
		null, false, Map.of("tin", "test"), "test", List.of(), null, indiRep
	);
    assertTrue("legalRep null, shout be null object", testClientTwo.getFirst().isEmpty());
    
    testClientTwo = clientRep.addOrUpdateClient(
		null, false, Map.of("team", "111111"), "test", List.of(), legalRep, null
	);
    assertTrue("indiRep null, shout be null object", testClientTwo.getFirst().isEmpty());
	
  }
  
  @Test
  public void addOrUpdateTestIndividual() {
	
	// test simple adding of new client
	Pair<Optional<Client>, String> testClientOne = null, testClientTwo = null;
	testClientOne = clientRep.addOrUpdateClient(
		null, 
		true, 
		Map.of("first_name", "TestIND", "surname", "TestSurname"), 
		"Sator", 
		List.of(), 
		legalRep, 
		indiRep
	);
	assertFalse("null after CREATE", testClientOne == null);
	assertFalse(testClientOne.getSecond(), testClientOne.getFirst().isEmpty());
	IndividualClient client1 = indiRep.findById(testClientOne.getFirst().get().getClientId()).get();
	
	testClientTwo = clientRep.addOrUpdateClient(
		client1.getClientId(), 
		true, 
		Map.of("first_name", "TestIND-Updated", "surname", "TestSurname-Updated"), 
		"Sator Tenet", 
		List.of(), 
		legalRep,
		indiRep
	);
    assertFalse("null after UPDATE", testClientTwo == null);
	assertFalse(testClientTwo.getSecond(), testClientTwo.getFirst().isEmpty());  
	IndividualClient client2 = indiRep.findById(testClientTwo.getFirst().get().getClientId()).get();
	
	assertEquals("id must me equal after update", client1.getClientId(), client2.getClientId());
	assertNotSame("first_name must be updated", client1.getFirstName(), client2.getFirstName());
	assertNotSame("surname must be updated", client1.getSurname(), client2.getSurname());
	// delete client
	indiRep.deleteById(client1.getClientId()); 
	clientRep.deleteById(client1.getClientId());
	
	testClientTwo = clientRep.addOrUpdateClient(
		null, true, Map.of("team", "111111"), "test", List.of(), legalRep, indiRep
	);
    assertTrue("no tin, shout be null object", testClientTwo.getFirst().isEmpty());
    
    testClientTwo = clientRep.addOrUpdateClient(
		null, true, Map.of("tin", "test"), "test", List.of(), null, indiRep
	);
    assertTrue("legalRep null, shoud be null object", testClientTwo.getFirst().isEmpty());
    
    testClientTwo = clientRep.addOrUpdateClient(
		null, true, Map.of("team", "1111111"), "test", List.of(), legalRep, null
	);
    assertTrue("indiRep null, shoud be null object", testClientTwo.getFirst().isEmpty());
  }
  
  @Test
  public void removePersonalClientDataTest() {
	  var client = clientRep.addOrUpdateClient(
				null, 
				true, 
				Map.of("first_name", "TestIND", "surname", "TestSurname", "passport", "1"), 
				"Sator", 
				List.of(), 
				legalRep, 
				indiRep
			);
	  var id = client.getFirst().get().getClientId();
	  assertTrue("return true", clientRep.removePersonalData(id, legalRep, indiRep));
//	  var name = clientRep.findById(id).get().getFullname();
//	  assertTrue("fullname not deleted", name.equals("deleted client"));
	  clientRep.deleteById(id);
   }
}
