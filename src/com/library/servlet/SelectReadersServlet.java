package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.ReaderBean;
import com.library.dao.ReaderDao;

/**
 * 查询读者
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectAllReadersServlet")
public class SelectReadersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentPage = request.getParameter("page");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		// 页数
		int totalPage = new ReaderDao().getAllReadersPageCount();
		List<ReaderBean> list = new ReaderDao().getAllReaders(Integer
				.parseInt(currentPage));
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute("readers", list);
		response.sendRedirect("web/adminfd/userlist.jsp");
	}
}
