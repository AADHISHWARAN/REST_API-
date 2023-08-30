package com.example.pro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pro.Model.Order;
import com.example.pro.Repo.OrderRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(long id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCustomer(updatedOrder.getCustomer());
            // Set other attributes here
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> sortOrdersByAsc(String orderDate) {
        return orderRepository.findAll(Sort.by(orderDate).ascending());
    }   
        public void updateOrderCustomerId(int orderId, int customerId) {
            orderRepository.updateOrderCustomerId(orderId, customerId);
        }
    }


   


