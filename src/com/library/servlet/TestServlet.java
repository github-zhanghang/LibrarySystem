package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDetailDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		String text = request.getParameter("text");
		if (text == null || text.equals("")) {
			writer.write("null");
		} else {
			boolean isSuccess = new BookTypeDao().updateType("军事", text);
			writer.write("" + isSuccess);
		}
	}
}
