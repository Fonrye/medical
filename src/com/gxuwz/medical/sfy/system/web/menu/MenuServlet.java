package com.gxuwz.medical.sfy.system.web.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.domain.MenuTree;
import com.gxuwz.medical.sfy.system.service.MenuService;
import com.gxuwz.medical.sfy.system.service.MenuTreeService;
import com.gxuwz.medical.sfy.system.service.impl.MenuServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.MenuTreeServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.Mark;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/system/menu")
public class MenuServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	MenuService ms = new MenuServiceImpl();

	// 根据角色编号roleId查询权限，在jsp生成树
	public void findMenuByRoleId(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Role role = new Role();
		// role.setRoleId(Integer.parseInt(request.getParameter("roleId")));

		// 获取RoleId
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		// 处理请求
		MenuTreeService mts = new MenuTreeServiceImpl();
		List<MenuTree> lm = mts.findMenuByRoleId(roleId);
		response.getWriter().write(new Gson().toJson(lm));
	}

	// 查询菜单列表
	public void queryMenuList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面传过来的值
		String menuName = request.getParameter("menuName");
		Menu menu = new Menu();
		menu.setMenuName(menuName);
		// 查询菜单
		List<Menu> menuList = ms.getMenuList(menu);

		request.setAttribute("menuList", menuList);
		request.setAttribute("menu", menu);
		request.getRequestDispatcher(Mark.URL_SYSTEM_MENU + "menu_list.jsp").forward(request, response);
	}

	// 修改菜单
	public void updateMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面数据
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		String menuName = request.getParameter("menuName");
		String menuUrl = request.getParameter("menuUrl");
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);

		boolean mark = ms.updateMenu(menu);
		if (mark) {
			request.setAttribute("url", "system/menu?method=queryMenuList");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}

	// 删除菜单
	public void deleteMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面数据
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		boolean mark = ms.deleteMenu(menuId);
		// 响应处理结果
		if (mark) {
			// 直接响应
			response.getWriter().write("true");
		} else {
			// 直接响应
			response.getWriter().write("false");
		}
	}
	
	//在添加页面menu_add.jsp,加载菜单列表
	public void menuAddList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Menu menu = new Menu();
		// 查询菜单
		List<Menu> menuList = ms.getMenuList(menu);

		request.setAttribute("menuList", menuList);
		request.setAttribute("menu", menu);
		request.getRequestDispatcher(Mark.URL_SYSTEM_MENU + "menu_add.jsp").forward(request, response);
	}
	
	//添加菜单
	public void addMenu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		int menMenuId = Integer.parseInt(request.getParameter("menMenuId"));
		String menuName = request.getParameter("menuName");
		String menuUrl = request.getParameter("menuUrl");
		Menu menu = new Menu();
		menu.setMenMenuId(menMenuId);
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		//添加菜单信息
		boolean mark = ms.addMenu(menu);
		if(mark) {
			request.setAttribute("url", "system/menu?method=queryMenuList");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}

}
