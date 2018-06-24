package com.neu.ems.warehouseManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.neu.ems.warehouseManagement.entity.WarehouseOrder;
import com.neu.ems.warehouseManagement.service.WarehouseManagementService;

/**
 * Servlet implementation class PGInboundServlet
 */
public class PGInboundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PGInboundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String PGOrderId = request.getParameter("pgorder");
		
		if("count".equals(action)) {
			getCount(request,response,PGOrderId);
		} else if("record".equals(action)) {
			getRecord(request,response,PGOrderId);
		} else if("inbound".equals(action)) {
			
		} 
	}
	/*
	 * 获得数据总条数
	 */
	private void getCount(HttpServletRequest request, HttpServletResponse response,String PGOrderId) throws IOException{
		//获取分页的总条数的sql语句
		String sqlCount = "select count(*) cc from PROrderItem where PR_ID = ?";
		int pagenum = WarehouseManagementService.getInstance().selectPageNumber(sqlCount, PGOrderId);
        response.setCharacterEncoding("UTF-8");   
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(pagenum);
		writer.close();
	}
	/*
	 * 获得购货单的商品数据
	 */
	private void getRecord(HttpServletRequest request, HttpServletResponse response,String PGOrderId) throws IOException{
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		int currentPageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		//获取数据表id的sql语句
		String sqlId = "select count(*) cc from Warehouse_order";
		int id = WarehouseManagementService.getInstance().getId(sqlId);
		//查询所需数据
		List<WarehouseOrder> list = WarehouseManagementService.getInstance().selectPGOrder(PGOrderId, id, currentPage, currentPageSize);
        //将数据处理为JSON格式
		JSONArray json = new JSONArray();
        for(WarehouseOrder wo: list){
            JSONObject jo = new JSONObject();
            jo.put("productid", wo.getProduceID());
            jo.put("productname", wo.getProduceName());
            jo.put("quantityordered", wo.getQuantity());
            jo.put("realquantity", wo.getQuantity());
            jo.put("remarks", wo.getRemarks());
            json.put(jo);
        }
        response.setCharacterEncoding("UTF-8");    
        response.setContentType("application/json; charset=utf-8");    
        PrintWriter writer = response.getWriter();  
        writer.append(json.toString());       
	}
	/*
	 * 修改实际到货数量和备注
	private void modifyQuantity(HttpServletRequest request, HttpServletResponse response, List<WarehouseOrder> list) {
		int quantity = Integer.parseInt(request.getParameter("modifyquantity"));
		String productname = request.getParameter("productname");
		String remarks = request.getParameter("remarks");
		//修改实际到货数量和备注
		WarehouseManagementService.getInstance().modifyQuantity(list, quantity, productname, remarks);	
	}
	*/
	
	/*
	 * 数据库存储数据
	 */
	private void storeInboundData(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
