package com.hrms.pa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pa.entity.EngageRecordEmp;
import com.hrms.pa.manager.UserManager;

public class DeleteEgageRcord extends HttpServlet {

	
	public DeleteEgageRcord() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		UserManager userManager = new UserManager();
		userManager.deleteByRecordno(emp_id);
		List<EngageRecordEmp> eremps = userManager.queryEngageRecordEmps();
		if (eremps.size() > 0 && eremps != null) {
			request.setAttribute("eremps", eremps);
			request.getRequestDispatcher("/WEB-INF/pa/engageRecord.jsp").forward(request, response);
			
		}

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
