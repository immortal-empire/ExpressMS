package com.neu.ems.distribute.dao;

import com.neu.ems.entity.Warehouse;

public interface WarehouseDAO {

	void addWarehouse(Warehouse warehouse);

	Warehouse validateType(String waretype);

	int queryPageCount(String warename, String manager, int pageSize);

}
