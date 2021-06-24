package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;

public interface MenuService {

	/**
	 * 根据roleId修改role_menu关联表权限
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	boolean updateRoleMenu(int roleId, String[] menuId);

	/**
	 * 查询菜单列表
	 * @param menu
	 * @return
	 */
	List<Menu> getMenuList(Menu menu);

	/**
	 * 修改菜单信息
	 * @param menu
	 * @return
	 */
	boolean updateMenu(Menu menu);


	/**
	 * 删除菜单信息
	 * @param menu
	 * @return
	 */
	boolean deleteMenu(int menuId);

	/**
	 * 添加菜单信息
	 * @param menu
	 * @return
	 */
	boolean addMenu(Menu menu);
	


}
