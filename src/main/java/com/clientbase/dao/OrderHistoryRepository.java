package com.clientbase.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
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
}