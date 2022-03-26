package com.application.modul3.order;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.application.modul3.order.dto.OrderCreateDTO;
import com.application.modul3.order.dto.OrderDTO;
import com.application.modul3.order.dto.OrderWithCustomerIdDTO;
import com.application.modul3.order.mapper.OrderMapper;
import com.application.modul3.student.Student;
import com.application.modul3.student.dto.StudentDTO;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderMapper orderMapper;
	
	//creare unui order simplu, care nu are un client
	@PostMapping()
	public OrderDTO createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
		Order order =orderService.createOrder(orderMapper.orderCreateDTO2Order(orderCreateDTO));
		return orderMapper.order2OrderDTO(order);		
	}
	
	//crearea unui order, acest endpoint va adauga  un order la customer (in path)
	@PostMapping("/{customerId}")
	public OrderDTO createOrder(@RequestBody OrderCreateDTO orderCreateDTO, @PathVariable Integer customerId) {
		Order order = orderService.createOrder(orderMapper.orderCreateDTO2Order(orderCreateDTO), customerId);
		return orderMapper.order2OrderDTO(order);
	}
	
	//acest endpoint  va add order la customer (in body)
	@PostMapping("/add-customer")
	public OrderDTO createOrderADD(@RequestBody OrderCreateDTO orderCreateDTO) {
		Order order = orderService.createOrder(orderMapper.orderCreateDTO2Order(orderCreateDTO), orderCreateDTO.getCustomerId());
		return orderMapper.order2OrderDTO(order);
	}
	
	@GetMapping("/list")
	public List<OrderDTO> getAllOrder(){
		return orderMapper.listOrder2ListOrderDTO(orderService.getAllOrder()); 
	}
	
	@GetMapping("/{orderId}")
	public OrderDTO getorderById(@PathVariable Integer orderId) {
		return orderMapper.order2OrderDTO(orderService.getOrderById(orderId));
		
	}
	
	@PutMapping("/{orderId}")
	public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable Integer orderId) {
		Order order = orderService.updateOrder(orderMapper.orderDTO2Order(orderDTO), orderId);
		return orderMapper.order2OrderDTO(order);
	}
	
	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable Integer orderId) {
		orderService.deleteOrder(orderId);
		
	}
}
