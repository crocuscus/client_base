package com.clientbase.dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.clientbase.model.Client;
import com.clientbase.model.OrderHistory;
import com.clientbase.model.Service;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
	
	
	public default Pair<Optional<OrderHistory>, String> registerOrder(Client client, Service service, String from, String to) {
		if (client == null)
			return Pair.of(Optional.empty(), "registerOrder: empty client");
		if (service == null)
			return Pair.of(Optional.empty(), "registerOrder: empty service");
		OrderHistory order = new OrderHistory();
		order.setClient(client);
		order.setService(service);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		Date parsedDate;
		if (from == null) {
			Date date = new Date();
			order.setFromDttm(new Timestamp(date.getTime()));
		} else {
			try {
				parsedDate = formatter.parse(from);
			} catch (ParseException e) {
				return Pair.of(Optional.empty(), "registerOrder: wrong format of from date");
			}
		    order.setFromDttm(new java.sql.Timestamp(parsedDate.getTime()));
		}
		if (to != null) {
			try {
				parsedDate = formatter.parse(to);
			} catch (ParseException e) {
				return Pair.of(Optional.empty(), "registerOrder: wrong format of to date");
			}
		    order.setToDttm(new java.sql.Timestamp(parsedDate.getTime()));
		}
		order = saveAndFlush(order);
		return Pair.of(Optional.of(order), "ok");
	}
	
	@Query(value = "select client.fulln	ame," + 
			"   service.service_name," + 
			"   employee.first_name," + 
			"   order_history.from_dttm," + 
			"   order_history.to_dttm "
			+ "FROM client inner join order_history USING (client_id)" + 
			"		   	   inner join workload USING (order_id)" + 
			"		       inner join employee USING (employee_id)" + 
			"		       inner join service USING (service_id)"
			+ "WHERE client_id in :clients AND"
			+ "      service_id in :services AND"
			+ "      employee_id in :employees AND"
			+ "      to_dttm <= :to AND from_dttm >= :from"
			+ "      ", nativeQuery = true)
	public List<Object[]> stupidFilterHistory(List<Integer> clients, List<Integer> employees, Timestamp from, Timestamp to, List<Short> services);
	
	public default Pair<Optional<List<Object[]>>, String> smartFilterHistory(
			List<Integer> clients,
			ClientRepository clientRep,
			List<Integer> employees, 
			EmployeeRepository empRep,
			Timestamp from, 
			Timestamp to, 
			List<Short> services,
			ServiceRepository servRep) {
		if (clients == null || clients.isEmpty())
			clients = clientRep.findAll().stream().map(x -> x.getClientId()).collect(Collectors.toList());
		if (employees == null || employees.isEmpty())
			employees = empRep.findAll().stream().map(x -> x.getEmployeeId()).collect(Collectors.toList());
		if (services == null || services.isEmpty())
			services = servRep.findAll().stream().map(x -> x.getServiceId()).collect(Collectors.toList());
		if (from == null) {
			Date d = new Date(0L);
			from = new Timestamp(d.getTime()); 
		}
		if (to == null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date d = null;
			try {
				d = dateFormat.parse("31/12/9999");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			to = new Timestamp(d.getTime());
		}
		if (from.compareTo(to) > 0)
			return Pair.of(Optional.empty(), "to < from");
		return Pair.of(Optional.of(stupidFilterHistory(clients, employees, from, to, services)), "ok");
	}
}