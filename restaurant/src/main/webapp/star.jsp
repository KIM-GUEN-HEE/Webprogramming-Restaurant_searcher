<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.userDAO" %>
<%@ page import = "dao.starDAO" %>

<%
   request.setCharacterEncoding("utf-8");
   
   String name = request.getParameter("name");
   
   String uid = (String)session.getAttribute("id");

   
   starDAO dao = new starDAO();
   
   if(dao.starcheck(name,uid)){
      dao.delete(name, uid);
   }
   else{
      dao.insert(name,uid);
   }
   
%>