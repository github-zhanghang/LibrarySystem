package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;
import com.library.dao.BorrowDao;

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
		// 用户账号、书名、天数
		String readerAccount = request.getParameter("readerAccount");
		String bookName = request.getParameter("bookName");
		int days = 30;// 借阅时长,30天

		// 查询该书是否可借
		boolean isEnable = new BookDao().isCanBorrow(bookName);
		if (!isEnable) {
			System.out.println("借书失败,无可借书籍");
		} else {
			// 开始借书
			if (new BorrowDao().borrowBook(readerAccount, bookName, days)) {
				System.out.println("借书成功");
			} else {
				System.out.println("借书失败");
			}
		}
	}
}
