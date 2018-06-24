package com.neu.ems.warehouseManagement.dao;

import java.util.List;

import com.neu.ems.warehouseManagement.entity.WarehouseOrder;


public interface WarehouseManagementDao {

	public int getId(String sql);
	public List<WarehouseOrder> selectPGOrder(Object object,int count,int strat,int end);
	public List<WarehouseOrder> SetPGWarehouse(List<WarehouseOrder> list);
	public int selectPageNumber(String sql,Object object);
	public void storePGOrder(List<WarehouseOrder> list);

}
