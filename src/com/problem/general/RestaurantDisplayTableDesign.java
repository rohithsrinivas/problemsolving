package com.problem.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDisplayTableDesign {

	class Order {
		private String customerName;
		private Integer tableNumber;
		private List<FoodItem> foodItems;

		public Order(String customerName, Integer tableNumber, List<FoodItem> foodItems) {
			super();
			this.customerName = customerName;
			this.tableNumber = tableNumber;
			this.foodItems = foodItems;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public Integer getTableNumber() {
			return tableNumber;
		}

		public void setTableNumber(Integer tableNumber) {
			this.tableNumber = tableNumber;
		}

		public List<FoodItem> getFoodItems() {
			return foodItems;
		}

		public void setFoodItems(List<FoodItem> foodItems) {
			this.foodItems = foodItems;
		}

	}
	
	class TableDetails{
		
		private Integer tableNumber;
		private List<FoodItem> foodItems;
		public Integer getTableNumber() {
			return tableNumber;
		}
		public void setTableNumber(Integer tableNumber) {
			this.tableNumber = tableNumber;
		}
		public List<FoodItem> getFoodItems() {
			return foodItems;
		}
		public void setFoodItems(List<FoodItem> foodItems) {
			this.foodItems = foodItems;
		}
		
		
		
		
	}

	class FoodItem {

		private String itemName;
		private Integer quantity;

		public FoodItem(String itemName, Integer quantity) {
			super();
			this.itemName = itemName;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "FoodItem [itemName=" + itemName + ", quantity=" + quantity + "]";
		}
		

	}
	
	public Map<Integer, List<FoodItem>> getDisplayTable(List<Order> orders){
		Map<Integer, List<FoodItem>> tableDetails = new HashMap<>();
		orders.stream().forEach(order -> {
			tableDetails.put(order.getTableNumber(), order.getFoodItems());
		});
		return tableDetails;
		
	}

	public static void main(String[] args) {
		RestaurantDisplayTableDesign table = new RestaurantDisplayTableDesign();
		List<FoodItem> foodItems = new ArrayList<>();
		foodItems.add(table.new FoodItem("Butter naan", 2));
		foodItems.add(table.new FoodItem("Paneer Butter masala", 1));
		List<FoodItem> foodItems2 = new ArrayList<>();
		foodItems2.add(table.new FoodItem("Pizza", 1));
		foodItems2.add(table.new FoodItem("Burger", 3));
		Order order1 = table.new Order("Rohith", 1, foodItems);
		Order order2 = table.new Order("Paddu", 2, foodItems2);
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		Map<Integer, List<FoodItem>> displayTable = table.getDisplayTable(orders);
		displayTable.entrySet().stream().forEach(tableData -> {
			System.out.println("Table number: " + tableData.getKey() + " has ordered ");
			tableData.getValue().stream().forEach(item -> System.out.println(item));
		});

	}

}
