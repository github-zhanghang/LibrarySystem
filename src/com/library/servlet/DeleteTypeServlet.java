package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDetailDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 删除用户
 * 
 * @author 张航
 * 
 */
@WebServlet("/deleteTypeServlet")
public class DeleteTypeServlet extends HttpServlet {

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

		String typeName = request.getParameter("typeName");// 账号
		if (typeName.equals("")) {
			result = false;
		} else {
			result = new BookTypeDao().deleteType(typeName);
		}
		if (result) {
			message = "删除成功";
		} else {
			message = "只有该分类下没有图书才可以删除";
		}
		jsonObject.put("result", result);
		jsonObject.put("message", message);

		out.write(jsonObject.toString());
	}
}
