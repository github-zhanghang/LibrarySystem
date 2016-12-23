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

		JSONObject jsonObject = new JSONObject();
		boolean result = false;// 结果
		String message = "";

		String bookName = request.getParameter("bookName");// 书名
		if (bookName.equals("")) {
			result = false;
		} else {
			result = new BookDetailDao().deleteBook(bookName);
		}
		if (result) {
			message = "删除成功";
			response.sendRedirect("/WisdomLibraryDemo/selectBooksServlet?type=0");
		} else {
			message = "只有未被借阅过的图书才可以删除";
			out.println("<script language='javaScript'> alert('删除失败');</script>");
			response.setHeader("refresh",
					"1;url=/WisdomLibraryDemo/selectBooksServlet");
			
		}
		/*jsonObject.put("result", result);
		jsonObject.put("message", message);

		out.write(jsonObject.toString());*/
	}
}
