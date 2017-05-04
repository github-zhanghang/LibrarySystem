package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.ManagerDao;

/**
 * 修改管理员信息
 * 
 * @author 张航
 * 
 */
@WebServlet("/updateManagersServlet")
public class UpdateManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String account = request.getParameter("account");// 账号
		String newName = request.getParameter("newName");// 新姓名
		String newPhone = request.getParameter("newPhone");// 新联系方式

		boolean result = new ManagerDao().updateManagerWithoutDuty(account,
				newName, newPhone);
		if (result) {
			out.println("<script language='javaScript'> alert('修改成功，单击确定返回首页！');</script>");
	   		response.setHeader("refresh","1;url=/WisdomLibraryDemo/selectBooksServlet?type=0");
		} else {
			out.println("<script language='javaScript'> alert('修改失败，单击确定返回首页！');</script>");
	   		response.setHeader("refresh","1;url=/WisdomLibraryDemo/selectBooksServlet?type=0");
		}
	}
}
