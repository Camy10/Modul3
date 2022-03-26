package com.application.modul3.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.customer.dto.CustomerDTO;
import com.application.modul3.exception.ResourceNotFoundException;
import com.application.modul3.order.Order;
import com.application.modul3.order.OrderRepository;
import com.application.modul3.order.OrderService;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public Customer createCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Integer id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not found"));
	}

	public Customer updateCustomer(Customer customer, Integer id) {
		Customer updateCustomer = getCustomerById(id);
		updateCustomer.setFirstName(customer.getFirstName());
		updateCustomer.setLastName(customer.getLastName());
		customerRepository.flush();
		return updateCustomer;
	}
	
	//sterge doar acei customer care nu au orderId
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);	
	}

	public void remove(Integer customerId, Integer orderId) {
		Customer customer = getCustomerById(customerId);
		Order order = orderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order not fount"));
		
		customer.removeOrder(order);
		customerRepository.flush();
		
	}

	public List<Customer> getCustomerByName(String name) {
		return customerRepository.findByfirstName(name);
	}
	


}
