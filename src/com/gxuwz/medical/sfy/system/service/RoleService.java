package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.domain.User;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface RoleService {

	/**
	 * 查询角色信息
	 * @param role
	 * @return
	 */
	List<Role> getList(Role role);

	/**
	 * 添加角色
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
	 * 删除角色
	 * @param role
	 * @return
	 */
	boolean deleteRole(Role role);

	/**
	 * 修过角色信息
	 * @param roleId
	 * @param roleName
	 * @return
	 */
	boolean updateRole(int roleId, String roleName);

	

	

}
