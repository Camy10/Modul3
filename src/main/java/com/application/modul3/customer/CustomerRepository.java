package com.application.modul3.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public List<Customer> findByfirstName(String firstName);
}
