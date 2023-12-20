<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.userDAO" %>
<%
   request.setCharacterEncoding("utf-8");

   String uoldPass = request.getParameter("oldPass");
   String unewPass = request.getParameter("newPass");
   
   userDAO dao = new userDAO();
   if (dao.updatePW(uoldPass,unewPass)) {
      out.println("<script>alert('비밀번호가 변경되었습니다.');</script>");
      out.println("<script>location.href='intro.html';</script>");
   }
   else {
      out.println("<script>alert('일치하는 정보가 없습니다.');</script>");
      out.println("<script>location.href='changePW.html';</script>"); 
   }
%>