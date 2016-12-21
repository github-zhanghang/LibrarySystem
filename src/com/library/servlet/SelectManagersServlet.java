package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookDetailBean;
import com.library.bean.BookTypeBean;
import com.library.bean.ManagerBean;
import com.library.dao.BookDetailDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 查询所有管理员
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

		List<ManagerBean> managerList = new ManagerDao().getAllManagers();
		request.getSession().setAttribute("admins", managerList);
		response.sendRedirect("web/adminfd/adminlist.jsp");
	}
}