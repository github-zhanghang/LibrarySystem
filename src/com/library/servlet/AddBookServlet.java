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

		String bookName = request.getParameter("name");// 书名
		String bookAuthor = request.getParameter("author");// 作者
		String bookType = request.getParameter("type");// 类型
		String bookAddress = request.getParameter("address");// 位置
		String bookCount = request.getParameter("count");// 数量
		String imageUrl = null;// 图片地址
		String bookPress = request.getParameter("press");// 出版社

		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		String path = request.getRealPath("/images");
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();
				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					// 获取用户具体输入的字符串
					String value = item.getString("utf-8");
					if (name.equals("name")) {
						bookName = value;
					} else if (name.equals("author")) {
						bookAuthor = value;
					} else if (name.equals("type")) {
						bookType = value;
					} else if (name.equals("address")) {
						bookAddress = value;
					} else if (name.equals("count")) {
						bookCount = value;
					} else if (name.equals("press")) {
						bookPress = value;
					}
					
				} else {
					// 获取路径名
					String value = item.getName();
					// 索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start + 1);
					if (filename.endsWith(".jpg") || filename.endsWith(".png")) {
						// 真正写到磁盘上
						item.write(new File(path, filename));
						imageUrl = "http://localhost:8080"
								+ request.getContextPath() + "/images/"
								+ filename;
						boolean result = new BookDetailDao().addBook(bookName,
								bookAuthor, bookType, bookAddress,
								Integer.parseInt(bookCount), imageUrl,
								bookPress);
						if (result) {
							out.println("<script language='javaScript'> alert('添加成功');</script>");
							response.setHeader("refresh",
									"1;url=/WisdomLibraryDemo/selectBooksServlet?type=0");
						} else {
							out.println("<script language='javaScript'> alert('添加失败);</script>");
							response.setHeader("refresh",
									"1;url=/WisdomLibraryDemo/web/adminfd/addbooks.jsp");
						}
					} else {
						// 上传的图片不合法
						out.println("<script language='javaScript'> alert('添加失败,必须上传图片');</script>");
						response.setHeader("refresh",
								"1;url=/WisdomLibraryDemo/web/adminfd/addbooks.jsp");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
