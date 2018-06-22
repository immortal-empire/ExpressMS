package com.neu.ems.distribute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neu.ems.entity.Warehouse;
import com.neu.ems.utils.DButil;

public class WarehouseDAOImp implements WarehouseDAO {

	Connection conn;

	public WarehouseDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into Warehouse values (?,?,?,?,?)");
			ps.setString(1, warehouse.getId());
			ps.setString(2, warehouse.getName());
			ps.setString(3, warehouse.getAddress());
			ps.setString(4, warehouse.getManager());
			ps.setString(5, warehouse.getType());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closePs(ps);
		}

	}

	@Override
	public Warehouse validateType(String waretype) {
		// TODO Auto-generated method stub
		Warehouse w = new Warehouse();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from warehouse where waretype = ?");
			ps.setString(1, waretype);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				w.setName(rs.getString("name"));
				w.setType(rs.getString("waretype"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closePs(ps);
		}
		return w;
	}

	@Override
	public int queryPageCount(String warename, String manager, int pageSize) {
		// TODO Auto-generated method stub
		int count=0;
		StringBuffer sbf = new StringBuffer("");
		
		sbf.append(" select count(*) cc from warehoue where 1=1");
		if(warename != null && !"".equals(warename)) {
			sbf.append(" and warename like ? ");
			
		}
		if(manager != null && !"".equals(manager)) {
			sbf.append(" and manager=? ");
		}
		
		try {
			PreparedStatement ps = conn.prepareStatement(sbf.toString());
			int index = 1;
			if(warename != null && !"".equals(warename)) {
				ps.setString(index, "%"+warename+"%");
				index++;
				
			}
			if(manager != null && !"".equals(manager)) {
				ps.setString(index, manager);
			}
			
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				count = rs.getInt("cc");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(0 == count%pageSize) {
			count = count/pageSize; 
		}else {
			count = count/pageSize + 1;
		}
		return count;
		
	}

}
