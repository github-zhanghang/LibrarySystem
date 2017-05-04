package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BorrowDao;

/**
 * 续借
 * 
 * @author 张航
 * 
 */
@WebServlet("/renewBookServlet")
public class RenewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 用户账号、书名、续借天数
		String readerAccount = request.getParameter("readerAccount");
		String bookName = request.getParameter("bookName");
		int days = 15;// 续借时长,15天

		// 开始借书
		if (new BorrowDao().renewBook(readerAccount, bookName, days)) {
			System.out.println("续借成功");
		} else {
			System.out.println("续借失败");
		}
	}
}
