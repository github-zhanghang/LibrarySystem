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
 * 修改密码
 * 
 * @author 张航
 * 
 */
@WebServlet("/changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 类型，0表示修改读者，1表示修改管理员
		String type = request.getParameter("type");
		String account = request.getParameter("account");// 账号
		String oldPassword = request.getParameter("oldPassword");// 新密码
		String newPassword = request.getParameter("newPassword");// 新密码

		boolean result = false;
		if (type.equals("1")) {
			result = new ManagerDao().changePassword(account, oldPassword,
					newPassword);
			if (result) {
				// 修改成功
				request.getSession().setAttribute("account", account);
				response.sendRedirect("web/adminfd/adminlist.jsp");
			} else {
				// 修改失败
				out.println("<script language='javaScript'> alert('账号或密码不能为空');</script>");
				response.setHeader("refresh",
						"1;url=/WisdomLibraryDemo/web/adminfd/pass.jsp");
			}
		} else {
			  result = new ManagerDao().changePassword(account, oldPassword,
			  newPassword); if (result) {
			  
			  } else {
			  
			  }
			 
		}
	}
}
