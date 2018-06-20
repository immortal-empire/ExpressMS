package com.neu.ems.warehouseManagement.dao;

import java.util.List;

import com.neu.ems.warehouseManagement.entity.WarehouseOrder;


public interface WarehouseManagementDao {

	public List<WarehouseOrder> selectOrder(String sql,Object object);
	
}
