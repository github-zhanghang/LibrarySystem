package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookTypeBean;
import com.library.dao.BookTypeDao;

/**
 * 查询图书
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectAllTypesServlet")
public class SelectTypesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookTypeBean> list = new BookTypeDao().getAllTypes();
		request.getSession().setAttribute("types", list);
		response.sendRedirect("web/adminfd/classify.jsp");
	}
}