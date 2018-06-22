package com.neu.ems.distribute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ems.distribute.service.WarehouseService;
import com.neu.ems.entity.Warehouse;
/**
 * Servlet implementation class QueryWarehouseServlet
 */
public class QueryWarehouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryWarehouseServlet() {
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
		
		String pageIndex = "1";		
		
		String pageindex = request.getParameter("pageIndex");
		System.out.println(pageindex);
		String warename = "";		
		String manager = "";
		String pageSize = "";
		if(pageindex !=null && !"".equals(pageindex)) {
			pageIndex = pageindex;
			warename = (String) request.getSession().getAttribute("warename");
			
			manager = (String) request.getSession().getAttribute("manager");
			
			pageSize = (String) request.getSession().getAttribute("pageSize");
			//System.out.println(pageSize);
		}else{
			
			warename = request.getParameter("warename");
			manager = request.getParameter("manager");
			pageSize = request.getParameter("pageSize");
		}
			//request.getParameterValues();
		/*String managerNew = "";
		if(manager != null && !"".equals(manager)) {
			ageNew = Integer.parseInt(age);
		}
		*/
		
		//查询
		//List<User> userlist = UserService.getInstance().selectUser(username, ageNew, 2);
		//查询指定页数
		List<Warehouse> warelist = WarehouseService.getInstance().queryWarehouse(warename, manager, Integer.parseInt(pageSize),Integer.parseInt(pageIndex));
		//查询总页数
		
		int pageCount = WarehouseService.getInstance().queryPageCount(warename, manager, Integer.parseInt(pageSize));
		//数据共享
		/*
		 * 1.page：
		 * 2.request：请求作用域
		 * 3.session:当前请求对应的Session对象
		 * 4.applicationContext：整个应用级
		 */
		
		request.setAttribute("requestList", warelist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageIndex", pageIndex);
		
		//
		request.getSession().setAttribute("warename", warename);
		request.getSession().setAttribute("manager", manager);
		request.getSession().setAttribute("pageSize", pageSize);
		request.getSession().setAttribute("pageIndex", pageIndex);
		
		request.getRequestDispatcher("WarehouseInfo.jsp").forward(request, response);
		System.out.println("hahaha");
	}

}
