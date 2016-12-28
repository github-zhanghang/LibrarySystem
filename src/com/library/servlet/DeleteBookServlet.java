package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.library.dao.BookDetailDao;

/**
 * 删除书籍
 * 
 * @author 张航
 * 
 */
@WebServlet("/deleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String type = request.getParameter("type");
		if (type.equals("0")) {
			// 根据书名删除单个图书
			String bookName = request.getParameter("bookName");
			boolean result = new BookDetailDao().deleteBookByName(bookName);
			if (result) {
				response.sendRedirect("/WisdomLibraryDemo/selectBooksServlet?type=0");

			} else {
				response.sendRedirect("/WisdomLibraryDemo/selectBooksServlet?type=0");

			}
		} else if (type.equals("1")) {
			// 根据书籍id批量删除
			String bookIdString = request.getParameter("bookIds");
			String[] bookIds = bookIdString.split("-");
			int length = bookIds.length;
			boolean[] results = new boolean[length];
			String message = "";

			boolean isSuccess = true;
			for (int i = 0; i < bookIds.length; i++) {
				results[i] = new BookDetailDao().deleteBookById(bookIds[i]);
				if (!results[i]) {
					isSuccess = false;
					message += bookIds[i] + " ";
				}
			}
			if (isSuccess) {
				message = "全部删除成功";
			} else {
				message = "部分书籍删除失败:" + message;
			}
		}
	}
}
