package com.clientbase.dao;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.clientbase.model.Client;
import com.clientbase.model.OrderHistory;
import com.clientbase.model.Service;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
	public default Pair<Boolean, String> registerOrder(Client client, Service service, String from, String to) {
		if (client == null)
			return Pair.of(false, "registerOrder: empty client");
		if (service == null)
			return Pair.of(false, "registerOrder: empty service");
		OrderHistory order = new OrderHistory();
		order.setClient(client);
		order.setService(service);
		if (from == null) {
			Date date = new Date();
			order.setFromDttm(new Timestamp(date.getTime()));
		} else {
			order.setFromDttm();
		}
		if (to != null)
			
		return Pair.of(true, "ok");
	}
}