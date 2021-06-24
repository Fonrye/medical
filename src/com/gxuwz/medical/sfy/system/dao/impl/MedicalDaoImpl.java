package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.medical.Medical;
import com.gxuwz.medical.sfy.domain.medical.S201;
import com.gxuwz.medical.sfy.system.dao.MedicalDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class MedicalDaoImpl implements MedicalDao {

	@Override
	public int findMedical() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int i = 0;
		try {
			DBUtils.getConnection();
			sql = "select count(*) from t_medical";
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
	public List<Medical> findMedicalIndex(int start, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Medical> lm = new ArrayList<Medical>();
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "select * from t_medical limit ?,?";
			rs = DBUtils.query(sql,start,size);
			while(rs.next()) {
				Medical m = new Medical();
				m.setJgbm(rs.getString("jgbm"));
				m.setZzjgbm(rs.getString("zzjgbm"));
				m.setJgmc(rs.getString("jgmc"));
				m.setDqbm(rs.getString("dqbm"));
				m.setAreacode(rs.getString("areacode"));
				m.setLsgx(rs.getString("lsgx"));
				m.setJgjb(rs.getString("jgjb"));
				m.setSbddlx(rs.getString("sbddlx"));
				m.setPzddlx(rs.getString("pzddlx"));
				m.setSsjjlx(rs.getString("ssjjlx"));
				m.setWsjgdl(rs.getString("wsjgdl"));
				m.setWsjgxl(rs.getString("wsjgxl"));
				m.setZgdw(rs.getString("zgdw"));
				m.setKysj(rs.getString("kysj"));
				m.setFrdb(rs.getString("frdb"));
				m.setZczj(rs.getDouble("zczj"));
				lm.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return lm;
	}

	@Override
	public List<S201> findAllS201() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<S201> ls = new ArrayList<S201>();
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "select * from t_s201";
			rs = DBUtils.query(sql);
			while(rs.next()) {
				S201 s201 = new S201(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				ls.add(s201);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return ls;
	}

	@Override
	public int saveMedical(Medical medical) {
		String sql = "insert into t_medical(jgbm,zzjgbm,jgmc,dqbm,areacode,lsgx,jgjb,sbddlx,pzddlx,ssjjlx,wsjgdl,wsjgxl,zgdw,kysj,frdb,zczj) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, medical.getJgbm(),medical.getZzjgbm(),medical.getJgmc(),medical.getDqbm(),medical.getAreacode(),medical.getLsgx(),medical.getJgjb(),medical.getSbddlx(),medical.getPzddlx(),medical.getSsjjlx(),medical.getWsjgdl(),medical.getWsjgxl(),medical.getZgdw(),medical.getKysj(),medical.getFrdb(),medical.getZczj());
	}

	@Override
	public Medical findById(String jgbm) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Medical medical = null;
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "select * from t_medical where jgbm = ?";
			rs = DBUtils.query(sql, jgbm);
			if(rs.next()) {
				medical = new Medical(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getDouble(16));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return medical;
	}

	@Override
	public int update(Medical medical) {
		String sql = "update t_medical set zzjgbm=?,jgmc=?,dqbm=?,areacode=?,lsgx=?,jgjb=?,sbddlx=?,pzddlx=?,ssjjlx=?,wsjgdl=?,wsjgxl=?,zgdw=?,kysj=?,frdb=?,zczj=? where jgbm = ?";
		return DBUtils.executeDML(sql, medical.getZzjgbm(),medical.getJgmc(),medical.getDqbm(),medical.getAreacode(),medical.getLsgx(),medical.getJgjb(),medical.getSbddlx(),medical.getPzddlx(),medical.getSsjjlx(),medical.getWsjgdl(),medical.getWsjgxl(),medical.getZgdw(),medical.getKysj(),medical.getFrdb(),medical.getZczj(),medical.getJgbm());
	}

	@Override
	public int deleteMedical(String jgbm) {
		String sql = "delete from t_medical where jgbm = ?";
		
		return DBUtils.executeDML(sql, jgbm);
	}

	

}
