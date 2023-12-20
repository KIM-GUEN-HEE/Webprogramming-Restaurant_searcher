<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.userDAO" %>
<%
   request.setCharacterEncoding("utf-8");

   String uid = request.getParameter("id");
   String uname = request.getParameter("name");
   String uphone = request.getParameter("phone");
   String uemail = request.getParameter("email");
   String ubirth = request.getParameter("birth");
   String pw = null;
   
   userDAO dao = new userDAO();
   pw = dao.findPW(uid,uname,uphone,uemail,ubirth);
   if (pw==null) {
      out.println("<script>alert('일치하는 정보가 없습니다.');</script>");
      out.println("<script>location.href='findID.html';</script>");
   }
   else {
      out.println("<script>alert('비밀번호는 "+ pw +" 입니다.');</script>");
      out.println("<script>location.href='intro.html';</script>");  
   }
%>