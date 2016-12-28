package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.CollectionDao;

/**
 * 添加收藏
 * 
 * @author 张航
 * 
 */
@WebServlet("/addCollectionServlet")
public class AddCollectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String readerAccount = request.getParameter("account");
		String bookName = request.getParameter("bookName");
		// 判断是否已收藏
		boolean isCollected = new CollectionDao().isCollected(readerAccount,
				bookName);
		if (isCollected) {
			// 原来已收藏该书
		} else {
			// 添加到收藏
			boolean result = new CollectionDao().addCollection(readerAccount,
					bookName);
			if (result) {
				// 收藏成功
				request.getRequestDispatcher(
						"selectBorrowsServlet?type=5&account=131006132")
						.forward(request, response);
			} else {

			}
		}
	}
}
