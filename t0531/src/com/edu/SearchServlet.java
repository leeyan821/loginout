package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		ServletContext sc = this.getServletContext();
		Member member = (Member) sc.getAttribute("member");
		String id = (String)req.getParameter("id");
		
		if(member.getId().equals(id)) {
			out.print(member.getId()+"/"+member.getPwd()+"/"+member.getName()+"<p>");
		}else {
			out.print("no one<p>");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("go.jsp");
		rd.include(req, resp);
	}
}
