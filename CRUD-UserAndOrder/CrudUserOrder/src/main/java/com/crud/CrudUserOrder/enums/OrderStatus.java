package com.crud.CrudUserOrder.enums;

public enum OrderStatus {
	WAITING_PAYMENT(0),
	PAID(1),
	SHIPPED(2),
	DELIVERED(3),
	CANCELLED(4);
	
	private int num;
	
	private OrderStatus(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public static OrderStatus convertIntToStatus(int num) {
		for (OrderStatus value: OrderStatus.values()) {
			if (value.getNum() == num) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
}
