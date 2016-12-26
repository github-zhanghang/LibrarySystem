package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.CollectionBean;
import com.library.dao.CollectionDao;

/**
 * 查询收藏记录
 * 
 * @author 张航
 * 
 */
@WebServlet("/selectCollectionsServlet")
public class SelectCollectionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String readerAccount = request.getParameter("account");
		List<CollectionBean> collectionList = new CollectionDao()
				.getCollectionRecord(readerAccount);
		request.getSession().setAttribute("collections", collectionList);
		request.getSession().setAttribute("account", readerAccount);
		response.sendRedirect("web/userfd/collectioninfo.jsp");
	}
}
