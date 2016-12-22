package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

/**
 * 删除用户
 * 
 * @author 张航
 * 
 */
@WebServlet("/deleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {

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

		String type = request.getParameter("type");// 类型，0表示删除读者，1表示删除管理员
		String account = request.getParameter("account");// 账号
		if (account.equals("")) {
			result = false;
		} else {
			if (type.equals("1")) {
				result = new ManagerDao().deleteManager(account);
				if (result) {
					message = "删除成功";
					//request.getSession().setAttribute("readers", list);
					response.sendRedirect("/WisdomLibraryDemo/selectManagersServlet");
				} else {
					if (type.equals("1")) {
						message = "删除失败，请检查参数是否正确";
					} else {
						message = "只有没有借阅记录的用户才可以删除";
					}
				}
			} else {
				result = new ReaderDao().deleteReader(account);
				if (result) {
					message = "删除成功";
					//request.getSession().setAttribute("readers", list);
					response.sendRedirect("/WisdomLibraryDemo/selectAllReadersServlet");
				} else {
					if (type.equals("1")) {
						message = "删除失败，请检查参数是否正确";
					} else {
						message = "只有没有借阅记录的用户才可以删除";
					}
				}
			}
		}
		
		/*jsonObject.put("result", result);
		jsonObject.put("message", message);

		out.write(jsonObject.toString());*/
	}
}
