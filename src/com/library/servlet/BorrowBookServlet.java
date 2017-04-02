package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookDetailBean;
import com.library.dao.BookDao;
import com.library.dao.BorrowDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

/**
 * 借书
 * 
 * @author 张航
 * 
 */
@WebServlet("/borrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 用户id和书名
		String readerId = request.getParameter("readerId");
		String bookName = request.getParameter("bookName");

		// 查询该书是否还有
		List<BookDetailBean> bookList = new BookDao().getBookByName(bookName);
		String bookId = "";
		if (bookList != null) {
			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getIsBorrowed() == 1) {
					bookId = bookList.get(i).getBookID();
				}
			}
		}
		if (bookId.equals("")) {
			System.out.println("借书失败");
		} else {
			// 开始借书
			if (new BorrowDao().borrowBook(readerId, bookId)) {
				System.out.println("借书成功");
			} else {
				System.out.println("借书失败");
			}
		}
	}
}
