package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.domain.MenuTree;
import com.gxuwz.medical.sfy.domain.Role;
import com.gxuwz.medical.sfy.system.dao.MenuDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.gxuwz.medical.sfy.utils.Mark;
import com.mysql.jdbc.PreparedStatement;

public class MenuDaoImpl implements MenuDao {

	//查询权限树
	@Override
	public List<MenuTree> TreeShow() {
		//声明变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				ArrayList<MenuTree> am = new ArrayList<MenuTree>();
				String sql = null;
				try {
					conn = DBUtils.getConnection();
					//创建sql语句
					sql = "select * from t_menu";
					// 创建SQL命令对象
					ps = (PreparedStatement) conn.prepareStatement(sql);
					// 执行SQL命令
					rs = ps.executeQuery();
					//获取结果
					while(rs.next()) {
						MenuTree mt = new MenuTree(rs.getString(1),rs.getString(3),rs.getString(2),"right", false);
					    am.add(mt);
					}
				}catch(Exception e){
					e.printStackTrace();
				}//关闭连接
				finally {
					DBUtils.close(conn, ps, rs);
				}
				return am;
		
	}

	//根据RoleId查询权限菜单，查询role_menu表
	@Override
	public List<Menu> findMenuByRoleId(int roleId) {
		//声明变量
         Connection conn = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         ArrayList<Menu> am = new ArrayList<Menu>();
         String sql = null;
         try {
        	 conn = DBUtils.getConnection();
        	 sql = "select * from role_menu where role_id = ?";
        	// 创建SQL命令对象
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			// 执行SQL命令
			rs = ps.executeQuery();
			//遍历结果集
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("menu_id"));
				am.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return am;
	}

	//根据roleId修改role_menu关联表权限
	@Override
	public boolean updateRoleMenu(int roleId, String[] menuId) {
		//声明变量
				String dsql = "delete from role_menu WHERE role_id = ?";
				String isql = "insert into role_menu(role_id,menu_id) value(?,?)";
				int i = -1;
				i = DBUtils.executeDML(dsql, roleId);
				int j = -1;
				for(int m = 0;m<menuId.length;m++) {
					j = DBUtils.executeDML(isql, roleId,menuId[m]);
				}
				if(i!=-1&&j!=-1) {
					return true;
				}else {
					return false;
				}
	}

	//查询菜单列表
	@Override
	public List<Menu> getMenuList(String sql, Object[] params) {
		// 定义jdbc变量
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				Menu menu = null;

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

					List<Menu> list = new ArrayList<Menu>();
					while (rs.next()) {
						menu = new Menu();
						menu.setMenuId(rs.getInt("menu_id"));
						menu.setMenMenuId(rs.getInt("men_menu_id"));
						menu.setMenuName(rs.getString("menu_name"));
						menu.setMenuUrl(rs.getString("menu_url"));
						menu.setMenuMark(rs.getString("menu_mark"));
						list.add(menu);
					}

					return list;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
				}

				return null;
	}

	//修改菜单信息
	@Override
	public boolean updateMenu(Menu menu) {
		String sql = "update t_menu set menu_name=?,menu_url=? where menu_id=?";
		List<Object> list = new ArrayList<>();
		list.add(menu.getMenuName());
		list.add(menu.getMenuUrl());
		list.add(menu.getMenuId());
		return  DBUtils.saveOrUpdate(sql, list.toArray());
	}

	//假删除把menu_Mark的值改成0
	@Override
	public boolean deleteMenu(int menuId) {
		String sql = "update t_menu set menu_mark=? where menu_id=?";
		List<Object> list = new ArrayList<>();
		list.add(Mark.DB_NO);
		list.add(menuId);
		return  DBUtils.saveOrUpdate(sql, list.toArray());
	}

	//添加菜单信息
	@Override
	public boolean addMenu(Menu menu) {
		String sql = "insert into t_menu(men_menu_id,menu_name,menu_url,menu_mark) values(?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(menu.getMenMenuId());
		list.add(menu.getMenuName());
		list.add(menu.getMenuUrl());
		list.add(menu.getMenuMark());
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

}
