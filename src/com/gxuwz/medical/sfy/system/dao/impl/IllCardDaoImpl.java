package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.illcard.IllCard;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.system.dao.IllCardDao;
import com.gxuwz.medical.sfy.utils.DBUtils;

public class IllCardDaoImpl implements IllCardDao {

	//带条件查询慢病证总数
	@Override
	public int findIllCardSize(String illCardId, String sfzh, String nhzh, String illName,String xm) {
		//声明连接数据库的变量
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		int i = 0;
		try {
			StringBuilder sql = new StringBuilder("select count(*) from t_illcard where 1=1");
			if(illCardId != null & !"".equals(illCardId)) {
				sql.append(" and illcard_id ="+illCardId);
			}
			if(sfzh != null & !"".equals(sfzh)) {
				sql.append(" and sfzh ="+sfzh);
			}
			if(nhzh != null & !"".equals(nhzh)) {
				sql.append(" and nhzh ="+nhzh);
			}
			if(illName != null & !"".equals(illName)) {
				sql.append(" and illname ="+illName);
			}
			if(xm != null & !"".equals(xm)) {
				
				sql.append(" and xm like '"+xm+"%'");
			}
			rs = DBUtils.query(sql.toString());
			if(rs.next()) {
				i = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}
		return i;
	}

	@Override
	public List<IllCard> findIllCardIndex(int start, int size, String illCardId, String sfzh, String nhzh,
			String illName,String xm) {
		Connection conn = null;
		ResultSet rs = null;
		Statement ps = null;
		ArrayList<IllCard> ai = new ArrayList<IllCard>();
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select i.* from t_illcard i where 1=1");
			if(illCardId != null & !"".equals(illCardId)) {
				sql.append(" and illcard_id like '"+illCardId+"%'");
			}
			if(sfzh != null & !"".equals(sfzh)) {
				sql.append(" and sfzh like '"+sfzh+"%'");
			}
			if(nhzh != null & !"".equals(nhzh)) {
				sql.append(" and nhzh like '"+nhzh+"%'");
			}
			if(illName != null & !"".equals(illName)) {
				sql.append(" and illname like '"+illName+"%'");
			}
			if(xm != null & !"".equals(xm)) {
				sql.append(" and xm like '"+xm+"%'");
			}
			String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			while(rs.next()) {
				IllCard ic = new IllCard();
				ic.setId(rs.getInt("id"));
				ic.setXm(rs.getString("xm"));
				ic.setIllCardId(rs.getString("illcard_id"));
				ic.setSfzh(rs.getString("sfzh"));
				ic.setNhzh(rs.getString("nhzh"));
				ic.setIllName(rs.getString("illname"));
				ic.setStartTime(rs.getString("start_time"));
				ic.setEndTime(rs.getString("end_time"));
				ai.add(ic);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs,ps, conn);
		}
		return ai;
	}

	//查询所有办理慢病证的成员
	public List<IllCard> findIllCardByXm(String xm) {
		//声明连接数据库的变量
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select * from t_illcard where 1=1 and xm like '%"+xm+"%'";
		ArrayList<IllCard> list = new ArrayList<IllCard>();
		try {
			rs = DBUtils.query(sql);
			while(rs.next()) {
				IllCard ic = new IllCard();
				ic.setId(rs.getInt("id"));
				ic.setXm(rs.getString("xm"));
				ic.setIllCardId(rs.getString("illcard_id"));
				ic.setSfzh(rs.getString("sfzh"));
				ic.setNhzh(rs.getString("nhzh"));
				ic.setIllName(rs.getString("illname"));
				ic.setStartTime(rs.getString("start_time"));
				ic.setEndTime(rs.getString("end_time"));
				list.add(ic);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}
		return list;
	}

	//保存慢病证
	@Override
	public int saveIllCard(IllCard illcard) {
		String sql = "insert into t_illcard(xm,nhzh,illcard_id,sfzh,illname,start_time,end_time) values(?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, illcard.getXm(),illcard.getNhzh(),illcard.getIllCardId(),illcard.getSfzh(),illcard.getIllName(),illcard.getStartTime(),illcard.getEndTime());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from t_illcard where id=?";
		return DBUtils.executeDML(sql, id);
	}

	@Override
	public List<IllCard> findIllcardById(int id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<IllCard> list = new ArrayList<IllCard>();
		try {
			String sql = "select * from t_illcard where id = ?";
			rs = DBUtils.query(sql, id);
			if(rs.next()) {
				IllCard illcard = new IllCard();
				illcard.setId(rs.getInt("id"));
				illcard.setXm(rs.getString("xm"));
				illcard.setIllCardId(rs.getString("illcard_id"));
				illcard.setSfzh(rs.getString("sfzh"));
				illcard.setNhzh(rs.getString("nhzh"));
				illcard.setIllName(rs.getString("illname"));
				illcard.setStartTime(rs.getString("start_time"));
				illcard.setEndTime(rs.getString("end_time"));
				list.add(illcard);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}
		return list;
	}

	//更新慢性病信息
	@Override
	public int update(IllCard ic) {
		String sql = "update t_illcard set xm=?,illname=?,start_time=?,end_time=? where id=?";
		return DBUtils.executeDML(sql, ic.getXm(),ic.getIllName(),ic.getStartTime(),ic.getEndTime(),ic.getId());
	}

	@Override
	public List<IllCard> getAll(String xm) {
		
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<IllCard> list = new ArrayList<IllCard>();
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select f.* from t_illcard f where 1=1");
			if(xm != null & !"".equals(xm)) {
				sql.append(" and xm like '"+xm+"%'");
			}
			String sql2 = "select f1.* from("+sql.toString()+") f1";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			
			while(rs.next()) {
				IllCard illcard = new IllCard();
				illcard.setId(rs.getInt("id"));
				illcard.setXm(rs.getString("xm"));
				illcard.setIllCardId(rs.getString("illcard_id"));
				illcard.setSfzh(rs.getString("sfzh"));
				illcard.setNhzh(rs.getString("nhzh"));
				illcard.setIllName(rs.getString("illname"));
				illcard.setStartTime(rs.getString("start_time"));
				illcard.setEndTime(rs.getString("end_time"));
				list.add(illcard);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	//根据身份证号查询慢性病证信息
	@Override
	public List<IllCard> findSfzh(String sfzh) {
		//声明连接数据库的变量
				Connection conn = null;
				ResultSet rs = null;
				PreparedStatement ps = null;
				String sql = "select * from t_illcard where sfzh = '"+sfzh+"'";
				ArrayList<IllCard> list = new ArrayList<IllCard>();
				try {
					rs = DBUtils.query(sql);
					while(rs.next()) {
						IllCard ic = new IllCard();
						ic.setId(rs.getInt("id"));
						ic.setXm(rs.getString("xm"));
						ic.setIllCardId(rs.getString("illcard_id"));
						ic.setSfzh(rs.getString("sfzh"));
						ic.setNhzh(rs.getString("nhzh"));
						ic.setIllName(rs.getString("illname"));
						ic.setStartTime(rs.getString("start_time"));
						ic.setEndTime(rs.getString("end_time"));
						list.add(ic);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
				}
				return list;
	}

	//校验报销信息是否合法
	@Override
	public IllCard checkIllcard(String illName, String jzsj, String sfzh) {
		//声明连接数据库的变量
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select * from t_illcard where sfzh= '"+sfzh+"' and illname = '"+illName+"' and start_time <= '"+jzsj+"' and end_time >= '"+jzsj+"'";
		IllCard ic = null;
		try {
			rs = DBUtils.query(sql);
			if(rs.next()) {
				ic = new IllCard();
				ic.setId(rs.getInt("id"));
				ic.setXm(rs.getString("xm"));
				ic.setIllCardId(rs.getString("illcard_id"));
				ic.setSfzh(rs.getString("sfzh"));
				ic.setNhzh(rs.getString("nhzh"));
				ic.setIllName(rs.getString("illname"));
				ic.setStartTime(rs.getString("start_time"));
				ic.setEndTime(rs.getString("end_time"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, (com.mysql.jdbc.PreparedStatement) ps, rs);
		}
		return ic;
	}
}
