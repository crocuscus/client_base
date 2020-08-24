package com.clientbase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientbase.model.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
}