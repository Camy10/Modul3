package com.application.modul3.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.customer.Customer;
import com.application.modul3.customer.CustomerRepository;
import com.application.modul3.customer.CustomerService;
import com.application.modul3.exception.ResourceNotFoundException;
import com.application.modul3.order.dto.OrderWithCustomerIdDTO;
import com.application.modul3.student.Student;
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	//private CustomerRepository customerRepository;
	private CustomerService customerService; 

	
	public Order createOrder(Order order) {		
		return orderRepository.saveAndFlush(order);
	}

	public Order createOrder(Order order, Integer customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		customer.addOrder(order);
		return orderRepository.saveAndFlush(order);
	}
	
	public List<Order> getAllOrder(){
		
		return orderRepository.findAll();
	}

	public Order updateOrder(Order order, Integer orderId) {
		Order updateOrder = getOrderById(orderId);
		updateOrder.setDate(order.getDate());
		updateOrder.setPaid(order.getPaid());
		updateOrder.setTotalPrice(order.getTotalPrice());
		orderRepository.flush();
		return updateOrder;
	}
	


	public Order getOrderById(Integer orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("order not found"));
	}

	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
		
	}

}
