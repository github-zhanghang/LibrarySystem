package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.ManagerBean;
import com.library.bean.ReaderBean;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

/**
 * 登录接口
 * 
 * @author 张航
 * 
 */
public class LoginServlet extends HttpServlet {
	// 0代表读者登录，1代表管理员登录
	private static final String TYPE_READER = "0";
	private static final String TYPE_MANAGER = "1";

	// 0代表登录失败，1代表登录成功
	private static final String LOGIN_FAILED = "0";
	private static final String LOGIN_SUCCESS = "1";

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (account.equals("") || password.equals("")) {
			request.setAttribute("loginResult", LOGIN_FAILED);
			return;
		}

		String type = request.getParameter("type");
		if (type.equals(TYPE_READER)) {
			ReaderBean readerBean = new ReaderDao().getReaderByAccount(account);
			if (readerBean != null) {
				// 登录成功
				request.setAttribute("loginResult", LOGIN_SUCCESS);
			} else if (type.equals(TYPE_MANAGER)) {
				// 登录失败
				request.setAttribute("loginResult", LOGIN_FAILED);
			}
		} else if (type.equals(TYPE_MANAGER)) {
			ManagerBean managerBean = new ManagerDao()
					.getManagerByAccount(account);
			if (managerBean != null) {
				// 登录成功
				request.setAttribute("loginResult", LOGIN_SUCCESS);
			} else if (type.equals(TYPE_MANAGER)) {
				// 登录失败
				request.setAttribute("loginResult", LOGIN_FAILED);
			}
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
