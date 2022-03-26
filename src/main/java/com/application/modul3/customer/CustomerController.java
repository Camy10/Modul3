package com.application.modul3.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.customer.dto.CustomerCreateDTO;
import com.application.modul3.customer.dto.CustomerDTO;
import com.application.modul3.customer.mapper.CustomerMapper;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	/*
	 * CRUD
	 */
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerMapper customerMapper;

	@PostMapping
	public CustomerDTO createCustomer(@RequestBody CustomerCreateDTO customerCreateDTO) {
		Customer customer = customerService
				.createCustomer(customerMapper.customerCreateDTO2customer(customerCreateDTO));
		return customerMapper.customer2CustomerDTO(customer);
	}

	@GetMapping("/list")
	public List<CustomerDTO> getAllCustomer() {
		return customerMapper.customerList2CustomerListDTO(customerService.getAllCustomer());
	}

	@GetMapping("/{id}")
	public CustomerDTO getCustomerById(@PathVariable Integer id) {
		return customerMapper.customer2CustomerDTO(customerService.getCustomerById(id));
	}
	
	@GetMapping("name")
	public List<CustomerDTO> getCustomerByName(@RequestParam String name) {
		return customerMapper.customerList2CustomerListDTO(customerService.getCustomerByName(name)) ;
		
	}

	@PutMapping("/customer/{id}")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Integer id) {
		Customer customer = customerService.updateCustomer(customerMapper.customerDTO2Customer(customerDTO), id);
		return customerMapper.customer2CustomerDTO(customer);
	}

	//avem relatie bidirectionala deci cand copilule orfan(true) atat copilul cant si copilul se sterg
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
	}
	
	@DeleteMapping("remove/{customerId}/{orderId}")
	public void remove(@PathVariable Integer customerId, @PathVariable Integer orderId) {
		customerService.remove(customerId, orderId);
		
	}

}
