package com.neu.ems.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.neu.ems.entity.Administrator;
import com.neu.ems.utils.DButil;

public class LoginManageDAOImp implements LoginManageDAO {

	Connection conn;
	public LoginManageDAOImp(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	@Override
	public String getUserType(Administrator administrator) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String usertype = null;
		try {
			ps = conn.prepareStatement("select type from administrator where username=? and password=?");
			ps.setString(1, administrator.getUsername());
			ps.setString(2, administrator.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usertype = rs.getString("type");
			}else {
				usertype = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		return usertype;
	}
	@Override
	public Map<String, Integer> getdataNum() {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		ResultSet rs = null;
				
		//新订订单的查询
		try {
			ps = conn.prepareStatement("select count(*) from newOrder");
			rs = ps.executeQuery();
			if(rs.next()) {
				map.put("XD", rs.getInt(1));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		//退订订单的查询
		try {
			ps = conn.prepareStatement("select count(*) from quitOrder");
			rs = ps.executeQuery();
			if(rs.next()) {
				map.put("TD", rs.getInt(1));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		//任务单的查询
		try {
			ps = conn.prepareStatement("select count(*) from taskOrder");
			rs = ps.executeQuery();
			if(rs.next()) {
				map.put("TK", rs.getInt(1));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		//商品表的查询
		try {
			ps = conn.prepareStatement("select count(*) from product");
			rs = ps.executeQuery();
			if(rs.next()) {
				map.put("PD", rs.getInt(1));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		//购货退货单的查询
		try {
			ps = conn.prepareStatement("select count(*) from PROrder");
			rs = ps.executeQuery();
			if(rs.next()) {
				map.put("PR", rs.getInt(1));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		
		return map;
	}

}
