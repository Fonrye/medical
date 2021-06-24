package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.system.dao.StatisticDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class StatisticDaoImpl implements StatisticDao {

	@Override
	public int findAllCount(String name, String startTime, String endTime, String illName, String areaCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select count(*) from t_reim where 1=1");
			if(name != null & !"".equals(name)) {
				sql.append(" and name like '"+name+"%'");
			}
			if(startTime != null & !"".equals(startTime)) {
				
				sql.append(" and jzsj >='"+startTime+"'");
			}
			if(endTime != null & !"".equals(endTime)) {
				sql.append(" and jzsj <='"+endTime+"'");
			}

			if(illName != null & !"".equals(illName)) {
				sql.append(" and illname ='"+illName+"'");
			}
			///////
			if(areaCode != null & !"".equals(areaCode)) {
				sql.append(" and illname ='"+areaCode+"'");
			}
		
			ps = (PreparedStatement) conn.prepareStatement(sql.toString());
			//System.out.println(sql.toString());
			rs = ps.executeQuery();
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

	@Override
	public List<Reimbursement> findAllIndex(int start, int size, String name, String startTime, String endTime,
			String illName, String areaCode) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		try {
			conn = DBUtils.getConnection();
			//StringBuilder sql = new StringBuilder("select f.*,b.*,c.* from t_participation f,t_familyhold b,t_area c where 1=1");
			
			StringBuilder sql = new StringBuilder("select m.* from t_reim m where 1=1");
			//StringBuilder sql = new StringBuilder("select f.*,a.xm from t_participation f,t_familyhold a where 1=1");
			if(name != null & !"".equals(name)) {
				sql.append(" and name like '"+name+"%'");
			}
			if(startTime != null & !"".equals(startTime)) {
				
				sql.append(" and bxsj >='"+startTime+"'");
			}
			if(endTime != null & !"".equals(endTime)) {
				sql.append(" and bxsj <='"+endTime+"'");
			}

			if(endTime != null & !"".equals(endTime)) {
				sql.append(" and jzsj <='"+endTime+"'");
			}

			if(illName != null & !"".equals(illName)) {
				sql.append(" and illname ='"+illName+"'");
			}
			
			String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			
		    while(rs.next()) {
		    	Reimbursement m = new Reimbursement();
		    	m.setId(rs.getInt("id"));
		    	m.setName(rs.getString("name"));
		    	m.setIllcardNo(rs.getString("illcard_no"));
		    	m.setSfzh(rs.getString("sfzh"));
		    	m.setIllname(rs.getString("illname"));
		    	m.setIllMoney(rs.getString("illmoney"));
		    	m.setMoney(rs.getString("money"));
		    	m.setYyfph(rs.getString("yyfph"));
		    	m.setJzsj(rs.getString("jzsj"));
		    	m.setStatus(rs.getString("status"));
		    	m.setBxsj(rs.getString("bxsj"));
		    	m.setYear(rs.getString("year"));
		    	list.add(m);
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return list;
	}

	@Override
	public List<Reimbursement> getAllRime(String name, String startTime, String endTime, String illName,
			String areaCode) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select f.* from t_reim f where 1=1");
			if(name != null & !"".equals(name)) {
				sql.append(" and name like '"+name+"%'");
			}
			if(startTime != null & !"".equals(startTime)) {
				
				sql.append(" and bxsj >='"+startTime+"'");
			}
			if(endTime != null & !"".equals(endTime)) {
				sql.append(" and bxsj <='"+endTime+"'");
			}

			if(endTime != null & !"".equals(endTime)) {
				sql.append(" and jzsj <='"+endTime+"'");
			}

			if(illName != null & !"".equals(illName)) {
				sql.append(" and illname ='"+illName+"'");
			}
			String sql2 = "select f1.* from("+sql.toString()+") f1";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			while(rs.next()) {
		    	Reimbursement m = new Reimbursement();
		    	m.setId(rs.getInt("id"));
		    	m.setName(rs.getString("name"));
		    	m.setIllcardNo(rs.getString("illcard_no"));
		    	m.setSfzh(rs.getString("sfzh"));
		    	m.setIllname(rs.getString("illname"));
		    	m.setIllMoney(rs.getString("illmoney"));
		    	m.setMoney(rs.getString("money"));
		    	m.setYyfph(rs.getString("yyfph"));
		    	m.setJzsj(rs.getString("jzsj"));
		    	m.setStatus(rs.getString("status"));
		    	m.setBxsj(rs.getString("bxsj"));
		    	m.setYear(rs.getString("year"));
		    	list.add(m);
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

}
