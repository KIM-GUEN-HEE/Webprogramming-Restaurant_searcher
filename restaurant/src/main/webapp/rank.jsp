<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MatPlace</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/forms@0.3.4/dist/forms.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
<style>
  body {
    background-color: #FCF0D2;
    font-family: 'Noto Sans KR', sans-serif;
  }
  .search-box::placeholder {
    color: rgba(107, 114, 128, 0.5); /* Adjust the color and opacity to make it appear translucent */
  }
  .menu-item:hover {
    background-color: #e2e8f0; /* Light blue background for hover state */
  }
  form {
	display: inline;
}
</style>
</head>
<body>
<div class="container mx-auto p-4">
  <div class="flex flex-col md:flex-row">
    <div class="w-full md:w-1/4 p-2">
		<a href="main.jsp"><img src="https://i.ibb.co/BzVjzRx/reallogo.png" alt="reallogo" border="0" width="150" height="150"></a>
      <br>
      
      임건형 님 환영합니다.
      <form method="post" action="logout.jsp">
       <button type="submit" id="logout" class="bg-gray-500 hover:bg-gray-500 text-white font-bold py-2 px-4 rounded">로그아웃</button>
      </form>
      <br><br>
      
      <div class="bg-white p-4 rounded-lg shadow-md">
        <ul class="space-y-3 mt-4">
          <li class="menu-item p-2 rounded-md"><a href="main.jsp" class="text-blue-600 hover:text-blue-800">맛집 검색</a></li>
          <li class="menu-item p-2 rounded-md"><a href="rank.jsp" class="text-blue-600 hover:text-blue-800">맛집 랭킹</a></li>
          <li class="menu-item p-2 rounded-md"><a href="registerjsp.jsp" class="text-blue-600 hover:text-blue-800">맛집 등록</a></li>
          <li class="menu-item p-2 rounded-md"><a href="#" class="text-blue-600 hover:text-blue-800">My 맛플</a></li>
          <li class="menu-item p-2 rounded-md"><a href="withdrawjsp.jsp" class="text-blue-600 hover:text-blue-800">회원 탈퇴</a></li>
        </ul>
      </div>
    </div>
    <div class="w-full md:w-1/2 p-2">
      <div class="bg-white p-4 rounded-lg shadow-md mb-4">
		  <form method="get" action="search.jsp">
        <input type="search" name="search" placeholder="맛플 검색" class="search-box form-input w-full rounded-md border-gray-300">
		  </form>
      </div>
      <div class="bg-white p-4 rounded-lg shadow-md">
			<h2 align = center style="font-size: 36pt" class="text-lg font-semibold mb-3">👑BEST맛집👑</h2>
        <div id="newRestaurants" class="space-y-3">
          <!-- Placeholder for new restaurant content -->
          <div class="h-20 bg-gray-100 rounded-md"></div>
          <div class="h-20 bg-gray-100 rounded-md"></div>
          <div class="h-20 bg-gray-100 rounded-md"></div>
        </div>
	  </div>
      </div>
      <div class="w-full md:w-1/4 p-2">
  		<div class="bg-white p-4 rounded-lg shadow-md mb-4">
    <h2 class="text-lg font-semibold mb-3">메뉴 추천!</h2>
    <button id="recommendButton" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">오늘의 메뉴는?</button>
    <div id="recommendation" class="mt-3 p-2 bg-gray-100 rounded-md"></div>
        </div>
      <div class="bg-white p-4 rounded-lg shadow-md">
        <h2 class="text-lg font-semibold mb-3">NEW! 맛집</h2>
        <div id="newRestaurants" class="space-y-3">
          <!-- Placeholder for new restaurant content -->
           <%
			ArrayList<matObj> recentlist = (new registerDao()).array(request.getParameter("search"));

			for (int i = 0; i < Math.min(recentlist.size(), 3); i++) {
    			matObj array = recentlist.get(i);
    			String str2 = array.getName();
			%>
    			<div>
        			<div align="center" class="h-20 bg-gray-100 rounded-md"><br><%= str2 %></div>
    			</div>
			<%
			}
			%>
        </div>
      </div>
    </div>
  </div>
</div>

 <script>
    const recommendations = ['볶음밥', '오므라이스', '순대', '김밥', '돈까스', '치킨', '회', '라멘', '초밥', '핫도그', '탕수육','짬뽕', '닭발', '곱창', '막창', '대창', '족발', '보쌈', '가츠동', '김치찜', '김치찌개', '찜닭', '된장찌개', '부대찌개', '쌀국수', '마라탕', '제육볶음', '고등어조림','햄버거','피자', '스테이크', '삼겹살', '소고기', '곱도리탕', '감자탕', '설렁탕', '곰탕', '파스타', '샐러드', '덮밥', '알밥', '누룽지탕', '짜장면','닭똥집', '떡볶이'];
    const recommendButton = document.getElementById('recommendButton');
    const recommendationBox = document.getElementById('recommendation');

    recommendButton.addEventListener('click', () => {
      const randomIndex = Math.floor(Math.random() * recommendations.length);
      recommendationBox.textContent = recommendations[randomIndex];
    });
  </script>
</body>
<footer>
    <p align="center">Copyright © 2023 KOREA_UNIVERSITY WEBPROJECT_11조</p>
    <br><br>
</footer>
</html>