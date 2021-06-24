package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Role;

public interface RoleDao {

	/**
	 * 查询角色信息
	 * @param sql
	 * @param params
	 * @return
	 */
	List<Role> getList(String sql, Object[] params);

	/**
	 * 添加角色信息
	 * @param role
	 * @return
	 */
	boolean addRole(Role role);

	/**
	 * 根据用户ID在关联表中添加menuID
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	boolean addRoleMenu(Integer roleId, String[] menuId);

	/**
	 * 修改角色信息
	 * @param prole
	 * @return
	 */
	boolean updateRole(Role prole);

}
