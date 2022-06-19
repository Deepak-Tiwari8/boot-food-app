package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.service.FoodOrderService;

@RestController
public class FoodOrderController {

	@Autowired
	FoodOrderService foodOrderService;

	@PostMapping("/foodOrders")
	public String saveOrder(@RequestBody FoodOrder foodOrder) {
		foodOrderService.saveOrder(foodOrder);
		return "Order saved";
	}

	@GetMapping("/foodOrders")
	public List<FoodOrder> getAllOrder() {
		return foodOrderService.getAllOrder();
	}

	@GetMapping("foodOrders{id}")
	public FoodOrder getOrderById(@PathVariable int id) {
		return foodOrderService.getOrderById(id);
	}

	@PutMapping("/foodOrders/{id}")
	public FoodOrder updateOrder(@PathVariable int id, @RequestBody FoodOrder foodOrder) {
		return foodOrderService.updateOrder(id, foodOrder);
	}
}
