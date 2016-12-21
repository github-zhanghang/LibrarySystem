package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.library.dao.BookDetailDao;

/**
 * 添加书籍
 * 
 * @author 张航
 * 
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		JSONObject jsonObject = new JSONObject();
		boolean result = false;// 结果
		String message = "";

		String bookName = request.getParameter("name");// 书名
		String bookAuthor = request.getParameter("author");// 作者
		String bookType = request.getParameter("type");// 类型
		String bookAddress = request.getParameter("address");// 位置
		String bookCount = request.getParameter("count");// 数量
		String imageUrl = request.getParameter("image");// 图片地址
		String bookPress = request.getParameter("press");// 出版社
		if (bookName.equals("") || bookAuthor.equals("") || bookType.equals("")
				|| bookAddress.equals("") || bookCount.equals("")
				|| bookPress.equals("")) {
			result = false;
		} else {
			int count = Integer.parseInt(bookCount);
			result = new BookDetailDao().addBook(bookName, bookAuthor,
					bookType, bookAddress, count, imageUrl, bookPress);
		}
		if (result) {
			message = "添加成功";
		} else {
			message = "添加失败，请检查参数是否正确成功";
		}
		jsonObject.put("result", result);
		jsonObject.put("message", message);

		out.write(jsonObject.toString());
	}
}
