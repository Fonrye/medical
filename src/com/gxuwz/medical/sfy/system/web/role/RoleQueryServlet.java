package com.gxuwz.medical.sfy.system.web.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.system.service.RoleService;
import com.gxuwz.medical.sfy.system.service.impl.RoleServiceImpl;
import com.gxuwz.medical.sfy.utils.Mark;


@WebServlet("/system/roleQuery")
public class RoleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		RoleService rs = new RoleServiceImpl();
		//获取页面传过来的值
		String roleName = request.getParameter("roleName");
		System.out.println("====================roleName:"+roleName);
		
		Role role = new Role();
		role.setRoleName(roleName);
		//查询角色信息
		List<Role> list = rs.getList(role);
		
		request.setAttribute("roleList", list);
		request.setAttribute("role", role);
		
		request.getRequestDispatcher(Mark.URL_SYSTEM_ROLE+"role_list.jsp")
		.forward(request, response);
	}
	

}
