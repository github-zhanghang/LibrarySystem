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

@WebServlet("/addMemberServlet")
public class AddReaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject jsonObject = new JSONObject();
		boolean result = false;// 结果
		String message = "";
		String type = null, account = null, password = null, name = null, phone = null, duty = null;

		// 类型，0表示读者，1表示管理员，默认0
		type = request.getParameter("type");
		// 账号密码
		account = request.getParameter("account");
		password = request.getParameter("password");
		if (account.equals("") || password.equals("")) {
			result = false;
			message = "账号或密码不能为空";
		} else {
			// 姓名
			name = request.getParameter("name");
			if (name.equals("")) {
				result = false;
				message = "姓名不能为空";
			} else {
				// 联系方式
				phone = request.getParameter("phone");
				if (phone.equals("")) {
					result = false;
					message = "联系方式不能为空";
				} else {
					if (type.equals("1")) {
						// 职责
						duty = request.getParameter("duty");
						if (duty.equals("")) {
							result = false;
							message = "职责不能为空";
						}
					}
				}
			}
		}

		if (type.equals("1")) {
			result = new ManagerDao().addManager(account, password, name,
					phone, duty);
		} else {
			result = new ReaderDao().addReader(account, password, name, phone);
		}
		if (!result) {
			message = "添加失败";
		} else {
			message = "添加成功";
		}

		jsonObject.put("result", result);
		jsonObject.put("message", message);

		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
	}
}
