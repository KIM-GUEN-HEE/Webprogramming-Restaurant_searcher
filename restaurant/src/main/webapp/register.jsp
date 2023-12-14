<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.registerDao" %>
<%
	request.setCharacterEncoding("utf-8");

	String matname = request.getParameter("name");
	String matcategory = request.getParameter("category");
	String matlocation = request.getParameter("location");
	String pricerange = request.getParameter("pricerange");
	
	registerDao dao = new registerDao();
	if (dao.exists(matname)) {
		out.print("이미 등록된 가게입니다.");
		return;
	}
	
	if (dao.insert(matname, matcategory, matlocation, pricerange)){
		
		response.sendRedirect("main.html");
	}
	else{
		out.print("등록 중 오류가 생겼습니다.");
	}

%>