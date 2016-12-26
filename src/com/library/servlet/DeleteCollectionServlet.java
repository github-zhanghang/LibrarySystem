package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.library.dao.BookTypeDao;
import com.library.dao.CollectionDao;

/**
 * 删除收藏
 * 
 * @author 张航
 * 
 */
@WebServlet("/deleteCollectionServlet")
public class DeleteCollectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String collectionId = request.getParameter("collectionId");
		String account = request.getParameter("account");
		boolean result = new CollectionDao().deleteCollection(collectionId);
		if (result) {
			// 删除成功
			System.out.println("删除成功"+account);
			request.getSession().setAttribute("account", account);
			response.sendRedirect("/WisdomLibraryDemo/selectCollectionsServlet?account="+account);
		} else {
			// 删除失败
			System.out.println("删除失败");
			request.getSession().setAttribute("account", account);
			response.sendRedirect("/WisdomLibraryDemo/selectCollectionsServlet?account="+account);
		}
	}
}
