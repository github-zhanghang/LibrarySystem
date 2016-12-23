package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
			// 查询所有图书
			// 总页数
			int totalPage = new BookDetailDao().getAllBooksPageCount();
			List<BookDetailBean> bookList = new BookDetailDao()
					.getBooks(Integer.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			response.sendRedirect("web/adminfd/booklist.jsp");
		} else if (type.equals("1")) {
			// 根据分类查询图书
			String typeName = request.getParameter("typeName");
			// 总页数
			int totalPage = new BookDetailDao()
					.getAllBooksByTypePageCount(typeName);
			List<BookDetailBean> bookList = new BookDetailDao().getBooksByType(
					typeName, Integer.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			response.sendRedirect("web/adminfd/booklist.jsp");
		} else if (type.equals("2")) {
			// 根据书名查询图书
			String bookName = request.getParameter("bookName");
			BookDetailBean book = new BookDetailDao().getBookByName(bookName);
			List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();
			bookList.add(book);
			request.getSession().setAttribute("totalPage", 1);
			request.getSession().setAttribute("books", bookList);
			response.sendRedirect("web/adminfd/booklist.jsp");
		}
	}
}
