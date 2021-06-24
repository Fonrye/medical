package com.gxuwz.medical.sfy.system.web.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.system.service.MenuService;
import com.gxuwz.medical.sfy.system.service.RoleService;
import com.gxuwz.medical.sfy.system.service.impl.MenuServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.RoleServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;

@WebServlet("/system/role")
public class RoleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	RoleService rs = new RoleServiceImpl();

	//添加角色和相应的权限
	public void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String roleName = request.getParameter("roleName");
		String[] menuId = request.getParameterValues("menuId");
		// System.out.println("menuId:"+menuId+"/////////////////////"+"roleName:"+roleName);
		Role role = new Role();
		role.setRoleName(roleName);

		boolean mark = rs.addRole(role);
		// 查询角色信息
		if (mark) {
			// 根据用户名查询用户信息
			List<Role> list = rs.getList(role);

			// System.out.println("roleId======11111=========="+list.get(0).getRoleId());
			// 从用户信息中获取用户ID，根据用户ID在关联表中添加页面传过来的menuID
			boolean mark1 = rs.addRoleMenu(list.get(0).getRoleId(), menuId);
		}

		request.setAttribute("url", "system/roleQuery");
		request.getRequestDispatcher("../tips.jsp").forward(request, response);

	}

	// 删除角色信息
	public void deleteRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Role role = new Role();
		// 获取需要删除的角色ID
		role.setRoleId(Integer.parseInt(request.getParameter("roleId")));

		boolean mark = rs.deleteRole(role);

		// 响应处理结果
		if (mark) {
			// 直接响应
			response.getWriter().write("true");
		} else {
			// 直接响应
			response.getWriter().write("false");
		}
	}
	
	//根据roleId修改角色信息
	public void updateRole(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		String roleName = request.getParameter("roleName");
		String [] menuId = request.getParameterValues("menuId");
		//修改角色表
		boolean mark = rs.updateRole(roleId,roleName);
		System.out.println("修改角色名称："+mark);
		//修改角色权限表role_menu
		MenuService ms = new MenuServiceImpl();
		boolean mark1 = ms.updateRoleMenu(roleId,menuId);
		System.out.println("修改role_menu表："+mark1);
		if(mark) {
			if(mark1) {
				request.setAttribute("url", "system/roleQuery");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
		}
	}
	
}
