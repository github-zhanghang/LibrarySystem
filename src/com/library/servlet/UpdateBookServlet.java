package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDetailDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 修改书籍信息
 * 
 * @author 张航
 * 
 */
@WebServlet("/updateBookServlet")
public class UpdateBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oldBookName = request.getParameter("oldName");// 原书名
		String newBookName = request.getParameter("newName");// 新书名
		String newBookAuthor = request.getParameter("newAuthor");// 新作者
		String newBookType = request.getParameter("newType");// 新类型
		String newBookAddress = request.getParameter("newAddress");// 新位置
		String newBookCount = request.getParameter("newCount");// 新数量
		String newImageUrl = request.getParameter("newImage");// 新图片地址
		String newBookPress = request.getParameter("newPress");// 新出版社

		int count = Integer.parseInt(newBookCount);
		boolean result = new BookDetailDao().updateBookByName(oldBookName,
				newBookName, newBookAuthor, newBookType, newBookAddress, count,
				newImageUrl, newBookPress);
		if (result) {
			request.setAttribute("book",
					new BookDetailDao().getBookByName(newBookName));
			request.getRequestDispatcher("updateBookServlet").forward(request, response);
		} else {
			// 提示修改失败
		}
	}
}
