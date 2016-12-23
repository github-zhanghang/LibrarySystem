package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();
		int totalPage = 0;

		if (type.equals("0")) {
			// 查询所有借阅记录
			borrowList = new BorrowDao().getBorrowingRecord(Integer
					.parseInt(page));
		} else if (type.equals("1")) {
			// 查询某个读者的借阅记录
			String readerAccount = request.getParameter("account");// 账号
			borrowList = new BorrowDao().getBorrowingRecordByAccount(
					readerAccount, Integer.parseInt(page));
		} else if (type.equals("2")) {
			// 查询尚未归还的借阅记录
			borrowList = new BorrowDao().getUnreturnedBorrowingRecord(Integer
					.parseInt(page));
		} else if (type.equals("3")) {
			// 查询尚未归还并且借阅超时的借阅记录（15天为超时时间）
			borrowList = new BorrowDao()
					.getOverdueAndUnreturnedBorrowingRecord(15,
							Integer.parseInt(page));
		} else if (type.equals("4")) {
			// 按书名或账号查找借阅记录
			String value = request.getParameter("value");
			borrowList = new BorrowDao().getBorrowingRecordByAccountOrBookName(
					value, Integer.parseInt(page));
			totalPage = new BorrowDao()
					.getBorrowingRecordByAccountOrNamePages(value);
		}
		for (BorrowBean borrowBean : borrowList) {
			System.out.println(borrowBean);
		}
		request.getSession().setAttribute("borrows", borrowList);
		request.getSession().setAttribute("totalPage", totalPage);
		response.sendRedirect("web/adminfd/borrowlist.jsp");
	}
}
