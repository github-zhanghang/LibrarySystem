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
		//类别名字
		String typeName = request.getParameter("typeName");
		//图书名字
		String bookName = request.getParameter("bookName");

		int totalPage = 1;
		if (currentPage == null || currentPage.equals("0")) {
			currentPage = "1";
		}
		if (type.equals("0")) {
			// 查询所有图书
			// 总页数
			totalPage = new BookDetailDao().getAllBooksPageCount();
			List<BookDetailBean> bookList = new BookDetailDao()
					.getBooks(Integer.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/adminfd/booklist.jsp");
		} else if (type.equals("1")) {
			// 根据分类查询图书
			// 总页数
			totalPage = new BookDetailDao()
					.getAllBooksByTypePageCount(typeName);
			List<BookDetailBean> bookList = new BookDetailDao().getBooksByType(
					typeName, Integer.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/adminfd/booklist.jsp");
		} else if (type.equals("2")) {
			// 根据书名查询图书
			
			BookDetailBean book = new BookDetailDao().getBookByName(bookName);
			List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();
			bookList.add(book);
			request.getSession().setAttribute("totalPage", 1);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/adminfd/booklist.jsp");
		}else if (type.equals("3")) {
			// 用户查询所有图书
			// 总页数
			totalPage = new BookDetailDao().getAllBooksPageCount();
			List<BookDetailBean> bookList = new BookDetailDao()
					.getBooks(Integer.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/userfd/newbook.jsp");
		}else if (type.equals("4")) {
			// 用户根据书名查询图书
			
			BookDetailBean book = new BookDetailDao().getBookByName(bookName);
			List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();
			bookList.add(book);
			request.getSession().setAttribute("totalPage", 1);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/userfd/newbook.jsp");
		}
	}
}
