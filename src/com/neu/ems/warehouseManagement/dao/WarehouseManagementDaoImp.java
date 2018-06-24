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
	}
	
	/*
	 * 用于获取插入表单的单号
	 */
	public int getId(String sql) {
		int count=0;
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cc");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}

	/*
	 * 查询购货单(non-Javadoc)
	 * @see com.neu.ems.warehouseManagement.dao.WarehouseManagementDao#selectPGOrder(java.lang.Object, int, int, int)
	 */
	public List<WarehouseOrder> selectPGOrder(Object object,int id,int start,int end) {
		PreparedStatement ps=null;
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" select a.number,p.name,p.id from "+
				" (select * from PROrderItem "
				+ " where PR_ID = ?) a "
				+ " inner join products p where p.id=a.Commodity_id ");
		List<WarehouseOrder> list = new ArrayList<WarehouseOrder>();
		if(object !=null && !"".equals(object)){
			try {
				ps = conn.prepareStatement(" select b.* from "
						+ " ( select a.*,rownum rw from ( "
						+sbf.toString()+") a "
						+ " where rownum<= "+end +")b"
						+ " where rw> "+start);
				ps.setObject(1, object);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					WarehouseOrder worder = new WarehouseOrder();
					worder.setId(String.valueOf(id+1));
					worder.setProduceName(rs.getString("name"));
					worder.setProduceID(rs.getString("id"));
					worder.setQuantity(rs.getInt("number"));
					worder.setOperate("0");
					worder.setType("I");
					worder.setRemarks(null);
					worder.setDate(null);
					worder.setWarehouseID(null);
					worder.setWarehouseName(null);
					list.add(worder);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DButil.closePs(ps);
		return list;
	}

	/*
	 * 查询记录的总条数(non-Javadoc)
	 * @see com.neu.ems.warehouseManagement.dao.WarehouseManagementDao#selectPageNumber(java.lang.String, java.lang.Object)
	 */
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

	/*
	 * 设置购货入库的库房id和name
	 * @see com.neu.ems.warehouseManagement.dao.WarehouseManagementDao#SetPGWarehouse(java.util.List)
	 */
	public List<WarehouseOrder> SetPGWarehouse(List<WarehouseOrder> list) {
		PreparedStatement ps=null;
		//将库房ID和name存入list里
		String sql = "select * from warehouse w where w.type=C";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			for(WarehouseOrder l : list) {
				l.setWarehouseID(rs.getString("id"));
				l.setWarehouseName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closePs(ps);
		return list;
	}

	/*
	 * 储存购货单(non-Javadoc)
	 * @see com.neu.ems.warehouseManagement.dao.WarehouseManagementDao#storePGOrder(java.util.List)
	 */
	public void storePGOrder(List<WarehouseOrder> list) {
		//获取sql.date类型数据的方法
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		PreparedStatement ps = null;
		for(WarehouseOrder wo : list) {
			try {
				ps = conn.prepareStatement("insert into warehouseorder values(?,?,?,?,?,?,?,?)");
				ps.setString(1, wo.getId());
				ps.setString(2, wo.getProduceID());
				ps.setInt(3, wo.getQuantity());
				ps.setDate(4, currentDate);
				ps.setString(5, wo.getRemarks());
				ps.setString(6, wo.getWarehouseID());
				ps.setString(7, "0");
				ps.setString(8, "I");
				ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
