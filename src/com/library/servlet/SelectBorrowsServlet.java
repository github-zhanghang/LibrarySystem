package com.library.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookDetailBean;
import com.library.bean.BorrowBean;
import com.library.dao.BookDetailDao;
import com.library.dao.BorrowDao;

/**
 * 查询借阅记录
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectBorrowsServlet")
public class SelectBorrowsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 类型
		String type = request.getParameter("type");
		// 分页的页数
		String page = request.getParameter("page");

		if (page == null || page.equals("")) {
			page = "1";
		}

		if (type.equals("0")) {
			// 查询所有借阅记录
			List<BorrowBean> list = new BorrowDao().getBorrowingRecord(Integer
					.parseInt(page));
			request.getSession().setAttribute("borrows", list);
			response.sendRedirect("web/adminfd/borrowlist.jsp");
		} else if (type.equals("1")) {
			// 查询某个读者的借阅记录
			String readerAccount = request.getParameter("account");// 账号
			List<BorrowBean> list = new BorrowDao()
					.getBorrowingRecordByAccount(readerAccount,
							Integer.parseInt(page));
			request.getSession().setAttribute("borrows", list);
			response.sendRedirect("");
		} else if (type.equals("2")) {
			// 查询尚未归还的借阅记录
			List<BorrowBean> list = new BorrowDao()
					.getUnreturnedBorrowingRecord(Integer.parseInt(page));
			request.getSession().setAttribute("borrows", list);
			response.sendRedirect("");
		} else if (type.equals("3")) {
			// 查询尚未归还并且借阅超时的借阅记录（15天为超时时间）
			List<BorrowBean> list = new BorrowDao()
					.getOverdueAndUnreturnedBorrowingRecord(15,
							Integer.parseInt(page));
			request.getSession().setAttribute("borrows", list);
			response.sendRedirect("");
		}
	}
}
