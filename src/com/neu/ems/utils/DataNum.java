package com.neu.ems.utils;

public class DataNum {

	private static int newOrder;// �¶�������
	private static int quitOrder;// �˶�������
	private static int taskOrder;// ������
	private static int Product;// ��Ʒ����
	private static int PROrder;// �������Ĺ����˻���
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
