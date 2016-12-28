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
import com.library.dao.BorrowDao;
import com.library.dao.CollectionDao;
import com.library.dao.ReaderDao;

/**
 * 查询书籍
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectBooksServlet_user")
public class User_SelectBooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 类型
		String type = request.getParameter("type");
		// 账号
		String readerAccount = request.getParameter("account");
		System.out.println("=================="+readerAccount);
		// 当前页数
		String currentPage = request.getParameter("page");
		// 根据书名查询图书
		String bookName = request.getParameter("bookName");
		// 根据分类查询图书
		String typeName = request.getParameter("typeName");
		// 根据分类或书名
		String value = request.getParameter("value");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}

		// 保存书籍
		List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();
		// 总页数
		int totalPage = 0;

		if (type.equals("0")) {
			// 查询所有图书
			// 总页数
			totalPage = new BookDetailDao().getAllBooksPageCount();
			// 书籍集合
			bookList = new BookDetailDao().getBooks(Integer
					.parseInt(currentPage));
			for (BookDetailBean book : bookList) {
				// 保存是否已借过并且尚未归还,1表示借过，0表示未借过
				if (new BorrowDao().isReturned(readerAccount,
						book.getBookName())) {
					book.setIsBorrowed("0");
				} else {
					book.setIsBorrowed("1");
				}
				// 保存是否已收藏,1表示已收藏，0表示未收藏
				if (new CollectionDao().isCollected(readerAccount,
						book.getBookName())) {
					book.setIsCollected("1");
				} else {
					book.setIsCollected("0");
				}
			}
		} else if (type.equals("1")) {
			// 根据分类查询图书
		
			// 总页数
			totalPage = new BookDetailDao()
					.getAllBooksByTypePageCount(typeName);
			// 书籍集合
			bookList = new BookDetailDao().getBooksByType(typeName,
					Integer.parseInt(currentPage));
			// 保存是否已借过并且尚未归还
			for (BookDetailBean book : bookList) {
				if (new BorrowDao().isReturned(readerAccount,
						book.getBookName())) {
					book.setIsBorrowed("0");
				} else {
					book.setIsBorrowed("1");
				}
				// 保存是否已收藏,1表示已收藏，0表示未收藏
				if (new CollectionDao().isCollected(readerAccount,
						book.getBookName())) {
					book.setIsCollected("1");
				} else {
					book.setIsCollected("0");
				}
			}
		} else if (type.equals("2")) {
			// 根据书名查询图书
			
			totalPage = 1;
			BookDetailBean book = new BookDetailDao().getBookByName(bookName);
			bookList.add(book);
			if (new BorrowDao().isReturned(readerAccount, book.getBookName())) {
				book.setIsBorrowed("0");
			} else {
				book.setIsBorrowed("1");
			}
			// 保存是否已收藏,1表示已收藏，0表示未收藏
			if (new CollectionDao().isCollected(readerAccount,
					book.getBookName())) {
				book.setIsCollected("1");
			} else {
				book.setIsCollected("0");
			}
		} else if (type.equals("3")) {
			// 根据分类或书名
			
			bookList = new BookDetailDao().getBooksByTypeOrName(value,
					Integer.parseInt(currentPage));
			// 总页数
			totalPage = new BookDetailDao().getBooksByTypeOrNamePages(value);
			// 保存是否已借过并且尚未归还
			for (BookDetailBean book : bookList) {
				if (new BorrowDao().isReturned(readerAccount,
						book.getBookName())) {
					book.setIsBorrowed("0");
				} else {
					book.setIsBorrowed("1");
				}
				// 保存是否已收藏,1表示已收藏，0表示未收藏
				if (new CollectionDao().isCollected(readerAccount,
						book.getBookName())) {
					book.setIsCollected("1");
				} else {
					book.setIsCollected("0");
				}
			}
		}
		for (BookDetailBean bookDetailBean : bookList) {
			System.out.println(bookDetailBean);
		}
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute("books", bookList);	
		request.getSession().setAttribute("currentPage", currentPage);
		request.getSession().setAttribute("type", type);
		request.getSession().setAttribute("typeName", typeName);
		request.getSession().setAttribute("bookName", bookName);
		request.getSession().setAttribute("value", value);
		request.getSession().setAttribute("account", readerAccount);
		response.sendRedirect("web/userfd/newbook.jsp");
	}
}
