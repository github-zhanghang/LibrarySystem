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
 * 修改分类
 * 
 * @author 张航
 * 
 */
@WebServlet("/updateTypeServlet")
public class UpdateTypeServlet extends HttpServlet {

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

		String oldTypeName = request.getParameter("oldName");// 原类别名称
		String newTypeName = request.getParameter("newName");// 新类别名称
		if (oldTypeName.equals("") || newTypeName.equals("")) {
			result = false;
		} else {
			result = new BookTypeDao().updateType(oldTypeName, newTypeName);
		}
		if (result) {
			message = "修改成功";
		} else {
			message = "修改失败，请检查参数是否正确成功";
		}
		jsonObject.put("result", result);
		jsonObject.put("message", message);

		out.write(jsonObject.toString());
	}
}
