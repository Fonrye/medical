package com.gxuwz.medical.sfy.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.system.dao.RoleDao;
import com.gxuwz.medical.sfy.system.dao.impl.RoleDaoImpl;
import com.gxuwz.medical.sfy.system.service.RoleService;
import com.gxuwz.medical.sfy.utils.Mark;
import com.gxuwz.medical.sfy.utils.PageBean;

public class RoleServiceImpl implements RoleService {

	RoleDao rd = new RoleDaoImpl();
	//查询角色信息
	@Override
	public List<Role> getList(Role role) {
		StringBuffer sb = new StringBuffer(
				"select * from t_role where role_mark=?");
		List<Object> list = new ArrayList<Object>();
		list.add(Mark.DB_YES);
		if(role != null) {
			if(role.getRoleName() != null && !role.getRoleName().equals("")) {
				sb.append(" and role_name like ?");
				list.add("%" + role.getRoleName() + "%");
			}
		}
		//sb.append(" order by role_id desc ");
		
		return rd.getList(sb.toString(), list.toArray());
	}
	
	//添加角色
	@Override
	public boolean addRole(Role role) {
		if(role != null && role.getRoleName() != null){
			role.setRoleMark(Mark.DB_YES);
		}
		return rd.addRole(role);
	}

	//根据用户ID在关联表中添加menuID
	@Override
	public boolean addRoleMenu(Integer roleId, String[] menuId) {
		
		return rd.addRoleMenu(roleId,menuId);
	}

	//删除角色
	@Override
	public boolean deleteRole(Role role) {
		if (role != null && role.getRoleId() != null) {

			// 先查询 在修改
			Role prole = getRole(role.getRoleId());

			if (prole != null) {
				// 修改具体的字段,假删除
				prole.setRoleMark(Mark.DB_NO);
			}

			//假删除，修改role_mark的字段改成从1改成0
			return rd.updateRole(prole);
		}

		return false;
	}

	//根据ID查询角色信息
	private Role getRole(Integer roleId) {
		if (roleId != null) {
			StringBuffer sb = new StringBuffer(
					"select * from t_role where role_mark=?  and role_id = ?");
			List<Object> list = new ArrayList<Object>();
			list.add(Mark.DB_YES);
			list.add(roleId);

			List<Role> plist = rd.getList(sb.toString(), list.toArray());
			if (plist != null && plist.size() == 1) {

				return plist.get(0);
			}

		}

		return null;
	}

	//根据roleId修改角色信息
	@Override
	public boolean updateRole(int roleId, String roleName) {
		Role role = new Role();
		role.setRoleId(roleId);
		role.setRoleName(roleName);
		role.setRoleMark(Mark.DB_YES);
		return rd.updateRole(role);
	}
	

}
