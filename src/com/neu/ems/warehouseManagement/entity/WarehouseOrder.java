package com.neu.ems.warehouseManagement.entity;

import java.util.Date;

public class WarehouseOrder {

	private String id;
	private String produceName;
	private String produceID;
	private int quantity;
	private Date date;
	private String remarks;
	private String warehouseID;
	private String warehouseName;
	private String operateType;// '0'������,'1'�����˻�
	private String type;// 'I'��ʾ���,'O'��ʾ����

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduceName() {
		return produceName;
	}

	public void setProduceName(String produceName) {
		this.produceName = produceName;
	}

	public String getProduceID() {
		return produceID;
	}

	public void setProduceID(String produceID) {
		this.produceID = produceID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getOperate() {
		return operateType;
	}

	public void setOperate(String operateType) {
		this.operateType = operateType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
