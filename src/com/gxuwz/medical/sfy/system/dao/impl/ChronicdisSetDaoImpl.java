package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;
import com.gxuwz.medical.sfy.system.dao.ChronicdisSetDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class ChronicdisSetDaoImpl implements ChronicdisSetDao {

	//查询总数
	@Override
	public int findAllSize(String illName) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		int i = 0;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new  StringBuilder("select count(*) from t_chronicdis_set where 1=1");
			if(illName != null & !"".equals(illName)) {
				sql.append(" and ill_name like '%"+illName+"%'");
			}
			//调用查询方法
			//rs = DBUtils.query(sql);
			ps = conn.createStatement();
			rs = ps.executeQuery(sql.toString());
			if(rs.next()) {
				i = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return i;
	}

	@Override
	public List<ChronicdisSet> findAllIndex(int start, int size, String illName) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<ChronicdisSet> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select f.* from t_chronicdis_set f where 1=1");
			
			if(illName != null & !"".equals(illName)) {
				sql.append(" and ill_name like '"+illName+"'");
			}
			
			String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			// 获取结果
			while (rs.next()) {
				ChronicdisSet a = new ChronicdisSet(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(a);
			}
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(rs, ps, conn);
			}
			// 关闭连接
			return list;
	}

	@Override
	public int add(ChronicdisSet set) {
		String sql = "insert into t_chronicdis_set(id,year,ill_name,money_capping,percentage) values(default,?,?,?,?)";
		return DBUtils.executeDML(sql, set.getYear(),set.getIllName(),set.getMoneyCapping(),set.getPercentage());
	}

	@Override
	public ChronicdisSet check(String illName, String year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ChronicdisSet cs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_chronicdis_set where year=? and ill_name=?";
			rs = DBUtils.query(sql, year,illName);
			if(rs.next()) {
				cs = new ChronicdisSet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return cs;
	}

	//删除慢病政策
	@Override
	public int delete(int id) {
		String sql = "delete from t_chronicdis_set where id=?";
		return DBUtils.executeDML(sql, id);
	}

	@Override
	public int update(ChronicdisSet set) {
		String sql = "update t_chronicdis_set set money_capping=?,percentage=? where id=?";
		return DBUtils.executeDML(sql, set.getMoneyCapping(),set.getPercentage(),set.getId());
	}

	@Override
	public ChronicdisSet checkSet(String illName, String year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ChronicdisSet cs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_chronicdis_set where year=? and ill_name=?";
			rs = DBUtils.query(sql, year,illName);
			if(rs.next()) {
				cs = new ChronicdisSet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return cs;
	}


}
