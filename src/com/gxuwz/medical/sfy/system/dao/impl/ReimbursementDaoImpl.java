package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.system.dao.ReimbursementDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> findReimbursement(String sfzh, String year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reimbursement> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_reim where sfzh=? and year=?";
			rs = DBUtils.query(sql, sfzh,year);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setIllcardNo(rs.getString("illcard_no"));
				r.setSfzh(rs.getString("sfzh"));
				r.setNhzh(rs.getString("nhzh"));
				r.setIllname(rs.getString("illname"));
				r.setIllMoney(rs.getString("illmoney"));
				r.setMoney(rs.getString("money"));
				r.setYyfph(rs.getString("yyfph"));
				r.setJzsj(rs.getString("jzsj"));
				r.setStatus(rs.getString("status"));
				r.setBxsj(rs.getString("bxsj"));
				r.setYear(rs.getString("year"));
				list.add(r);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return list;
		
	}

	@Override
	public int addReim(Reimbursement reim) {
		String sql = "insert into t_reim(name,illcard_no,sfzh,nhzh,illname,illmoney,money,yyfph,jzsj,status,bxsj,year) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, reim.getName(),reim.getIllcardNo(),reim.getSfzh(),reim.getNhzh(),reim.getIllname(),reim.getIllMoney(),reim.getMoney(),reim.getYyfph(),reim.getJzsj(),reim.getStatus(),reim.getBxsj(),reim.getYear());
	}

	@Override
	public int findAllCount(String name, String startTime, String endTime, String status) {
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

			if(status != null & !"".equals(status)) {
				sql.append(" and status ='"+status+"'");
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
			String status) {
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
				
				sql.append(" and jzsj >='"+startTime+"'");
			}
			if(endTime != null & !"".equals(endTime)) {
				sql.append(" and jzsj <='"+endTime+"'");
			}

			if(status != null & !"".equals(status)) {
				sql.append(" and status ='"+status+"'");
			}
			
//			if(lp.size()==0 ) {
//				for(int i =0;i<lp.size();i++) {
//					System.out.println(lp.size());
//					System.out.println("jtbh============="+lp.get(i).getJtbh());
//					sql.append(" and a.jtbh ='"+lp.get(i).getJtbh()+"'");
//					String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
//					System.out.println(sql2);
//					ps = conn.createStatement();
//					rs = ps.executeQuery(sql2);
//				}
//			}else {
//				String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
//				ps = conn.createStatement();
//				rs = ps.executeQuery(sql2);
//			}
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
	public int updateStatus(String id, int zt) {
		String sql = "update t_reim set status=? where id=?";
		return DBUtils.executeDML(sql, zt,id);
	}

}
