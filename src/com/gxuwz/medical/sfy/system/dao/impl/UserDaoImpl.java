package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.domain.User;
import com.gxuwz.medical.sfy.system.dao.UserDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao {

	//用户信息查询
	@Override
	public List<User> getList(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {

					ps.setObject(i + 1, params[i]);
				}
			}

			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();

				user.setUserId(rs.getInt("user_id"));
				user.setUserNumber(rs.getString("user_number"));
				user.setUserPwd(rs.getString("user_pwd"));
				user.setUserName(rs.getString("user_name"));
				user.setUserMark(rs.getString("user_mark"));
				user.setRoleName(rs.getString("role_name"));
				user.setRoleId(rs.getInt("role_id"));

				list.add(user);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}

		return null;
	}

	
	//添加用户信息
	@Override
	public boolean addUser(User user) {
		String sql = "insert into t_user(user_name,user_number,user_pwd,user_mark) values(?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(user.getUserName());
		list.add(user.getUserNumber());
		list.add(user.getUserPwd());
		list.add(user.getUserMark());
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}


	//根据用户账号查询用户ID
	@Override
	public List<User> getListUser(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {

					ps.setObject(i + 1, params[i]);
				}
			}

			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();

				user.setUserId(rs.getInt("user_id"));
				user.setUserNumber(rs.getString("user_number"));
				user.setUserPwd(rs.getString("user_pwd"));
				user.setUserName(rs.getString("user_name"));
				user.setUserMark(rs.getString("user_mark"));

				list.add(user);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}

		return null;
	}


	@Override
	public boolean addUserRole(Integer userId, int roleId) {
		String sql = "insert into user_role(user_id,role_id) values(?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(userId);
		list.add(roleId);
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}


	//修改用户信息
	@Override
	public boolean updateUser(User user) {
		String sql = "update t_user set user_mark=? where user_id=?";
		List<Object> list = new ArrayList<>();
		list.add(user.getUserMark());
		list.add(user.getUserId());
		
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}


	//更新user表和UserRole表信息
	@Override
	public boolean updateUserAndUserRole(User user,int roleId) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		int i = 0;
		int j= 0;
		try {
			//创建连接
			conn = DBUtils.getConnection();
			//创建sql对象
			String sql = "update t_user set user_name=?,user_pwd=? where user_id=?";
			String rsql = "update user_role r set r.role_id=? where r.user_id=?";
			//关闭自动提交事务
			conn.setAutoCommit(false);
			//创建SQL执行对象
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps1 = (PreparedStatement) conn.prepareStatement(rsql);
			//对占位符赋值
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			ps.setInt(3, user.getUserId());
			ps1.setInt(1, roleId);
			ps1.setInt(2, user.getUserId());
			//执行sql
			i = ps.executeUpdate();
			j = ps1.executeUpdate();
			//提交事务
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				//失败就回滚
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			DBUtils.close(conn, ps);
			DBUtils.close(conn, ps1);
			try {
				ps1.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		//执行成功返回true
		if(i>0&&j>0) {
			return true;
		}else {
			return false;
	}
}
}
