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

		boolean result = false;// 结果

		String type = request.getParameter("type");// 类型，0表示修改读者，1表示修改管理员
		String account = request.getParameter("account");// 账号
		String newName = request.getParameter("newName");// 新姓名
		String newPhone = request.getParameter("newPhone");// 新联系方式
		String newDuty = request.getParameter("newDuty");// 新职责
		if (account.equals("") || newName.equals("") || newPhone.equals("")) {
			// 提示不能为空
		} else {
			if (type.equals("1")) {
				result = new ManagerDao().updateManager(account, newName,
						newPhone, newDuty);
				if (result) {
					// 修改成功
					out.println("<script language='javaScript'> alert('修改成功，单击确定返回管理员列表！');</script>");
			   		response.setHeader("refresh","1;url=/WisdomLibraryDemo/selectManagersServlet");
				} else {
					// 修改失败
					out.println("<script language='javaScript'> alert('修改失败，单击确定返回管理员列表！');</script>");
			   		response.setHeader("refresh","1;url=/WisdomLibraryDemo/selectManagersServlet");
				}
			} else {
				result = new ReaderDao().updateReader(account, newName,
						newPhone);
				if (result) {
					// 修改成功
					out.println("<script language='javaScript'> alert('修改成功，单击确定返回用户列表！');</script>");
			   		response.setHeader("refresh","1;url=/WisdomLibraryDemo/selectAllReadersServlet");
				} else {
					// 修改失败
					out.println("<script language='javaScript'> alert('修改失败，单击确定返回用户列表！');</script>");
					response.setHeader("refresh","1;url=/WisdomLibraryDemo/selectAllReadersServlet");
				}
			}
		}
	}
}
