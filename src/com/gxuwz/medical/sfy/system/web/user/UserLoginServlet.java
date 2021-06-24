package com.gxuwz.medical.sfy.system.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.domain.User;
import com.gxuwz.medical.sfy.system.service.RoleMenuService;
import com.gxuwz.medical.sfy.system.service.UserService;
import com.gxuwz.medical.sfy.system.service.impl.RoleMenuServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.UserServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.Mark;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(name = "userlogin", urlPatterns = "/userlogin")
public class UserLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	// 创建业务层对象
	UserService us = new UserServiceImpl();

	// 登录方法
	public void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取页面的数据
		String userNumber = req.getParameter("userNumber");
		String userPwd = req.getParameter("userPwd");
		User user = new User();
		user.setUserNumber(userNumber);
		user.setUserPwd(userPwd);
		String path = "/login.jsp";
		HttpSession session = req.getSession();
		if (user != null && user.getUserNumber() != null && !"".equals(user.getUserNumber())
				&& user.getUserPwd() != null && !"".equals(user.getUserPwd())) {
			// 查询登录用户的信息
			List<User> list = us.getList(user);
			if (list != null && list.size() == 1) {
				User user1 = list.get(0);

				path = "/main.jsp";
				
				session.setAttribute(Mark.LOGIN_SESSION_USER, user1);
				System.out.println("登录成功===============");
				System.out.println("roleId:"+user1.getRoleId());
				
				//根据角色编号查询所属菜单信息
				RoleMenuService rms = new RoleMenuServiceImpl();
				List<Menu> menulist = rms.getMenuList(user1.getRoleId());
				session.setAttribute("loginmenulist", menulist);
				

			} else {
				session.setAttribute("flag", "loginFalse1");
			}
		} else {
			session.setAttribute("flag", "loginFalse2");
		}
		// 转发
		req.getRequestDispatcher(path).forward(req, resp);
	}

	// 退出处理方法
	public void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("----------退出处理方法");
		// 获取请求信息
		HttpSession session = req.getSession();
		// 销毁session
		session.invalidate();
		System.out.println("退出登录====================");
		// 响应处理结果
		// 重定向
		resp.sendRedirect("/medical/login.jsp");
	}

}
