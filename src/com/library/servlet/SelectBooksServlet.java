package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookDetailBean;
import com.library.dao.BookDetailDao;
import com.library.dao.ReaderDao;

/**
 * 查询书籍
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

		// 类型
		String type = request.getParameter("type");
		// 当前页数
		String currentPage = request.getParameter("page");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		if (type.equals("0")) {
			// 总页数
			int totalPage = new BookDetailDao().getAllBooksPageCount();
			// 查询图书
			List<BookDetailBean> booList = new BookDetailDao().getBooks(Integer
					.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", booList);
			response.sendRedirect("web/adminfd/booklist.jsp");
		} else if (type.equals("1")) {
			// 根据分类查询图书
			String typeName = request.getParameter("typeName");
			// 总页数
			int totalPage = new BookDetailDao()
					.getAllBooksByTypePageCount(typeName);
			// 查询图书
			List<BookDetailBean> booList = new BookDetailDao().getBooksByType(
					typeName, Integer.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", booList);
			response.sendRedirect("web/adminfd/booklist.jsp");
		}
	}
}
