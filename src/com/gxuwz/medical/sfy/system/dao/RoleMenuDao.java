package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;

public interface RoleMenuDao {

	/**
	 * 根据角色编号查询所属菜单信息
	 * @param roleId
	 * @return
	 */
	List<Menu> getMenuList(Integer roleId);

}
