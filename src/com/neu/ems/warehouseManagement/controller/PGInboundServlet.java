package com.neu.ems.warehouseManagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String PGOrderId = request.getParameter("pId");
		int currentPageSize = Integer.parseInt(request.getParameter("currentPageSize"));
		String currentPage = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage");
		// 分页处理，默认显示第一页
		String sql = "select count(*) cc from prorderitem where PR_ID = ?";
		int pagenum = WarehouseManagementService.getInstance().selectPageNumber(sql, PGOrderId);

	}

}
