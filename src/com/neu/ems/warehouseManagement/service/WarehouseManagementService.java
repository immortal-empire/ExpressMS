package com.neu.ems.warehouseManagement.service;

import java.sql.Connection;
import java.util.List;

import com.neu.ems.utils.DButil;
import com.neu.ems.warehouseManagement.dao.WarehouseManagementDaoImp;
import com.neu.ems.warehouseManagement.entity.WarehouseOrder;

public class WarehouseManagementService {
	
	//单例模式
	private static WarehouseManagementService service = new WarehouseManagementService();
	public WarehouseManagementService() {
		
	}
	public static WarehouseManagementService getInstance() {
		return service;
	}

	/*
	 * 获得所查单据的总数（公共方法）
	 */
	public int selectPageNumber(String sql,Object object) {
		Connection conn = DButil.getConn();
		WarehouseManagementDaoImp dao = new WarehouseManagementDaoImp(conn);
		int pagenum = dao.selectPageNumber(sql, object);
		DButil.closeConn(conn);
		return pagenum;	
	}
	
	/*
	 * 获取表单的id(公共方法)
	 */
	public int getId(String sql) {
		Connection conn = DButil.getConn();
		WarehouseManagementDaoImp dao = new WarehouseManagementDaoImp(conn);
		int id=dao.getId(sql);
		DButil.closeConn(conn);
		return id;
	}
	/*
	 * 查询购货单
	 */
	public List<WarehouseOrder> selectPGOrder(Object object,int count,int currentPage,int currentPageSize){
		int start = currentPageSize*(currentPage-1);
		int end = currentPageSize*currentPage;
		Connection conn = DButil.getConn();
		WarehouseManagementDaoImp dao = new WarehouseManagementDaoImp(conn);
		List<WarehouseOrder> templist = dao.selectPGOrder(object, count,start,end);
		List<WarehouseOrder> list = dao.SetPGWarehouse(templist);
		DButil.closeConn(conn);
		return list;
	}
	
	/*
	 * 修改实际到货数量及备注
	 */
	/*public void modifyQuantity(List<WarehouseOrder> list, int quantity,String productname,String remarks) {
		for(WarehouseOrder wo : list) {
			if(wo.getProduceName().equals(productname)) {
				wo.setQuantity(quantity);
				wo.setRemarks(remarks);
			}
		}
	}*/
	
	public void storePGOrder(List<WarehouseOrder> list) {
		
	}
}
