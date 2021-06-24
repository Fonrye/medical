package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.MenuTree;

public interface MenuTreeService {

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
	List<MenuTree> findMenuByRoleId(int roleId);

}
