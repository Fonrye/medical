package com.gxuwz.medical.sfy.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.User;
import com.gxuwz.medical.sfy.system.dao.UserDao;
import com.gxuwz.medical.sfy.system.dao.impl.UserDaoImpl;
import com.gxuwz.medical.sfy.system.service.UserService;
import com.gxuwz.medical.sfy.utils.Mark;

public class UserServiceImpl implements UserService {

	private UserDao ud = new UserDaoImpl();
	
	//查询用户信息
	@Override
	public List<User> getList(User user) {
		//StringBuilder sql = new StringBuilder(" SELECT a.*,b.role_name FROM t_user a,t_role  b, user_role c WHERE a.role_id=b.role_id AND  a.user_mark=?");
		StringBuilder sql = new StringBuilder("SELECT a.*,b.role_name,b.role_id FROM t_user a,t_role b,user_role c WHERE a.user_id=c.user_id AND b.role_id=c.role_id AND a.user_mark=?");
		List<Object> list = new ArrayList<Object>();
		list.add(Mark.DB_YES);

		if (user != null) {

			if (user.getUserId() != null && !user.getUserId().equals("")) {
				sql.append(" and a.user_id=?");
				list.add(user.getUserId());
			}

			if (user.getUserNumber() != null
					&& !user.getUserNumber().equals("")) {
				sql.append(" and a.user_number=?");
				list.add(user.getUserNumber());
			}

			if (user.getUserName() != null && !user.getUserName().equals("")) {
				sql.append(" and a.user_name like  ?  ");
				list.add("%" + user.getUserName() + "%");
			}

			if (user.getUserPwd() != null && !user.getUserPwd().equals("")) {
				sql.append(" and a.user_pwd=? ");
				list.add(user.getUserPwd());
			}

		}

		System.out.println(sql);
		return ud.getList(sql.toString(), list.toArray());
	}
	
	// 添加用户信息
	@Override
	public boolean addUser(User user) {
		if(user != null && user.getUserNumber() != null && user.getUserPwd() != null){
			user.setUserMark(Mark.DB_YES);
			return ud.addUser(user);
		}
		return false;
	}

	//根据用户账号查询用户ID
	@Override
	public List<User> getUserId(User user) {
			StringBuffer sb = new StringBuffer("select * from t_user where user_mark=? and user_number=?");
			List<Object> list = new ArrayList<Object>();
			list.add(Mark.DB_YES);
			list.add(user.getUserNumber());
			return ud.getListUser(sb.toString(), list.toArray());
			
	}

	@Override
	public boolean addUserRole(Integer userId, int roleId) {
		
		return ud.addUserRole(userId,roleId);
	}

	//删除用户
	@Override
	public boolean deleteUser(User user) {
		if(user != null && user.getUserId() != null) {
			//先查询
			User puser = getUser(user.getUserId());
			if(puser != null) {
				// 修改具体的字段,假删除
				puser.setUserMark(Mark.DB_NO);
			}
			//假删除，修改role_mark的字段改成从1改成0
			return ud.updateUser(puser);
		}
		return false;
	}

	//根据ID查询用户信息
	private User getUser(Integer userId) {
		if (userId!= null) {
			StringBuffer sb = new StringBuffer(
					"select * from t_user where user_mark=?  and user_id = ?");
			List<Object> list = new ArrayList<Object>();
			list.add(Mark.DB_YES);
			list.add(userId);

			List<User> plist = ud.getListUser(sb.toString(), list.toArray());
			if (plist != null && plist.size() == 1) {

				return plist.get(0);
			}

		}

		return null;
	}

	//更新用户信息
	@Override
	public boolean updateUser(User user,int roleId) {
		
		return ud.updateUserAndUserRole(user,roleId);
			
	}

	
	

}
