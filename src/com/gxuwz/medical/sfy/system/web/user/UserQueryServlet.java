package com.gxuwz.medical.sfy.system.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.User;
import com.gxuwz.medical.sfy.system.service.UserService;
import com.gxuwz.medical.sfy.system.service.impl.UserServiceImpl;
import com.gxuwz.medical.sfy.utils.Mark;

@WebServlet("/system/userQuery")
public class UserQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		
		//获取响应数据
//    	String sindex = request.getParameter("index");
//    	int index = 1;
//		try {
//    		index = Integer.parseInt(sindex);
//    	}catch(NumberFormatException n) {
//    		n.printStackTrace();
//    	}
		// 查询条件
		String type = request.getParameter("type");
		String keywords = request.getParameter("keywords");
		User user = null;

		if (type != null && !type.equals("")) {
			user = new User();

			if ("userName".equals(type)) {
				user.setUserName(keywords);
			}

			if ("userNumber".equals(type)) {
				user.setUserNumber(keywords);
			}
		}

		// 业务逻辑
		UserService us = new UserServiceImpl();
		List<User> list = us.getList(user);
		request.setAttribute("userList", list);
		request.setAttribute("type", type);
		request.setAttribute("keywords", keywords);

		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_list.jsp").forward(request, response);
	}

}
