package com.application.modul3.customer.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.customer.Customer;
import com.application.modul3.customer.dto.CustomerCreateDTO;
import com.application.modul3.customer.dto.CustomerDTO;
import com.application.modul3.person.Person;
import com.application.modul3.person.dto.PersonDTO;

@Component
public class CustomerMapper {

	public Customer customerCreateDTO2customer(CustomerCreateDTO customerCreateDTO) {
		Customer customer = new Customer();
		customer.setFirstName(customerCreateDTO.getFirstName());
		customer.setLastName(customerCreateDTO.getLastName());
		return customer;
	}

	public CustomerDTO customer2CustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		return customerDTO;
	}

	public List<CustomerDTO> customerList2CustomerListDTO(List<Customer> customers){
		return customers.stream()
				.map(customer -> customer2CustomerDTO(customer))
				.collect(Collectors.toList());		
	}

	public Customer customerDTO2Customer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		return customer;
	}

}
