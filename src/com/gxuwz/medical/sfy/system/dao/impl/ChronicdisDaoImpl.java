package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;
import com.gxuwz.medical.sfy.system.dao.ChronicdisDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class ChronicdisDaoImpl implements ChronicdisDao {

	@Override
	public int findChronicdis() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from t_chronicdis";
		int i = 0;
		try {
			rs = DBUtils.query(sql);
			if(rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return i;
	}

	//分页查询，start是开始的页数，size是一页行有多少数据
	@Override
	public List<Chronicdis> findChronicdisIndex(int start, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Chronicdis> lc = new ArrayList<Chronicdis>();
		String sql = null;
		try {
			sql="select * from t_chronicdis limit ?,?";
			rs = DBUtils.query(sql,start,size);
			while(rs.next()) {
				Chronicdis c = new Chronicdis(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lc.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return lc;
	}

	//修改慢性病信息
	@Override
	public boolean updateChr(Chronicdis chr) {
		
		String sql = null;
	    sql = "update t_chronicdis set ill_name=?,py_code=?,wb_code=? where ill_code=? ";
		int i= DBUtils.executeDML(sql,chr.getIllName(),chr.getPyCode(),chr.getWbCode(),chr.getIllCode());
		if(i!=-1) {
			return true;
		}else {
			return false;
		}	
	}

	//添加慢性病信息
	@Override
	public boolean addChr(Chronicdis chr) {
		String sql = null;
		sql = "insert into t_chronicdis(ill_code,ill_name,py_code,wb_code) values(?,?,?,?)";
		int i= DBUtils.executeDML(sql,chr.getIllCode(),chr.getIllName(),chr.getPyCode(),chr.getWbCode());
		if(i!=-1) {
			return true;
		}else {
			return false;
		}	
	}

	//删除慢性病信息
	@Override
	public boolean deleteChr(String illCode) {
		String sql = "delete from t_chronicdis where ill_code=?";
		int i = DBUtils.executeDML(sql, illCode);
		if(i!=-1) {
			return true;
		}else {
			return false;
		}	
	}

	//查询所有慢性病
	@Override
	public List<Chronicdis> findAllChronicdis() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Chronicdis> lc = new ArrayList<Chronicdis>();
		String sql = null;
		try {
			sql="select * from t_chronicdis";
			rs = DBUtils.query(sql);
			while(rs.next()) {
				Chronicdis c = new Chronicdis(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lc.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return lc;
	}

	
}
