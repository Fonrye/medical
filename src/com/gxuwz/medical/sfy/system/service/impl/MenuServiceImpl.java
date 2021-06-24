package com.gxuwz.medical.sfy.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.system.dao.MenuDao;
import com.gxuwz.medical.sfy.system.dao.impl.MenuDaoImpl;
import com.gxuwz.medical.sfy.system.service.MenuService;
import com.gxuwz.medical.sfy.utils.Mark;

public class MenuServiceImpl implements MenuService {

	MenuDao md = new MenuDaoImpl();
	
	//根据roleId修改role_menu关联表权限
	@Override
	public boolean updateRoleMenu(int roleId, String[] menuId) {
		
		return md.updateRoleMenu(roleId,menuId);
	}

	//查询菜单列表
	@Override
	public List<Menu> getMenuList(Menu menu) {
		StringBuffer sb = new StringBuffer("select * from t_menu where menu_mark=?");
		List<Object> list = new ArrayList<Object>();
		list.add(Mark.DB_YES);
		//根据菜单名查询菜单
		if(menu != null) {
			if(menu.getMenuName() != null && !menu.getMenuName().equals("")) {
				sb.append(" and menu_name like ?");
				list.add("%" + menu.getMenuName() + "%");
			}
			
		}
		return md.getMenuList(sb.toString(),list.toArray());
	}

	//修改菜单信息
	@Override
	public boolean updateMenu(Menu menu) {
		
		return md.updateMenu(menu);
	}

	//删除菜单信息
	@Override
	public boolean deleteMenu(int menuId) {
		
		return md.deleteMenu(menuId);
	}

	//添加菜单信息
	@Override
	public boolean addMenu(Menu menu) {
		if(menu != null && menu.getMenMenuId() != null && menu.getMenuName() !=null && menu.getMenuUrl() != null) {
			menu.setMenuMark(Mark.DB_YES);
			return md.addMenu(menu);
		}
		return false;
	}

	

}
