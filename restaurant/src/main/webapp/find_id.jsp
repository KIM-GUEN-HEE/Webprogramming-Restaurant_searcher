<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.userDAO" %>


<%
   request.setCharacterEncoding("utf-8");

   String uname = request.getParameter("name");
   String uphone = request.getParameter("phone");
   String uemail = request.getParameter("email");
   String ubirth = request.getParameter("birthday");
   String id = null;
   
   userDAO dao = new userDAO();
   id = dao.findID(uname,uphone,uemail,ubirth);
   if (id==null) {
      out.println("<script>alert('일치하는 정보가 없습니다.');</script>");
      out.println("<script>location.href='findID.html';</script>");
   }
   else {
	   out.println("<script>alert('아이디는"+ id +"입니다.');</script>");
	   out.println("<script>location.href='intro.html';</script>");
      
   }
%>
