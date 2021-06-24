package com.gxuwz.medical.sfy.system.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.domain.User;
import com.gxuwz.medical.sfy.system.service.RoleService;
import com.gxuwz.medical.sfy.system.service.UserService;
import com.gxuwz.medical.sfy.system.service.impl.RoleServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.UserServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.Mark;

@WebServlet("/system/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 用户信息管理的业务逻辑
	UserService us = new UserServiceImpl();
	// 角色信息管理的业务逻辑处理类
	RoleService rs = new RoleServiceImpl();

	// 在用户添加页面，查询角色信息显示在页面
	public void queryUserRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Role> list = rs.getList(null);

		request.setAttribute("roleList", list);

		request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_add.jsp").forward(request, response);
	}

	// 验证用户账号是否存在
	public void checkUserNumber(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进了checkUserNumber方法了！！！！！！！！！！！！！！！！！！！！");
		String userNumber = request.getParameter("usernumber");
		System.out.println("===============11111==========================" + userNumber);
		User user = new User();
		user.setUserNumber(userNumber);
		// 查询用户信息
		List<User> list = us.getList(user);
		// 响应处理结果
		if (list != null && list.size() == 1) {
			response.getWriter().write("true");
		} else {
			response.getWriter().write("false");
		}
	}
	
	// 添加用户信息
		public void addUser(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String userName = request.getParameter("username");
			String userNumber = request.getParameter("usernumber");
			String userPwd = request.getParameter("password");
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			User user = new User();
			user.setUserName(userName);
			user.setUserNumber(userNumber);
			user.setUserPwd(userPwd);
			user.setRoleId(roleId);
			//添加用户信息
			boolean mark = us.addUser(user);
			if(mark) {
				//根据用户账号查询用户ID
				List<User> list = us.getUserId(user);
				//System.out.println("userId===============121212====================="+list.get(0).getUserId());
				boolean mark1 = us.addUserRole(list.get(0).getUserId(),roleId);
			}
			request.setAttribute("url", "system/userQuery");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
			
		}

		//删除用户信息
		public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
			User user = new User();
			//获取用户ID
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			
			boolean mark = us.deleteUser(user);
			// 响应处理结果
			if (mark) {
				// 直接响应
				response.getWriter().write("true");
			} else {
				// 直接响应
				response.getWriter().write("false");
			}
		}
		
		//查询要修改的用信息，在页面显示
		public void queryUpdateUser(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException{
			//获取要修改的用户ID
			User user = new User ();
			user.setUserId(Integer.parseInt(request.getParameter("userId")));
			
			List<User> ulist = us.getList(user);
			if (ulist != null && ulist.size() == 1) {
				request.setAttribute("user", ulist.get(0));
			}
			List<Role> list = rs.getList(null);

			request.setAttribute("listRole", list);
			
			request.getRequestDispatcher(Mark.URL_SYSTEM_USER + "user_edit.jsp")
			.forward(request, response);
		}
		
		//修改用户信息
		public void updateUser(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String userName = request.getParameter("username");
			String userPwd = request.getParameter("password");
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			User user = new User();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setUserPwd(userPwd);
			//user.setRoleId(roleId);
			boolean mark = us.updateUser(user,roleId);
			if(mark) {
				request.setAttribute("url", "system/userQuery");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
		}
}
