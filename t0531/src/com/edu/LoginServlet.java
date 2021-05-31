package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.vo.Member;

public class LoginServlet extends HttpServlet{
	String id = "admin";
	String pwd = "12345";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uid = req.getParameter("id");
		String upwd = req.getParameter("pwd");
		
		PrintWriter out = resp.getWriter();
		
		if(id.equals(uid) && pwd.equals(upwd)) {
			RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			rd.forward(req, resp);
			return;
		}
		
		ServletContext sc = this.getServletContext();	
		Member member = (Member) sc.getAttribute("member");

		if(uid.equals(member.getId()) && upwd.equals(member.getPwd())) {
			req.setAttribute("id", id);
			Cookie m = new Cookie("id",id);
			out.println("3person");
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
