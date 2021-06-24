package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.User;

public interface UserDao {

	/**
	 * 查询用户信息
	 * @param sql
	 *      用户信息
	 * @param params
	 * @return
	 */
	List<User> getList(String sql, Object[] params);

	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * 根据用户账号查询用户ID
	 * @param string
	 * @param array
	 * @return
	 */
	List<User> getListUser(String sql, Object[] params);

	boolean addUserRole(Integer userId, int roleId);

	/**
	 * 假删除，把user_mark由1改成0
	 * @param puser
	 * @return
	 */
	boolean updateUser(User puser);

	/**
	 * 更新user表和UserRole表信息
	 * @param puser
	 * @return
	 */
	boolean updateUserAndUserRole(User user,int roleId);

}
