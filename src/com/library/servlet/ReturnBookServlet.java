package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BorrowDao;

/**
 * 还书
 * 
 * @author 张航
 * 
 */
@WebServlet("/returnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 用户id和书籍id
		String readerAccount = request.getParameter("readerAccount");
		String bookName = request.getParameter("bookName");

		// 还书
		if (new BorrowDao().returnBook(readerAccount, bookName)) {
			// 还书成功,返回借阅列表
			System.out.println("还书成功");
		} else {
			// 还书失败,返回借阅列表
			System.out.println("还书失败");
		}
	}
}
