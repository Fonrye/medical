package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.system.dao.RoleMenuDao;
import com.gxuwz.medical.sfy.system.dao.impl.RoleMenuDaoImpl;
import com.gxuwz.medical.sfy.system.service.RoleMenuService;

public class RoleMenuServiceImpl implements RoleMenuService {

	RoleMenuDao rmd = new RoleMenuDaoImpl();
	
	//根据角色编号查询所属菜单信息
	@Override
	public List<Menu> getMenuList(Integer roleId) {
		
		return rmd.getMenuList(roleId);
	}

}
