package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookDetailBean;
import com.library.bean.BookTypeBean;
import com.library.dao.BookDetailDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 查询图书
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectAllTypesServlet")
public class SelectAllTypesServlet extends HttpServlet {

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

		List<BookTypeBean> list = new BookTypeDao().getAllTypes();
		if (list != null) {
			result = true;
			message = "查询成功";
		} else {
			message = "查询失败";
		}
		jsonObject.put("result", result);
		jsonObject.put("message", message);
		jsonObject.put("data", list);

		out.write(jsonObject.toString());
	}
}
