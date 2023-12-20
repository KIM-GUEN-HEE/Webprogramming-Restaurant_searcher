<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.userDAO" %>
<%@ page import = "dao.likeDAO" %>

<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	
	String uid = (String)session.getAttribute("id");

	
	likeDAO dao = new likeDAO();
	
	if(dao.likecheck(name,uid)){
		out.print("delete");
		dao.delete(name, uid);
		
	}
	else{
		dao.insert(name,uid);
		out.print("insert");
	}
	
%>