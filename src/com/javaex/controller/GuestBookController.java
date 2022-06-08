package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestBookVo;


@WebServlet("/guestbook")
public class GuestBookController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println("guestbookController action: " + action);
		
		switch(action) {
			case "addList":
				GuestBookDao gbDao = new GuestBookDao();
				List<GuestBookVo> gList = gbDao.select();
				
				request.setAttribute("gList", gList);
				
				WebUtil.forward(request, response, "/WEB-INF/views/guestBook/addList.jsp");
				break;
				
			case "add":
				String name = request.getParameter("name");
				String pw = request.getParameter("pw");
				String content = request.getParameter("content");
				
				GuestBookVo visit = new GuestBookVo(name, pw, content);
				visit.setContent(visit.getContent().replace("\n", "<br>"));
				
				gbDao = new GuestBookDao();
				gbDao.add(visit);
				
				WebUtil.redirect(request, response, "/mysite2/guestbook?action=addList");
				break;
				
			case "deleteForm":
				int no = Integer.parseInt(request.getParameter("no"));
				request.setAttribute("no", no);

				WebUtil.forward(request, response, "/WEB-INF/views/guestBook/deleteForm.jsp");
				break;
				
			case "delete":
				no = Integer.parseInt(request.getParameter("no"));
				pw = request.getParameter("pw");
				System.out.println("no " + no + " pw " + pw);
				
				gbDao = new GuestBookDao();
				gbDao.delete(no, pw);
				
				WebUtil.redirect(request, response, "/mysite2/guestbook?action=addList");
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
