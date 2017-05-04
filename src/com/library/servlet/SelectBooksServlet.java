package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookBean;
import com.library.bean.BookDetailBean;
import com.library.dao.BookDao;

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
		// 类别名字
		String typeName = request.getParameter("typeName");
		// 图书名字
		String bookName = request.getParameter("bookName");

		int totalPage = 1;
		if (currentPage == null || currentPage.equals("0")) {
			currentPage = "1";
		}
		if (type.equals("0")) {
			// 查询所有图书
			// 总页数
			totalPage = new BookDao().getAllBooksPageCount();
			List<BookBean> bookList = new BookDao().getBooks(Integer
					.parseInt(currentPage));

			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/adminfd/booklist.jsp");

			for (BookBean bookBean : bookList) {
				System.out.println(bookBean);
			}
		} else if (type.equals("1")) {
			// 根据分类查询图书
			// 总页数
			totalPage = new BookDao().getAllBooksByTypePageCount(typeName);
			List<BookBean> bookList = new BookDao().getBooksByType(typeName,
					Integer.parseInt(currentPage));

			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/adminfd/booklist.jsp");

			for (BookBean bookBean : bookList) {
				System.out.println(bookBean);
			}
		} else if (type.equals("2")) {
			// 根据书名查询图书
			List<BookBean> bookList = new ArrayList<BookBean>();
			List<BookDetailBean> bookDetailBeans = new BookDao()
					.getBookByName(bookName);
			int borrowCount = 0;
			BookBean bookBean = null;
			for (BookDetailBean bookDetailBean : bookDetailBeans) {
				borrowCount += bookDetailBean.getBorrowTimes();
				bookBean = new BookBean(bookDetailBean.getBookName(),
						bookDetailBean.getBookAuthor(),
						bookDetailBean.getBookType(),
						bookDetailBean.getBookAddress(),
						bookDetailBeans.size(), borrowCount,
						bookDetailBean.getCreateTime(),
						bookDetailBean.getImageUrl(),
						bookDetailBean.getBookPress());
			}
			bookList.add(bookBean);

			request.getSession().setAttribute("totalPage", 1);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/adminfd/booklist.jsp");
			for (BookBean book : bookList) {
				System.out.println(book);
			}
		} else if (type.equals("3")) {
			// 用户查询所有图书
			// 总页数
			totalPage = new BookDao().getAllBooksPageCount();
			List<BookBean> bookList = new BookDao().getBooks(Integer
					.parseInt(currentPage));
			request.getSession().setAttribute("totalPage", totalPage);
			request.getSession().setAttribute("books", bookList);
			request.getSession().setAttribute("currentPage", currentPage);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("typeName", typeName);
			request.getSession().setAttribute("bookName", bookName);
			response.sendRedirect("web/userfd/newbook.jsp");

			for (BookBean bookBean : bookList) {
				System.out.println(bookBean);
			}
		} else if (type.equals("4")) {
			// 用户根据书名查询图书
			List<BookBean> bookList = new ArrayList<BookBean>();
			List<BookDetailBean> bookDetailBeans = new BookDao()
					.getBookByName(bookName);
			int borrowCount = 0;
			BookBean bookBean = null;
			for (BookDetailBean bookDetailBean : bookDetailBeans) {
				borrowCount += bookDetailBean.getBorrowTimes();
				bookBean = new BookBean(bookDetailBean.getBookName(),
						bookDetailBean.getBookAuthor(),
						bookDetailBean.getBookType(),
						bookDetailBean.getBookAddress(),
						bookDetailBeans.size(), borrowCount,
						bookDetailBean.getCreateTime(),
						bookDetailBean.getImageUrl(),
						bookDetailBean.getBookPress());
			}
			bookList.add(bookBean);
			for (BookBean book : bookList) {
				System.out.println(book);
			}

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
