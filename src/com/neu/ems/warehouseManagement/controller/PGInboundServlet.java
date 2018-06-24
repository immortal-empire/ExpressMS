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
	 * �������������
	 */
	private void getCount(HttpServletRequest request, HttpServletResponse response,String PGOrderId) throws IOException{
		//��ȡ��ҳ����������sql���
		String sqlCount = "select count(*) cc from PROrderItem where PR_ID = ?";
		int pagenum = WarehouseManagementService.getInstance().selectPageNumber(sqlCount, PGOrderId);
        response.setCharacterEncoding("UTF-8");   
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(pagenum);
		writer.close();
	}
	/*
	 * ��ù���������Ʒ����
	 */
	private void getRecord(HttpServletRequest request, HttpServletResponse response,String PGOrderId) throws IOException{
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		int currentPageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		//��ȡ���ݱ�id��sql���
		String sqlId = "select count(*) cc from Warehouse_order";
		int id = WarehouseManagementService.getInstance().getId(sqlId);
		//��ѯ��������
		List<WarehouseOrder> list = WarehouseManagementService.getInstance().selectPGOrder(PGOrderId, id, currentPage, currentPageSize);
        //�����ݴ���ΪJSON��ʽ
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
	 * �޸�ʵ�ʵ��������ͱ�ע
	private void modifyQuantity(HttpServletRequest request, HttpServletResponse response, List<WarehouseOrder> list) {
		int quantity = Integer.parseInt(request.getParameter("modifyquantity"));
		String productname = request.getParameter("productname");
		String remarks = request.getParameter("remarks");
		//�޸�ʵ�ʵ��������ͱ�ע
		WarehouseManagementService.getInstance().modifyQuantity(list, quantity, productname, remarks);	
	}
	*/
	
	/*
	 * ���ݿ�洢����
	 */
	private void storeInboundData(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
