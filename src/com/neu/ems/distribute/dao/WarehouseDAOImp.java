package com.neu.ems.distribute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			ps = conn.prepareStatement("select * from warehouse where type = ?");
			ps.setString(1, waretype);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				w.setName(rs.getString("name"));
				w.setType(rs.getString("type"));
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
		
		sbf.append(" select count(*) cc from warehouse where 1=1");
		if(warename != null && !"".equals(warename)) {
			sbf.append(" and name like ? ");
			
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

	@Override
	public List<Warehouse> queryWarehouse(String warename, String manager, int pageSize, int pageIndex) {
		// TODO Auto-generated method stub
		List<Warehouse> warelist = new ArrayList<Warehouse>();
		StringBuffer sbf = new StringBuffer("");
		
		sbf.append(" select * from warehouse where 1=1");
		if(warename != null && !"".equals(warename)) {
			sbf.append(" and name like ? ");
			
		}
		if(manager != null && !"".equals(manager)) {
			sbf.append(" and manager=? ");
		}
		try {
			PreparedStatement ps = conn.prepareStatement("select b.* from ("
					+" select a.*,rownum rw from (" +
					sbf.toString() +
					")a where rownum<=" +pageSize*pageIndex + ")b where rw>" +pageSize*(pageIndex-1) );
			int index = 1;
			if(warename != null && !"".equals(warename)) {
				ps.setString(index, "%"+warename+"%");
				index++;
				
			}
			if(manager != null && !"".equals(manager)) {
				ps.setString(index, manager);;
			}
			
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				Warehouse w = new Warehouse();
				w.setId(rs.getString("id"));
				w.setName(rs.getString("name"));
				w.setAddress(rs.getString("address"));
				
				w.setManager(rs.getString("manager"));
				w.setType(rs.getString("type"));
				warelist.add(w);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return warelist;
	}

	@Override
	public void editWarehouse(Warehouse w) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update warehouse set name=?,address=?,manager=? where id=?");
			
			ps.setString(1, w.getName());
			ps.setString(2, w.getAddress());
			ps.setString(3, w.getManager());
			ps.setString(4, w.getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closePs(ps);
		}
	}

}
