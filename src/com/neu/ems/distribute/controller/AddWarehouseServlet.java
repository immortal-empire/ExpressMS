package com.neu.ems.distribute.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ems.distribute.service.WarehouseService;
import com.neu.ems.entity.Warehouse;
import com.neu.ems.utils.DataNum;

/**
 * Servlet implementation class AddWarehouseServlet
 */
public class AddWarehouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddWarehouseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if("validate".equals(action)) {
			String waretype = request.getParameter("waretype");
			boolean flag = WarehouseService.getInstance().validateType(waretype);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.print(flag);
			pw.close();
		}else {
			String name = request.getParameter("warename");
			String address = request.getParameter("address");
			String manager = request.getParameter("manager");
			String waretype = request.getParameter("waretype");

			Warehouse warehouse = new Warehouse();
			DataNum datanum = new DataNum();
			int warehouseNum = datanum.getWarehouseNum();
			DecimalFormat df = new DecimalFormat("000000");

			String ID = "WH" + df.format(warehouseNum);

			warehouse.setId(ID);
			warehouse.setName(name);
			warehouse.setAddress(address);
			warehouse.setManager(manager);
			warehouse.setType(waretype);

			WarehouseService.getInstance().addWarehouse(warehouse);
			
			
			response.sendRedirect(request.getContextPath() + "/queryWarehouseServlet");
		}
		

	}

}
