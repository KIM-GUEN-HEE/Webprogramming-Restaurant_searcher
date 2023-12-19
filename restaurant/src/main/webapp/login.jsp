<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.userDAO" %>
<%
	request.setCharacterEncoding("utf-8");
	
	String uid = request.getParameter("id");
	String upass = request.getParameter("pw");
	String uname = request.getParameter("name");
	
	userDAO dao = new userDAO();
	int code = dao.login(uid,upass);
	if(code == 1){
		out.println("<script>alert('아이디 또는 패스워드가 일치하지 않습니다.');</script>");
		out.println("<script>location.href='intro.html';</script>");
	}
	else if (code == 2){
		out.println("<script>alert('아이디 또는 패스워드가 일치하지 않습니다.');</script>");
		out.println("<script>location.href='intro.html';</script>");
	}
	else {
		session.setAttribute("id", uid);
		session.setMaxInactiveInterval(600);
		response.sendRedirect("main.jsp");
	}
	
	
%>