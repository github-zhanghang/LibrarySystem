package com.library.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.ReaderBean;
import com.library.dao.BookTypeDao;
import com.library.dao.ReaderDao;

/**
 * 查询读者
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectAllReadersServlet")
public class SelectAllReadersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageCount = request.getParameter("page");
		if(pageCount==null || pageCount.equals("")){
			pageCount="1";
		}
		List<ReaderBean> list = new ReaderDao().getAllReaders(Integer
				.parseInt(pageCount));
	/*	request.setAttribute("readers", list);
		request.getRequestDispatcher("web/adminfd/userlist.jsp").forward(
				request, response);*/
		request.getSession().setAttribute("readers", list);
		response.sendRedirect("web/adminfd/userlist.jsp");
	}
}
