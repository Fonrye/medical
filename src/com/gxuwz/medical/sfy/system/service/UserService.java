package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.User;

public interface UserService {

	/**
	 *查询用户信息
	 * @param user
	 * @return
	 */
	List<User> getList(User user);

	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * 根据用户账号查询用户ID
	 * @param userNumber
	 * @return
	 */
	List<User> getUserId(User user);

	boolean addUserRole(Integer userId, int roleId);

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	boolean deleteUser(User user);

	/**
	 * 更新用户信息
	 * @param user
	 * @param roleId 
	 * @return
	 */
	boolean updateUser(User user, int roleId);

}
