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
import com.library.dao.BookDetailDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 查询所有书籍
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectBooksServlet")
public class SelectBooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 页数
		String page = request.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		List<BookDetailBean> booList = new BookDetailDao().getBooks(Integer
				.parseInt(page));
		request.getSession().setAttribute("books", booList);
		/*request.getRequestDispatcher("web/adminfd/booklist.jsp").forward(request,
				response);*/
		response.sendRedirect("web/adminfd/booklist.jsp");
	}
}
