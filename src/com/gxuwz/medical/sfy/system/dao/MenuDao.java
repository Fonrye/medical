package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.domain.MenuTree;

public interface MenuDao {

	/**
	 * 查询权限树
	 * @return
	 */
	List<MenuTree> TreeShow();

	/**
	 * 根据RoleId查询权限
	 * @param roleId
	 * @return
	 */
	List<Menu> findMenuByRoleId(int roleId);

	/**
	 * 根据roleId修改role_menu关联表权限
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	boolean updateRoleMenu(int roleId, String[] menuId);

	/**
	 * 查询菜单列表
	 * @param string
	 * @param array
	 * @return
	 */
	List<Menu> getMenuList(String sql, Object[] params);

	/**
	 * 修改菜单信息
	 * @param menu
	 * @return
	 */
	boolean updateMenu(Menu menu);

	/**
	 * 根据menuId删除menu信息
	 * @param menuId
	 *    假删除把menu_Mark的值改成0
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
