package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.bean.BookDetailBean;
import com.library.dao.BookDetailDao;
import com.library.dao.BorrowDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

/**
 * 借书还书
 * 
 * @author 张航
 * 
 */
@WebServlet("/borrowAndReturnServlet")
public class BorrowAndReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 类型，0表示借书，1表示还书
		String type = request.getParameter("type");
		// 账号和书名
		String readerAccount = request.getParameter("account");
		String bookName = request.getParameter("bookName");
		if (type == null || type.equals("")) {
			type = "0";
		}

		if (type.equals("1")) {
			// 还书
			if (new BorrowDao().returnBook(readerAccount, bookName)) {
				// 还书成功
				System.out.println("还书成功");
			} else {
				// 还书失败
				System.out.println("还书失败");
			}
		} else {
			// 借书(可同时借阅多本书籍,书籍名称以 - 隔开)
			String[] books = bookName.split("-");
			List<String> bookList = new ArrayList<String>();
			for (int i = 0; i < books.length; i++) {
				// 判断该书籍库存是否>0
				BookDetailBean bookBean = new BookDetailDao()
						.getBookByName(books[i]);
				if (bookBean.getStockCount() - bookBean.getBorrowedCount() <= 0) {
					// 提示该书籍已全部借出
					System.out.println(bookBean.getBookName() + "已全部借出");
					return;
				}

				// 判断该书籍是否被借过并且有没有归还
				if (!new BorrowDao().isReturned(readerAccount, books[i])) {
					// 提示原来已借过此书籍并且尚未归还
					System.out.println("原来已借过此书籍并且尚未归还");
					return;
				} else {
					bookList.add(books[i]);
				}
			}
			if (new BorrowDao().borrowBooks(readerAccount, bookList)) {
				// 借书成功
				System.out.println("借书成功");
			} else {
				// 借书失败
				System.out.println("借书失败");
			}
		}
	}
}
