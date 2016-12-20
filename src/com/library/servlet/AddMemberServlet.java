package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 添加用户
 * 
 * @author 张航
 * 
 */
@WebServlet("/addMemberServlet")
public class AddMemberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;// 结果

		// 类型，0表示读者，1表示管理员
		String type = request.getParameter("type");
		// 账号密码
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		// 姓名
		String name = request.getParameter("name");
		// 联系方式
		String phone = request.getParameter("phone");
		// 职责
		String duty = request.getParameter("duty");

		if (account.equals("") || password.equals("")) {
			result = false;
			// "账号或密码不能为空";
			return;
		}
		if (name.equals("")) {
			result = false;
			// "姓名不能为空";
			return;
		}
		if (phone.equals("")) {
			result = false;
			// "联系方式不能为空";
			return;
		}
		if (type.equals("1")) {
			if (duty.equals("")) {
				result = false;
				// "职责不能为空";
				return;
			}
		}
		PrintWriter out = response.getWriter();
		if (type.equals("1")) {
			result = new ManagerDao().addManager(account, password, name,
					phone, duty);
			if (!result) {
				out.println("<script language='javaScript'> alert('添加失败，单击确定返回添加页面！');</script>");
				response.setHeader("refresh",
						"1;url=/WisdomLibraryDemo/web/adminfd/adminlist.jsp");
			} else {
				out.println("<script language='javaScript'> alert('添加成功，单击确定返回管理员列表！');</script>");
				response.setHeader("refresh",
						"1;url=/WisdomLibraryDemo/web/adminfd/adminlist.jsp");
			}
		} else {
			result = new ReaderDao().addReader(account, password, name, phone);
			if (!result) {
				out.println("<script language='javaScript'> alert('添加失败，单击确定返回添加页面！');</script>");
				response.setHeader("refresh",
						"1;url=/WisdomLibraryDemo/web/adminfd/adminlist.jsp");
			} else {
				out.println("<script language='javaScript'> alert('添加成功，单击确定返回用户列表！');</script>");
				response.setHeader("refresh",
						"1;url=/WisdomLibraryDemo/web/adminfd/userlist.jsp");
			}
		}
	}
}
