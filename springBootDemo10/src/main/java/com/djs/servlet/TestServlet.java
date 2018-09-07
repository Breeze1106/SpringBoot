package com.djs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test2")
public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置返回类型为json
		response.setContentType("application/json");
		//设置返回字符集
		response.setCharacterEncoding("UTF-8");
		//输出对象
		PrintWriter out = response.getWriter();
		//输出error消息
		out.print("执行TestServlet内doPost方法成功");
		out.close();
	}

}
