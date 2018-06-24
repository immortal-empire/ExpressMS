package com.neu.ems.warehouseManagement.service;

import java.sql.Connection;
import java.util.List;

import com.neu.ems.utils.DButil;
import com.neu.ems.warehouseManagement.dao.WarehouseManagementDaoImp;
import com.neu.ems.warehouseManagement.entity.WarehouseOrder;

public class WarehouseManagementService {
	
	//����ģʽ
	private static WarehouseManagementService service = new WarehouseManagementService();
	public WarehouseManagementService() {
		
	}
	public static WarehouseManagementService getInstance() {
		return service;
	}

	/*
	 * ������鵥�ݵ�����������������
	 */
	public int selectPageNumber(String sql,Object object) {
		Connection conn = DButil.getConn();
		WarehouseManagementDaoImp dao = new WarehouseManagementDaoImp(conn);
		int pagenum = dao.selectPageNumber(sql, object);
		DButil.closeConn(conn);
		return pagenum;	
	}
	
	/*
	 * ��ȡ����id(��������)
	 */
	public int getId(String sql) {
		Connection conn = DButil.getConn();
		WarehouseManagementDaoImp dao = new WarehouseManagementDaoImp(conn);
		int id=dao.getId(sql);
		DButil.closeConn(conn);
		return id;
	}
	/*
	 * ��ѯ������
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
	 * �޸�ʵ�ʵ�����������ע
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
