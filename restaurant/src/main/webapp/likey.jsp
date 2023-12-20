<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.*" %>

<%
   // 좋아요 버튼이 눌린 경우에 처리할 코드
   String restaurantName = request.getParameter("serach"); // 혹은 다른 방식으로 검색 결과의 이름을 받아올 수 있음
	out.print(restaurantName);
   // 여기에서는 좋아요를 데이터베이스에 추가하는 코드를 가정하였습니다.
   // 실제로는 DAO 패턴 등을 사용하여 보안을 고려하여 구현해야 합니다.
 /*   boolean result = (new registerDao()).addLike(restaurantName);

   // 좋아요 추가 결과에 따라 메시지를 출력하거나 리다이렉트 등을 수행할 수 있습니다.
   if (result) {
      out.println("좋아요가 추가되었습니다.");
   } else {
      out.println("이미 좋아요가 추가된 식당입니다.");
   }
*/

%>
