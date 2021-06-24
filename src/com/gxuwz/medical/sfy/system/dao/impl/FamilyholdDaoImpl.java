package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.system.dao.FamilyholdDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class FamilyholdDaoImpl implements FamilyholdDao {

	@Override
	public List<Familyhold> findAllFamilyhold(String jtbh) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	    ArrayList<Familyhold> list = new ArrayList<Familyhold>();
	    String sql = null;
	    try {
			conn = DBUtils.getConnection();
			sql = "select * from t_familyhold where jtbh = ?";
			rs = DBUtils.query(sql,jtbh);
			while(rs.next()) {
				Familyhold f = new Familyhold();
				f.setId(rs.getInt("id"));
				f.setJtbh(rs.getString("jtbh"));
				f.setNhzh(rs.getString("nhzh"));
				f.setYlzkh(rs.getString("ylzkh"));
				f.setHnbh(rs.getString("hnbh"));
				f.setXm(rs.getString("xm"));
				f.setYhzgx(rs.getString("yhzgx"));
				f.setSfzh(rs.getString("sfzh"));
				f.setXb(rs.getString("xb"));
				f.setJkzk(rs.getString("jkzk"));
				f.setMz(rs.getString("mz"));
				f.setWhcd(rs.getString("whcd"));
				f.setNl(rs.getString("nl"));
				f.setCsrq(rs.getString("csrq"));
				f.setRysx(rs.getString("rysx"));
				f.setSfnchk(rs.getString("sfnchk"));
				f.setZy(rs.getString("zy"));
				f.setGzdw(rs.getString("gzdw"));
				f.setLxdh(rs.getString("lxdh"));
				f.setCzdz(rs.getString("czdz"));
				f.setMoneyState(rs.getString("money_state"));
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		   DBUtils.close(conn, ps, rs);	
		}
	   
		return list;
	}

	@Override
	public int saveFamilyhold(Familyhold familyhold) {
		String sql = "insert into t_familyhold(jtbh, nhzh, ylzkh, hnbh, xm, yhzgx, sfzh,xb, jkzk, mz, "
				+ "whcd, nl, csrq, rysx, sfnchk,zy, gzdw, lxdh, czdz, money_state)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, familyhold.getJtbh(),familyhold.getNhzh(),familyhold.getYlzkh(),
				familyhold.getHnbh(),familyhold.getXm(),familyhold.getYhzgx(),familyhold.getSfzh(),familyhold.getXb(),
				familyhold.getJkzk(),familyhold.getMz(),familyhold.getWhcd(),familyhold.getNl(),familyhold.getCsrq(),
				familyhold.getRysx(),familyhold.getSfnchk(),familyhold.getZy(),familyhold.getGzdw(),familyhold.getLxdh(),
				familyhold.getCzdz(),familyhold.getMoneyState());
	}

	@Override
	public Familyhold findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	    Familyhold f = null;
	    String sql = null;
	    try {
			conn = DBUtils.getConnection();
			sql = "select * from t_familyhold where id = ?";
			rs = DBUtils.query(sql,id);
			if(rs.next()) {
			     f = new Familyhold();
				f.setId(rs.getInt("id"));
				f.setJtbh(rs.getString("jtbh"));
				f.setNhzh(rs.getString("nhzh"));
				f.setYlzkh(rs.getString("ylzkh"));
				f.setHnbh(rs.getString("hnbh"));
				f.setXm(rs.getString("xm"));
				f.setYhzgx(rs.getString("yhzgx"));
				f.setSfzh(rs.getString("sfzh"));
				f.setXb(rs.getString("xb"));
				f.setJkzk(rs.getString("jkzk"));
				f.setMz(rs.getString("mz"));
				f.setWhcd(rs.getString("whcd"));
				f.setNl(rs.getString("nl"));
				f.setCsrq(rs.getString("csrq"));
				f.setRysx(rs.getString("rysx"));
				f.setSfnchk(rs.getString("sfnchk"));
				f.setZy(rs.getString("zy"));
				f.setGzdw(rs.getString("gzdw"));
				f.setLxdh(rs.getString("lxdh"));
				f.setCzdz(rs.getString("czdz"));
				f.setMoneyState(rs.getString("money_state"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		   DBUtils.close(conn, ps, rs);	
		}
	   
		return f;
	}

	@Override
	public int update(Familyhold familyhold) {
		String sql = "update t_familyhold set jtbh=?, nhzh=?, ylzkh=?, hnbh=?, xm=?, yhzgx=?, sfzh=?,xb=?, jkzk=?, mz=?,whcd=?, nl=?, csrq=?, rysx=?, sfnchk=?,zy=?, gzdw=?, lxdh=?, czdz=? where id = ?";
		return DBUtils.executeDML(sql,  familyhold.getJtbh(),familyhold.getNhzh(),familyhold.getYlzkh(),
				familyhold.getHnbh(),familyhold.getXm(),familyhold.getYhzgx(),familyhold.getSfzh(),familyhold.getXb(),
				familyhold.getJkzk(),familyhold.getMz(),familyhold.getWhcd(),familyhold.getNl(),familyhold.getCsrq(),
				familyhold.getRysx(),familyhold.getSfnchk(),familyhold.getZy(),familyhold.getGzdw(),familyhold.getLxdh(),familyhold.getCzdz(),familyhold.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from t_familyhold where id=?";
		return DBUtils.executeDML(sql, id);
	}

	@Override
	public int findFamilyhold(String xm) {
		Connection conn = null;
		//PreparedStatement ps = null;
		Statement ps = null;
		ResultSet rs = null;
		//String sql = null;
		int i = 0;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select count(*) from t_familyhold where 1=1");
			if(xm != null && !"".equals(xm)) {
				sql.append(" and xm like '"+xm+"'");
				
			}
			ps = conn.createStatement();
			rs = ps.executeQuery(sql.toString());
			
			//sql = "select count(*) from t_familyhold";
			//rs = DBUtils.query(sql);
			if(rs.next()) {
				i = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return i;
	}

	//分页查询，start是开始的页数，size是一页行有多少数据
	@Override
	public List<Familyhold> findFamilyholdIndex(int start, int size,String xm) {
		Connection conn = null;
		//PreparedStatement ps = null;
		Statement ps = null;
		ResultSet rs = null;
	    ArrayList<Familyhold> list = new ArrayList<Familyhold>();
	   // String sql = null;
	    try {
			conn = DBUtils.getConnection();
			
			StringBuilder sql = new StringBuilder("select f.* from t_familyhold f where 1=1");
			if(xm != null && !"".equals(xm)){
				sql.append(" and xm like '"+xm+"'");
				
			}
			String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
			
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			//sql = "select * from t_familyhold limit ?,?";
			//rs = DBUtils.query(sql,start,size);
			while(rs.next()) {
				Familyhold fh = new Familyhold();
				fh.setId(rs.getInt("id"));
				fh.setJtbh(rs.getString("jtbh"));
				fh.setNhzh(rs.getString("nhzh"));
				fh.setYlzkh(rs.getString("ylzkh"));
				fh.setHnbh(rs.getString("hnbh"));
				fh.setXm(rs.getString("xm"));
				fh.setYhzgx(rs.getString("yhzgx"));
				fh.setSfzh(rs.getString("sfzh"));
				fh.setXb(rs.getString("xb"));
				fh.setJkzk(rs.getString("jkzk"));
				fh.setMz(rs.getString("mz"));
				fh.setWhcd(rs.getString("whcd"));
				fh.setNl(rs.getString("nl"));
				fh.setCsrq(rs.getString("csrq"));
				fh.setRysx(rs.getString("rysx"));
				fh.setSfnchk(rs.getString("sfnchk"));
				fh.setZy(rs.getString("zy"));
				fh.setGzdw(rs.getString("gzdw"));
				fh.setLxdh(rs.getString("lxdh"));
				fh.setCzdz(rs.getString("czdz"));
				list.add(fh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
	   
		return list;
	}

	@Override
	public String getHnbhMax(String jtbh) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		String hnbh = null;
		try {
			conn = DBUtils.getConnection();
		    sql = "select max(hnbh) from t_familyhold where jtbh = ?";
		    ps = (PreparedStatement) conn.prepareStatement(sql);
		    ps.setString(1, jtbh);
		    rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	
		    	hnbh = rs.getString(1);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return hnbh ;
	}

	@Override
	public Familyhold checkSfzh(String sfzh) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Familyhold fh = null;
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "select * from t_familyhold where sfzh = ?";
			rs = DBUtils.query(sql, sfzh);
			if(rs.next()) {
				fh = new Familyhold();
				fh.setId(rs.getInt("id"));
				fh.setJtbh(rs.getString("jtbh"));
				fh.setNhzh(rs.getString("nhzh"));
				fh.setYlzkh(rs.getString("ylzkh"));
				fh.setHnbh(rs.getString("hnbh"));
				fh.setXm(rs.getString("xm"));
				fh.setYhzgx(rs.getString("yhzgx"));
				fh.setSfzh(rs.getString("sfzh"));
				fh.setXb(rs.getString("xb"));
				fh.setJkzk(rs.getString("jkzk"));
				fh.setMz(rs.getString("mz"));
				fh.setWhcd(rs.getString("whcd"));
				fh.setNl(rs.getString("nl"));
				fh.setCsrq(rs.getString("csrq"));
				fh.setRysx(rs.getString("rysx"));
				fh.setSfnchk(rs.getString("sfnchk"));
				fh.setZy(rs.getString("zy"));
				fh.setGzdw(rs.getString("gzdw"));
				fh.setLxdh(rs.getString("lxdh"));
				fh.setCzdz(rs.getString("czdz"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return fh;
	}

}
