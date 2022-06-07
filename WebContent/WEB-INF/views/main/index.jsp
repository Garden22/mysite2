<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.javaex.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySite</title>
<link href="/mysite2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite2/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
		
		<div id="container" class="clearfix">
			<!-- aside 없음 -->
			<div id="full-content">
			
				<!-- content-head 없음 -->
				<div id="index"> 
				
					<img id="profile-img" src="/mysite2/assets/image/profile.jpg">
					
					<div id="greetings">
						<p class="text-xlarge">
							<span class="bold">안녕하세요!!<br>
							정우성의 MySite에 오신 것을 환영합니다.<br>
							<br>
							이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br>
							</span>
							<br>
							사이트 소개, 회원가입, 방명록, 게시판으로 구성되어 있으며<br>
							'jsp+servlet'(모델2) 방식으로 제작되었습니다.<br>
							<br>
							자바 수업 + 데이터베이스 수업 + 웹프로그래밍 수업<br>
							<br>
							<br><br>
							<a class="" href="/mysite2/guestbook?action=addList">[방명록에 글 남기기]</a>
						</p>	
					</div>
					<!-- //greetings -->
				
					<div class="clear"></div>
					
				</div>
				<!-- //index -->
				
			</div>
			<!-- //full-content -->
			
		</div>
		<!-- //container -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
	<!-- //wrap -->
</body>
</html>