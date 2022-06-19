package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepository foodOrderRepository;
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	public List<FoodOrder> getAllOrder() {
		return foodOrderRepository.findAll();
	}
	
	public FoodOrder updateOrder(int id, FoodOrder foodOrder) {
		Optional<FoodOrder> opt = foodOrderRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return foodOrderRepository.save(foodOrder);
		}
	}

	public FoodOrder getOrderById(int id) {
		Optional<FoodOrder> opt = foodOrderRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}	
}
