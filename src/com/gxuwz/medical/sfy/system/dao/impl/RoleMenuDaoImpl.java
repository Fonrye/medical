package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.Menu;
import com.gxuwz.medical.sfy.system.dao.RoleMenuDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.gxuwz.medical.sfy.utils.Mark;
import com.mysql.jdbc.PreparedStatement;

public class RoleMenuDaoImpl implements RoleMenuDao {

	//根据角色编号查询所属菜单信息
	@Override
	public List<Menu> getMenuList(Integer roleId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT *  FROM t_menu WHERE menu_id IN (SELECT menu_id FROM role_menu WHERE role_id=?) and menu_mark=?";
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			ps.setString(2, Mark.DB_YES);
		

			rs = ps.executeQuery();
			List<Menu> list = new ArrayList<Menu>();
			System.out.println("RoleMenuDao===========================:"+rs);
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenMenuId(rs.getInt("men_menu_id"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuUrl(rs.getString("menu_url"));
				menu.setMenuMark(rs.getString("menu_mark"));
				list.add(menu);
				
			}
			System.out.println("RoleMenuDao===========================1111:"+list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}

		return null;
	}

}
