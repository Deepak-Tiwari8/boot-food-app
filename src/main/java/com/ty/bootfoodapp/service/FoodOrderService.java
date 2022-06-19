package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.FoodOrderDao;
import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.dto.Item;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		List<Item> items = foodOrder.getItems();
		double cost = 0;
		for (Item item : items) {
			item.setFoodOrder(foodOrder);
			cost += (item.getQuantity() * item.getCost());
		}
		foodOrder.setCost(cost);
		return foodOrderDao.saveOrder(foodOrder);
	}

	public List<FoodOrder> getAllOrder() {
		return foodOrderDao.getAllOrder();
	}

	public FoodOrder updateOrder(int id, FoodOrder foodOrder) {
		return foodOrderDao.updateOrder(id, foodOrder);
	}

	public FoodOrder getOrderById(int id) {
		return foodOrderDao.getOrderById(id);
	}
}
