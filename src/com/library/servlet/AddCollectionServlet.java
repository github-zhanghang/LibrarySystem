package com.library.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

import com.library.dao.BookDetailDao;
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
		PrintWriter out = response.getWriter();

		String readerAccount = request.getParameter("account");
		String bookName = request.getParameter("bookName");
		// 判断是否已收藏
		boolean isCollected = new CollectionDao().isCollected(readerAccount,
				bookName);
		if (isCollected) {
			// 原来已收藏该书
		} else {
			// 添加到收藏
			boolean result = new CollectionDao().addCollection(readerAccount,
					bookName);
			if (result) {
				// 收藏成功
				System.out.println("收藏成功");
				request.getSession().setAttribute("account", readerAccount);
				response.sendRedirect("/WisdomLibraryDemo/selectCollectionsServlet?account="+readerAccount);
				
			} else {
				request.getSession().setAttribute("account", readerAccount);
				response.sendRedirect("/WisdomLibraryDemo/selectBooksServlet_user?type=0"+"&account="+readerAccount);
			}
		}
	}
}
