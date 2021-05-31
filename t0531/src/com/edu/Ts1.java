package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vo.Member;

@WebServlet("/test")
public class Ts1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		ServletContext sc = this.getServletContext();
		Member member = (Member) sc.getAttribute("member");
		
		out.print(member.getId()+": "+member.getPwd()+": "+member.getName());
		out.close();
	}
}
