package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookTypeBean;
import com.library.dao.BookTypeDao;

/**
 * 查询分类
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectTypesServlet")
public class SelectTypesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookTypeBean> typeList = new ArrayList<BookTypeBean>();

		String type = request.getParameter("type");
		if (type.equals("0")) {
			// 查询所有分类
			typeList = new BookTypeDao().getAllTypes();
		} else if (type.equals("1")) {
			String typeName = request.getParameter("typeName");
			BookTypeBean typeBean = new BookTypeDao().getTypeByName(typeName);
			typeList.add(typeBean);
		}
		request.getSession().setAttribute("types", typeList);
		response.sendRedirect("web/adminfd/classify.jsp");
	}
}
