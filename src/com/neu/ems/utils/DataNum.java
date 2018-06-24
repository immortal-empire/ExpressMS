package com.neu.ems.utils;

public class DataNum {

	private static int newOrder;// 新订订单数
	private static int quitOrder;// 退订订单数
	private static int taskOrder;// 任务单数
	private static int Product;// 商品数量
	private static int PROrder;// 配送中心购货退货单
	private static int WarehouseNum;

	public int getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(int newOrder) {
		DataNum.newOrder = newOrder;
	}

	public int getQuitOrder() {
		return quitOrder;
	}

	public void setQuitOrder(int quitOrder) {
		DataNum.quitOrder = quitOrder;
	}

	public int getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(int taskOrder) {
		DataNum.taskOrder = taskOrder;
	}

	public int getProduct() {
		return Product;
	}

	public void setProduct(int product) {
		Product = product;
	}

	public int getPROrder() {
		return PROrder;
	}

	public void setPROrder(int pROrder) {
		PROrder = pROrder;
	}

	public int getWarehouseNum() {
		return WarehouseNum;
	}

	public void setWarehouseNum(int warehouseNum) {
		WarehouseNum = warehouseNum;
	}

}
