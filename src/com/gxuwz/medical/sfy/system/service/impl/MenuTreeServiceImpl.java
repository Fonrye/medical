package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.domain.MenuTree;
import com.gxuwz.medical.sfy.system.dao.MenuDao;
import com.gxuwz.medical.sfy.system.dao.impl.MenuDaoImpl;
import com.gxuwz.medical.sfy.system.service.MenuTreeService;

public class MenuTreeServiceImpl implements MenuTreeService {

	MenuDao md = new MenuDaoImpl();
	
	//查询权限树
	@Override
	public List<MenuTree> TreeShow() {
		
		return md.TreeShow();
	}
	
	//根据RoleId查询权限
	@Override
	public List<MenuTree> findMenuByRoleId(int roleId) {
		//查询所有权限
		List<MenuTree> lmt = md.TreeShow();
		//根据角色编号查询权限
		List<Menu> lm = md.findMenuByRoleId(roleId);
		if(lmt != null && lm != null) {
			for(int i = 0;i<lm.size();i++) {
				for(int j = 0;j<lmt.size();j++) {
					if(lm.get(i).getMenuId()==Integer.parseInt(lmt.get(j).getId())) {
						lmt.get(j).setChecked(true);
					}
				}
			}
		}
		return lmt;
	}

}
