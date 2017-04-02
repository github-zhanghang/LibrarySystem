package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.CollectionDao;

/**
 * 添加收藏
 * 
 * @author 张航
 * 
 */
@WebServlet("/addCollectionServlet")
public class AddCollectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String readerId = request.getParameter("readerId");
		String bookName = request.getParameter("bookName");
		// 判断是否已收藏
		boolean isCollected = new CollectionDao().isCollected(readerId,
				bookName);
		if (isCollected) {
			// 原来已收藏该书
		} else {
			// 添加到收藏
			boolean result = new CollectionDao().addCollection(readerId,
					bookName);
			if (result) {
				// 收藏成功
				System.out.println("收藏成功");
				/*
				 * request.getSession().setAttribute("readerId", readerId);
				 * response.sendRedirect(
				 * "/WisdomLibraryDemo/selectCollectionsServlet?readerId=" +
				 * readerId);
				 */
			} else {
				System.out.println("收藏失败");
				/*
				 * request.getSession().setAttribute("readerId", readerId);
				 * response
				 * .sendRedirect("/WisdomLibraryDemo/selectBooksServlet_user?type=0"
				 * + "&readerId=" + readerId);
				 */
			}
		}
	}
}
