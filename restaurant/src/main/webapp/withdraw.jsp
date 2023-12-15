<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>
<%@ page import = "dao.userDAO" %>

<%
request.setCharacterEncoding("utf-8");

String uid = request.getParameter("id");
String upw = request.getParameter("pw");

userDAO mydao = new userDAO();
int code = mydao.login(uid,upw);
if(code == 1){
	out.println("<script>alert('아이디 또는 패스워드가 일치하지 않습니다.');</script>");
	out.println("<script>location.href='withdraw.html';</script>");
}
else if (code == 2){
	out.println("<script>alert('아이디 또는 패스워드가 일치하지 않습니다.');</script>");
	out.println("<script>location.href='withdraw.html';</script>");
}
else if(code==0)
{
	mydao.delete(uid);
	out.println("<script>alert('회원탈퇴가 완료 되었습니다.');</script>");
	out.println("<script>location.href='intro.html';</script>");
}
else
{
	out.println("<script>alert('회원탈퇴 중 오류가 발생했습니다.');</script>");
	out.println("<script>location.href='withdraw.html';</script>");
}
%>


