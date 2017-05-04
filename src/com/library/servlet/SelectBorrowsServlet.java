package com.library.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
		if (page == null || page.equals("0")) {
			page = "1";
		}

		if (type.equals("1")) {
			// 查询某个读者的借阅记录
			String readerAccount = request.getParameter("account");// 账号
			Map<String, Object> map = new BorrowDao().getBorrowingRecord(
					readerAccount, Integer.parseInt(page));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", map);
			request.getSession().setAttribute("borrows",
					jsonObject.getJSONObject("data").getString("borrow_info"));
			request.getSession().setAttribute("totalPage",
					jsonObject.getJSONObject("data").getString("totalPage"));
			request.getSession().setAttribute("currentPage", page);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("value", readerAccount);
			response.sendRedirect("web/adminfd/borrowlist.jsp");
			System.out.println("---格式："
					+ jsonObject.getJSONObject("data").toString());
		} else if (type.equals("2")) {
			// 查询尚未归还的借阅记录
			String readerAccount = request.getParameter("account");// 账号
			Map<String, Object> map = new BorrowDao()
					.getOverdueAndUnreturnedBorrowingRecordByAccount(
							readerAccount, Integer.parseInt(page));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", map);
			request.getSession().setAttribute("borrows",
					jsonObject.getJSONObject("data").getString("borrow_info"));
			request.getSession().setAttribute("totalPage",
					jsonObject.getJSONObject("data").getString("totalPage"));
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("value", readerAccount);
			response.sendRedirect("web/adminfd/borrowlist.jsp");
		} else if (type.equals("3")) {
			// 查询尚未归还并且借阅超时的借阅记录
			String readerAccount = request.getParameter("account");// 账号
			Map<String, Object> map = new BorrowDao()
					.getOverdueAndUnreturnedBorrowingRecordByAccount(
							readerAccount, Integer.parseInt(page));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", map);
			request.getSession().setAttribute("borrows",
					jsonObject.getJSONObject("data").getString("borrow_info"));
			request.getSession().setAttribute("totalPage",
					jsonObject.getJSONObject("data").getString("totalPage"));
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("value", readerAccount);
			response.sendRedirect("web/adminfd/borrowlist.jsp");
		} else if (type.equals("4")) {
			// 按书名或账号查找借阅记录
			String value = request.getParameter("value");
			Map<String, Object> map = new BorrowDao()
					.getBorrowingRecordByAccountOrBookName(value,
							Integer.parseInt(page));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", map);
			request.getSession().setAttribute("borrows",
					jsonObject.getJSONObject("data").getString("borrow_info"));
			request.getSession().setAttribute("totalPage",
					jsonObject.getJSONObject("data").getString("totalPage"));
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("value", value);
			response.sendRedirect("web/adminfd/borrowlist.jsp");
		} else if (type.equals("5")) {
			// 用户 查询某个读者的借阅记录
			String readerAccount = request.getParameter("account");// 账号
			Map<String, Object> map = new BorrowDao().getBorrowingRecord(
					readerAccount, Integer.parseInt(page));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", map);
			request.getSession().setAttribute("borrows",
					jsonObject.getJSONObject("data").getString("borrow_info"));
			request.getSession().setAttribute("totalPage",
					jsonObject.getJSONObject("data").getString("totalPage"));
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("account", readerAccount);
			response.sendRedirect("web/userfd/borrowinfo.jsp");
		}
	}
}
