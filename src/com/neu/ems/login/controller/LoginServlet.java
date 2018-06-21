package com.neu.ems.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.ems.entity.Administrator;
import com.neu.ems.login.service.LoginManageService;
import com.neu.ems.utils.DataNum;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Administrator administrator = new Administrator();
		
		administrator.setUsername(name);
		administrator.setPassword(password);
		
		String userType = LoginManageService.getInstance().getUserType(administrator);
		//"0"表示客服人员 	"1"表示调度中心管理员	"2"表示配送中心管理员	"3"表示库房管理员
		//"4"表示分站管理员		"5"表示财务管理员
		Map<String, Integer> dataNumMap = new HashMap<String, Integer>(); 
		//Map里存的是每种单号在数据库中保存的数量，用以保证单号不重复.
		dataNumMap = LoginManageService.getInstance().getdataNum();
		DataNum datanum = new DataNum();
		datanum.setNewOrder(dataNumMap.get("XD"));
		datanum.setQuitOrder(dataNumMap.get("TD"));
		datanum.setTaskOrder(dataNumMap.get("TK"));
		datanum.setProduct(dataNumMap.get("PD"));
		datanum.setPROrder(dataNumMap.get("PR"));
		
		
		request.getSession().setAttribute("username", name);
		if(null == userType) {
			response.sendRedirect(request.getContextPath() + "/.jsp");
		}else if("0".equals(userType)) {
			response.sendRedirect(request.getContextPath() + "/.jsp");
		}else if("1".equals(userType)) {
			
		}else if("2".equals(userType)) {
			
		}else if("3".equals(userType)) {
			
		}else if("4".equals(userType)) {
			
		}else if("5".equals(userType)) {
			
		}
		
	}

}
