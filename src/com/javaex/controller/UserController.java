package com.javaex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		System.out.println("UserController" + " action:" + action);

		switch(action) {
			case "joinForm":
				WebUtil.forward(request, response, "/WEB-INF/views/user/joinForm.jsp");
				break;
			
			case "join":
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				
				UserVo user = new UserVo(id, pw, name, gender);
				
				UserDao uDao = new UserDao();
				uDao.join(user);
				WebUtil.forward(request, response, "/WEB-INF/views/user/joinOk.jsp");
				
				break;
				
			case "loginForm":
				WebUtil.forward(request, response, "/WEB-INF/views/user/loginForm.jsp");
				break;
				
			case "login":
				id = request.getParameter("id");
				pw = request.getParameter("pw");
				
				UserVo uVo = new UserVo(id, pw);
				uDao = new UserDao();
				UserVo userA = uDao.getUser(uVo);
												
				if (userA == null) {
					System.out.println("[로그인 실패]");
				}
				else {
					System.out.println("[로그인 성공]");
					
					session.setAttribute("user", userA);
				}
				WebUtil.redirect(request, response, "/mysite2/main");
				break;
				
			case "logout":
				session.removeAttribute("user");
				session.invalidate();
				WebUtil.redirect(request, response, "/mysite2/main");
				break;
				
			case "modifyForm":
				session = request.getSession();
				user = (UserVo)session.getAttribute("user");
				
				uDao = new UserDao();
				userA = uDao.getUser(user.getId());
				
				session.setAttribute("user", new UserVo(userA.getNo(), userA.getId(), userA.getName()));
				WebUtil.forward(request, response, "/WEB-INF/views/user/modifyForm.jsp");
				break;
				
			case "modify":
				session = request.getSession();
				user = (UserVo)session.getAttribute("user");
				id = user.getId();
				int no = user.getNo();
				
				pw = request.getParameter("pw");
				name = request.getParameter("name");
				gender = request.getParameter("gender");
				uVo = new UserVo(id, pw, name, gender);
								
				uDao = new UserDao();
				uDao.modify(uVo);
				
				session.setAttribute("user", new UserVo(no, id, name));
				WebUtil.redirect(request, response, "/mysite2/main");
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
