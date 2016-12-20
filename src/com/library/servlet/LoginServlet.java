package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.ReaderBean;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 登录
 * 
 * @author 张航
 * 
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;// 结果

		// 账号密码
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if (account == null || password == null || account.equals("")
				|| password.equals("")) {
			result = false;
			out.println("<script language='javaScript'> alert('账号或密码不能为空，单击确定返回登录页面！');</script>");
			response.setHeader("refresh",
					"1;url=/WisdomLibraryDemo/web/userfd/login.jsp");
		} else {
			// 登录类型，0表示读者，1表示管理员，默认0
			String type = request.getParameter("type");

			if (type.equals("1")) {
				result = new ManagerDao().login(account, password);
				if (!result) {
					out.println("<script language='javaScript'> alert('账号或密码错误，单击确定返回登录页面！');</script>");
					response.setHeader("refresh",
							"1;url=/WisdomLibraryDemo/web/userfd/login.jsp");
				} else {
					request.getSession().setAttribute("account", account);
					response.sendRedirect("/WisdomLibraryDemo/web/adminfd/adminindex.jsp");
				}
			} else {
				result = new ReaderDao().login(account, password);
				if (!result) {
					out.println("<script language='javaScript'> alert('账号或密码错误，单击确定返回登录页面！');</script>");
					response.setHeader("refresh",
							"1;url=/WisdomLibraryDemo/web/userfd/login.jsp");
				} else {
					request.getSession().setAttribute("account", account);
					response.sendRedirect("/WisdomLibraryDemo/web/userfd/index.jsp");
				}
			}
		}
	}
}
