package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.system.dao.AreaDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class AreaDaoImpl implements AreaDao {

	//查询行政区域总数
	@Override
	public int findAreaSize() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from t_area";
		int i = 0;
		try {
			//调用查询方法
			rs = DBUtils.query(sql);
			if(rs.next()) {
				i = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return i;
	}

	//分页查询，start是开始的页数，size是一页行有多少数据
	@Override
	public List<Area> findAreaIndex(int start, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Area> la = new ArrayList<>();
		String sql = null;
		try {
			// 创建Sql语句
			sql = "select * from t_area limit ?,?";
			// 执行sql语句
			rs =DBUtils.query(sql, start,size);
			// 获取结果
			while (rs.next()) {
				Area a = new Area(rs.getString(1), rs.getString(2), rs.getInt(3));
				la.add(a);
			}
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn, ps, rs);
			}
			// 关闭连接
			return la;
	}

	@Override
	public List<Area> findAllArea() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Area> la = new ArrayList<>();
		String sql = null;
		try {
			// 创建Sql语句
			sql = "select * from t_area ";
			// 执行sql语句
			rs = DBUtils.query(sql);
			while (rs.next()) {
				Area a = new Area(rs.getString(1), rs.getString(2), rs.getInt(3));
				la.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return la;
	}

	//查询该行政区域是否存在下级行政区域
	@Override
	public String findNextArea(String oldareaCode, int grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		String areaCode = null;
		try {
			// 创建Sql语句
			sql = "select * from t_area where area_code like concat(?,'%') and grade=? ORDER BY area_code desc limit 1";
			// 执行sql语句
			rs =DBUtils.query(sql, oldareaCode,grade);
			while (rs.next()) {
				areaCode = rs.getString("area_code");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return areaCode;
	}

	@Override
	public boolean saveArea(String areacode, int grade, String newareaName) {
		
		//声明变量
		String sql = "insert into t_area(area_code,area_name,grade) value(?,?,?)";
		int i = DBUtils.executeDML(sql, areacode,newareaName,grade);
		if(i!=-1) {
			return true;
		}else {
			return false;
		}
	}

	//删除行政区域
	@Override
	public boolean deleteArea(String areaCode,int grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			 StringBuffer sqlBuff=new StringBuffer("delete from t_area where area_code like '"+areaCode+"%' and grade>=?");
			 ps=(PreparedStatement) conn.prepareStatement(sqlBuff.toString());
			 ps.setInt(1, grade);
			 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, ps);
		}
		return true;
	}

	//根据areaId查询行政区域
	@Override
	public List<Area> findAllAreaById(String areaCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Area> la = new ArrayList<>();
		String sql = null;
		try {
			sql = "select * from t_area where area_code = ?";
			rs = DBUtils.query(sql, areaCode);
			while(rs.next()) {
				Area area = new Area(rs.getString(1),rs.getString(2),rs.getInt(3));
				la.add(area);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return la;
	}

	//修改行政区域
	@Override
	public boolean updateArea(Area area) {
		//声明sql语句
		String sql = "update t_area set area_name = ? where area_code = ?";
		int i = DBUtils.executeDML(sql, area.getAreaName(),area.getAreaCode());
		if(i!=-1) {
			return true;
		}else {
			return false;
		}
	}

	//根据父areacode和下一级等级查找父区域的下一层子区域
	@Override
	public List<Area> findByIdArea(String areaCode, String grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Area> list = new ArrayList<Area>();
		String sql = "select * from t_area where area_code like concat(?,'%') and grade=? ";
		
		
		if(areaCode==null) {
			return null;
		}
		conn = DBUtils.getConnection();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, areaCode);
			ps.setString(2, grade);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Area area = new Area();
				area.setAreaCode(rs.getString("area_code"));
				area.setAreaName(rs.getString("area_name"));
				area.setGrade(rs.getInt("grade"));
				list.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}

		return list;
	}

}
