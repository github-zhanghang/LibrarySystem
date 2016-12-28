package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.ManagerBean;
import com.library.dao.ManagerDao;

/**
 * 查询管理员
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectManagersServlet")
public class SelectManagersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ManagerBean> managerList = new ArrayList<ManagerBean>();

		String type = request.getParameter("type");
		if (type.equals("0")) {
			// 查询所有管理员
			managerList = new ManagerDao().getAllManagers();
		} else if (type.equals("1")) {
			// 根据账号或姓名查找
			String value = request.getParameter("value");
			managerList = new ManagerDao().getManagersByNameOrAccount(value);
		}
		request.getSession().setAttribute("admins", managerList);
		response.sendRedirect("web/adminfd/adminlist.jsp");
	}
}
