package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.ReaderBean;
import com.library.dao.ReaderDao;

/**
 * 查询读者
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectReadersServlet")
public class SelectReadersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ReaderBean> readerList = new ArrayList<ReaderBean>();
		int totalPage = 0;

		String type = request.getParameter("type");
		if (type.equals("0")) {
			// 查询所有读者(分页)
			String currentPage = request.getParameter("page");
			if (currentPage == null || currentPage.equals("")) {
				currentPage = "1";
			}
			// 页数
			totalPage = new ReaderDao().getAllReadersPageCount();
			readerList = new ReaderDao().getAllReaders(Integer
					.parseInt(currentPage));
		} else if (type.equals("1")) {
			// 根据账号查找读者
			String account = request.getParameter("account");
			ReaderBean readerBean = new ReaderDao().getReaderByAccount(account);
			readerList.add(readerBean);
			totalPage = 1;
		} else if (type.equals("2")) {
			// 根据姓名查找读者(分页)
			String currentPage = request.getParameter("page");
			if (currentPage == null || currentPage.equals("")) {
				currentPage = "1";
			}
			String readerName = request.getParameter("name");
			// 页数
			totalPage = new ReaderDao()
					.getAllReadersByNamePageCount(readerName);
			readerList = new ReaderDao().getAllReadersByName(
					Integer.parseInt(currentPage), readerName);
		} else if (type.equals("3")) {
			// 根据账号或姓名查找读者(分页)
			String currentPage = request.getParameter("page");
			if (currentPage == null || currentPage.equals("")) {
				currentPage = "1";
			}
			String value = request.getParameter("value");
			// 页数
			totalPage = new ReaderDao()
					.getReadersByNameOrAccountPageCount(value);
			readerList = new ReaderDao().getReadersByNameOrAccount(
					Integer.parseInt(currentPage), value);
		}
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute("readers", readerList);
		response.sendRedirect("web/adminfd/userlist.jsp");
	}
}
