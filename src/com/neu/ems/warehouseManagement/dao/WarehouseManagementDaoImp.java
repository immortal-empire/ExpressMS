package com.neu.ems.warehouseManagement.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neu.ems.utils.DButil;
import com.neu.ems.warehouseManagement.entity.WarehouseOrder;


public class WarehouseManagementDaoImp implements WarehouseManagementDao {

	Connection conn;
	
	public WarehouseManagementDaoImp(Connection conn) {
		super();
		this.conn = conn;
		// TODO Auto-generated constructor stub
	}

	public List<WarehouseOrder> selectOrder(String sql, Object object,int count) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		List<WarehouseOrder> list = new ArrayList<WarehouseOrder>();
		if(object !=null && !"".equals(object)){
			try {
				ps = conn.prepareStatement(sql);
				ps.setObject(1, object);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					WarehouseOrder worder = new WarehouseOrder();
					worder.setId(String.valueOf(count+1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int selectPageNumber(String sql, Object object) {
		int number = 0;
		PreparedStatement ps=null;
		if(object !=null && !"".equals(object)){
			try {
				ps = conn.prepareStatement(sql);
				ps.setObject(1, object);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					number=rs.getInt("cc");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DButil.closePs(ps);
		return number;
	}

}
