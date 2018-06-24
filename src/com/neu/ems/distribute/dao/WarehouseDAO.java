package com.neu.ems.distribute.dao;

import java.util.List;

import com.neu.ems.entity.Warehouse;

public interface WarehouseDAO {

	void addWarehouse(Warehouse warehouse);

	Warehouse validateType(String waretype);

	int queryPageCount(String warename, String manager, int pageSize);

	List<Warehouse> queryWarehouse(String warename, String manager, int pageSize, int pageIndex);

	void editWarehouse(Warehouse w);

}
