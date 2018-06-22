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
		
		//��ѯ
		//List<User> userlist = UserService.getInstance().selectUser(username, ageNew, 2);
		//��ѯָ��ҳ��
		List<Warehouse> warelist = WarehouseService.getInstance().queryWarehouse(warename, manager, Integer.parseInt(pageSize),Integer.parseInt(pageIndex));
		//��ѯ��ҳ��
		
		int pageCount = WarehouseService.getInstance().queryPageCount(warename, manager, Integer.parseInt(pageSize));
		//���ݹ���
		/*
		 * 1.page��
		 * 2.request������������
		 * 3.session:��ǰ�����Ӧ��Session����
		 * 4.applicationContext������Ӧ�ü�
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
