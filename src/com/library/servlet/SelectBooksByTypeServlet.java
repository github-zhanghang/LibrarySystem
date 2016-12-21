package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.library.bean.BookDetailBean;
import com.library.dao.BookDetailDao;

/**
 * 根据分类查询书籍
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectBooksByTypeServlet")
public class SelectBooksByTypeServlet extends HttpServlet {

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

		// 页数
		String page = request.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// 分类
		String type = request.getParameter("type");
		List<BookDetailBean> bookList = new BookDetailDao().getBooksByType(type,
				Integer.parseInt(page));
		if (bookList != null) {
			result = true;
			message = "查询成功";
		} else {
			message = "查询失败";
		}
		jsonObject.put("result", result);
		jsonObject.put("message", message);
		jsonObject.put("data", bookList);

		out.write(jsonObject.toString());
	}
}
