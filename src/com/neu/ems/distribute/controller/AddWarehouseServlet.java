package com.neu.ems.distribute.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ems.distribute.service.WarehouseService;
import com.neu.ems.entity.Warehouse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("warename");
		String manager = request.getParameter("manager");
		//String address = request.getParameter("address");
		String waretype = request.getParameter("waretype");
		
		Warehouse warehouse = new Warehouse();
		
		warehouse.setName(name);
		warehouse.setManager(manager);
		warehouse.setType(waretype);
		
		WarehouseService.getInstance().addWarehouse(warehouse);
		
		
	}

}
