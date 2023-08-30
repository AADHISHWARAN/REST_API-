package com.example.pro.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pro.Model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
		@Modifying
	    @Query("UPDATE Order o SET o.customer.id = :customerId WHERE o.id = :orderId")
	    void updateOrderCustomerId(@Param("orderId") int orderId, @Param("customerId") int customerId);
}
