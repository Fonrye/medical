package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.system.dao.RoleDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class RoleDaoImpl implements RoleDao {

	// 查询角色信息
	@Override
	public List<Role> getList(String sql, Object[] params) {
		// 定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Role role = null;

		try {
			// 创建连接
			conn = DBUtils.getConnection();
			// 创建sql对象
			ps = (PreparedStatement) conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {

					ps.setObject(i + 1, params[i]);
				}
			}
			// 执行sql命令
			rs = ps.executeQuery();

			List<Role> list = new ArrayList<Role>();
			while (rs.next()) {
				role = new Role();
				role.setRoleId(rs.getInt("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRoleMark(rs.getString("role_mark"));
				list.add(role);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}

		return null;
	}

	// 添加角色信息
	@Override
	public boolean addRole(Role role) {
		String sql = "insert into t_role(role_name,role_mark) values(?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(role.getRoleName());
		list.add(role.getRoleMark());

		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

	//根据用户ID在关联表中添加menuID
	@Override
	public boolean addRoleMenu(Integer roleId, String[] menuId) {
		// 定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		int i= 0;
		
		try {
			conn = DBUtils.getConnection();
			//关闭事务自动提交
			conn.setAutoCommit(false);
			String sql = "insert into role_menu(role_id,menu_id)value(?,?)";
			//创建sql执行对象
			for(int m = 0;m<menuId.length;m++) {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				ps.setInt(1, roleId);
				ps.setString(2, menuId[m]);
				i=ps.executeUpdate();
		}
			//提交事务
			conn.commit();
	}catch(Exception e) {
		e.printStackTrace();
		try {
			conn.rollback();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}finally {
		DBUtils.close(conn, ps);
	}
	if(i>0) {
		return true;
	}else {
		return false;
	}
}

	//修改角色信息
	@Override
	public boolean updateRole(Role role) {
		String sql = "update t_role set role_name=?,role_mark=? where role_id=? ";
		List<Object> list = new ArrayList<Object>();
		list.add(role.getRoleName());
		list.add(role.getRoleMark());
		list.add(role.getRoleId());
		
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

}
