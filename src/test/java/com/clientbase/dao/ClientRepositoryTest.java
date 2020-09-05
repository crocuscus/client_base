package com.clientbase.dao;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotSame;

import java.text.ParseException;
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
  @Autowired LegalClientRepository legClRep;
  @Autowired IndividualClientRepository indClRep;
	
  @Test
  public void findByFullnameTest() {
	 List<Client> intel_search = clientRep.findByFullname("Intel");
	 assertFalse(intel_search.isEmpty());
  }
  
  
  @Test
  public void addOrUpdateTest_Legal() {
	
	// test simple adding of new client
	Pair<Optional<Client>, String> testClientOne = null, testClientTwo = null;
	try {
		testClientOne = clientRep.addOrUpdateClient(
			null, false, Map.of("tin", "pidorы"), "Sator", List.of(), legClRep, indClRep
		);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	assertFalse("null after CREATE, it's fail иди дебагай", testClientOne == null);
	assertFalse(testClientOne.getSecond(), testClientOne.getFirst().isEmpty());
	Client client1 = testClientOne.getFirst().get();
	
	// test updating of existing client
	try {
		testClientTwo = clientRep.addOrUpdateClient(
			client1.getClientId(), false, Map.of("tin", "pidorы"), "Sator Tenet", List.of(), legClRep, indClRep
		);
	} catch (ParseException e) {
		e.printStackTrace();
	}
    assertFalse("null after UPDATE, it's fail иди дебагай", testClientTwo == null);
	assertFalse(testClientTwo.getSecond(), testClientTwo.getFirst().isEmpty());  
	Client client2 = testClientTwo.getFirst().get();
	
	assertEquals("id must me equal after update", client1.getClientId(), client2.getClientId());
	assertNotSame("name must be updated", client1.getFullname(), client2.getFullname());
	
	// delete client
	legClRep.deleteById(client1.getClientId()); 
	clientRep.deleteById(client1.getClientId());
	
	// test incorrect creating
	try {
		testClientTwo = clientRep.addOrUpdateClient(
			null, false, Map.of("team", "pidorы"), "test", List.of(), legClRep, indClRep
		);
	} catch (ParseException e) {}
    assertTrue("no tin, shout be null object", testClientTwo.getFirst().isEmpty());
    
    try {
		testClientTwo = clientRep.addOrUpdateClient(
			null, false, Map.of("tin", "test"), "test", List.of(), null, indClRep
		);
	} catch (ParseException e) {}
    assertTrue("legClRep null, shout be null object", testClientTwo.getFirst().isEmpty());
    
    try {
		testClientTwo = clientRep.addOrUpdateClient(
			null, false, Map.of("team", "pidorы"), "test", List.of(), legClRep, null
		);
	} catch (ParseException e) {}
    assertTrue("indClRep null, shout be null object", testClientTwo.getFirst().isEmpty());
	
  }
  
  @Test
  public void addOrUpdateTest_Individual() {
	
	// test simple adding of new client
	Pair<Optional<Client>, String> testClientOne = null, testClientTwo = null;
	try {
		testClientOne = clientRep.addOrUpdateClient(
			null, 
			true, 
			Map.of("first_name", "TestIND", "surname", "TestSurname"), 
			"Sator", 
			List.of(), 
			legClRep, 
			indClRep
		);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	assertFalse("null after CREATE, it's fail иди дебагай", testClientOne == null);
	assertFalse(testClientOne.getSecond(), testClientOne.getFirst().isEmpty());
	IndividualClient client1 = indClRep.findById(testClientOne.getFirst().get().getClientId()).get();
	
	// test updating of existing client
	try {
		testClientTwo = clientRep.addOrUpdateClient(
			client1.getClientId(), 
			true, 
			Map.of("first_name", "TestIND-Updated", "surname", "TestSurname-Updated"), 
			"Sator Tenet", 
			List.of(), 
			legClRep,
			indClRep
		);
	} catch (ParseException e) {
		e.printStackTrace();
	}
    assertFalse("null after UPDATE, it's fail иди дебагай", testClientTwo == null);
	assertFalse(testClientTwo.getSecond(), testClientTwo.getFirst().isEmpty());  
	IndividualClient client2 = indClRep.findById(testClientTwo.getFirst().get().getClientId()).get();
	
	assertEquals("id must me equal after update", client1.getClientId(), client2.getClientId());
	assertNotSame("first_name must be updated", client1.getFirstName(), client2.getFirstName());
	assertNotSame("surname must be updated", client1.getSurname(), client2.getSurname());
	
	// delete client
	indClRep.deleteById(client1.getClientId()); 
	clientRep.deleteById(client1.getClientId());
	
	// test incorrect creating
	try {
		testClientTwo = clientRep.addOrUpdateClient(
			null, true, Map.of("team", "pidorы"), "test", List.of(), legClRep, indClRep
		);
	} catch (ParseException e) {}
    assertTrue("no tin, shout be null object", testClientTwo.getFirst().isEmpty());
    
    try {
		testClientTwo = clientRep.addOrUpdateClient(
			null, true, Map.of("tin", "test"), "test", List.of(), null, indClRep
		);
	} catch (ParseException e) {}
    assertTrue("legClRep null, shout be null object", testClientTwo.getFirst().isEmpty());
    
    try {
		testClientTwo = clientRep.addOrUpdateClient(
			null, true, Map.of("team", "pidorы"), "test", List.of(), legClRep, null
		);
	} catch (ParseException e) {}
    assertTrue("indClRep null, shout be null object", testClientTwo.getFirst().isEmpty());
	
  }
}
