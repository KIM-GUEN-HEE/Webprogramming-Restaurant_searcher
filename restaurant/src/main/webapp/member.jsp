<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.userDAO" %>
<%
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("id");
	String upass = request.getParameter("pw");
	String uname = request.getParameter("name");
	
	userDAO dao = new userDAO();
	if (dao.exists(uid)) {
		out.print("이미 가입한 회원입니다.");
		return;
	}
	
	if (dao.insert(uid, upass, uname)){
		session.setAttribute("id", uid);
		response.sendRedirect("main.jsp");
	}
	else{
		out.print("회원가입 중 오류가 발생하였습니다.");
	}

%>