package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookAddressBean;
import com.library.bean.BookDetailBean;
import com.library.dao.BookAddressDao;
import com.library.dao.BookDetailDao;
import com.library.dao.BorrowDao;

/**
 * @author 张航
 * 
 */
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

		String text = request.getParameter("text1");
		if (text == null || text.equals("")) {
			writer.write("null");
		} else {
			List<BookDetailBean> detailBeanList = new BookDetailDao()
					.getBooksByType(text, 1);
			if (detailBeanList.size() == 0) {
				writer.write("未查到此类书籍");
				return;
			}
			for (int i = 0; i < detailBeanList.size(); i++) {
				writer.write(detailBeanList.get(i).toString());
			}
		}
	}
}
