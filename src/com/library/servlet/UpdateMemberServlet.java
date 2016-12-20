package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDetailDao;
import com.library.dao.ManagerDao;
import com.library.dao.ReaderDao;

import net.sf.json.JSONObject;

/**
 * 修改用户信息
 * 
 * @author 张航
 * 
 */
@WebServlet("/updateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {

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

		String type = request.getParameter("type");// 类型，0表示修改读者，1表示修改管理员
		String account = request.getParameter("account");// 原书名
		String newPassword = request.getParameter("newPassword");// 新密码
		String newName = request.getParameter("newName");// 新姓名
		String newPhone = request.getParameter("newPhone");// 新联系方式
		String newDuty = request.getParameter("newDuty");// 新职责
		if (account.equals("") || newPassword.equals("") || newName.equals("")
				|| newPhone.equals("")) {
			result = false;
		} else {
			if (type.equals("1")) {
				result = new ManagerDao().updateManager(account, newPassword,
						newName, newPhone, newDuty);
				jsonObject.put("data",
						new ManagerDao().getManagerByAccount(account));
			} else {
				result = new ReaderDao().updateReader(account, newPassword,
						newName, newPhone);
				jsonObject.put("data",
						new ReaderDao().getReaderByAccount(account));
			}
		}
		if (result) {
			message = "修改成功";
		} else {
			message = "修改失败，请检查参数是否正确成功";
		}
		jsonObject.put("result", result);
		jsonObject.put("message", message);

		out.write(jsonObject.toString());
	}
}
