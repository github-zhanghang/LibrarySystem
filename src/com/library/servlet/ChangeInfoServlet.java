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
import com.library.bean.ManagerBean;
import com.library.bean.ReaderBean;
import com.library.dao.BookDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

/**
 * 修改信息页面数据
 * 
 * @author 张航
 * 
 */
@WebServlet("/changeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 类型
		String type = request.getParameter("type");
		String value = request.getParameter("value");// 账号或者书籍名称或者分类名称

		boolean result = false;
		if (type.equals("0")) {
			// 读者
			ReaderBean readerBean = new ReaderDao().getReaderByAccount(value);
			request.getSession().setAttribute("reader", readerBean);
			response.sendRedirect("web/adminfd/motifyuser.jsp");
		} else if (type.equals("1")) {
			// 管理员
			ManagerBean managerBean = new ManagerDao()
					.getManagerByAccount(value);
			request.getSession().setAttribute("manager", managerBean);
			response.sendRedirect("web/adminfd/motifyadmin.jsp");
		} else if (type.equals("2")) {
			// 书籍
			List<BookDetailBean> bookDetailBeanList = new BookDao()
					.getBookByName(value);
			request.getSession().setAttribute("book", bookDetailBeanList);
			response.sendRedirect("web/adminfd/motifybooks.jsp");
		} else if (type.equals("3")) {
			// 分类
			BookTypeBean bookTypeBean = new BookTypeDao().getTypeByName(value);
			request.getSession().setAttribute("type", bookTypeBean);
			response.sendRedirect("web/adminfd/motifytype.jsp");
		}
	}
}
