package com.gxuwz.medical.sfy.system.dao.impl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.medical.Medical;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.system.dao.FamilyDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class FamilyDaoImpl implements FamilyDao {

	@Override
	public int findFamily(String hzxm) {
		Connection conn = null;
		//PreparedStatement ps = null;
		Statement ps = null;
		ResultSet rs = null;
		//String sql = null;
		int i = 0;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select count(*) from t_family where 1=1");
			if(hzxm != null && !"".equals(hzxm)) {
				sql.append(" and hzxm like '"+hzxm+"'");
				
			}
			ps = conn.createStatement();
			rs = ps.executeQuery(sql.toString());
			//sql = "select count(*) from t_family";
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
	public List<Family> findFamilyIndex(int start, int size,String hzxm) {
		Connection conn = null;
		//PreparedStatement ps = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Family> lf = new ArrayList<Family>();
		//String sql = null;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select f.* from t_family f where 1=1");
			if(hzxm != null && !"".equals(hzxm)){
				sql.append(" and hzxm like '"+hzxm+"'");	
			}
			String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			//sql = "select * from t_family limit ?,?";
			//rs = DBUtils.query(sql,start,size);
			while(rs.next()) {
				Family f = new Family();
				f.setXjbh(rs.getString("xjbh"));
				f.setXzbh(rs.getString("xzbh"));
				f.setCbh(rs.getString("cbh"));
				f.setZbh(rs.getString("zbh"));
				f.setJtbh(rs.getString("jtbh"));
				f.setHsx(rs.getString("hsx"));
				f.setHzxm(rs.getString("hzxm"));
				f.setJtrks(rs.getString("jtrks"));
				f.setNyrks(rs.getString("nyrks"));
				f.setJtdz(rs.getString("jtdz"));
				f.setCjdasj(rs.getString("cjdasj"));
				f.setDjy(rs.getString("djy"));
				lf.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return lf;
	}

	@Override
	public int addFamily(Family family) {
		String sql = "insert into t_family(xjbh,xzbh,cbh,zbh,jtbh,hsx,hzxm,jtrks,nyrks,jtdz,cjdasj,djy) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, family.getXjbh(),family.getXzbh(),family.getCbh(),family.getZbh(),family.getJtbh(),family.getHsx(),family.getHzxm(),family.getJtrks(),family.getNyrks(),family.getJtdz(),family.getCjdasj(),family.getDjy());
	}

	@Override
	public Family findByFamily(String jtbh) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Family family = null;
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "select * from t_family where jtbh = ?";
			rs = DBUtils.query(sql, jtbh);
			if(rs.next()) {
				family = new Family();
				family.setXjbh(rs.getString("xjbh"));
				family.setXzbh(rs.getString("xzbh"));
				family.setCbh(rs.getString("cbh"));
				family.setZbh(rs.getString("zbh"));
				family.setJtbh(rs.getString("jtbh"));
				family.setHsx(rs.getString("hsx"));
				family.setHzxm(rs.getString("hzxm"));
				family.setJtrks(rs.getString("jtrks"));
				family.setNyrks(rs.getString("nyrks"));
				family.setJtdz(rs.getString("jtdz"));
				family.setCjdasj(rs.getString("cjdasj"));
				family.setDjy(rs.getString("djy"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return family;
	}

	@Override
	public int update(Family family) {
		String sql = "update t_family set xjbh=?,xzbh=?,cbh=?,zbh=?,hsx=?,hzxm=?,jtrks=?,nyrks=?,jtdz=?,cjdasj=?,djy=? where jtbh=? ";
		return DBUtils.executeDML(sql, family.getXjbh(),family.getXzbh(),family.getCbh(),family.getZbh(),family.getHsx(),family.getHzxm(),family.getJtrks(),family.getNyrks(),family.getJtdz(),family.getCjdasj(),family.getDjy(),family.getJtbh());
	}

	@Override
	public int delete(String jtbh) {
		Connection conn =null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		int i =0;
		int j =0;
		try {
			conn = DBUtils.getConnection();
			String sql1 = "delete from t_family where jtbh=?";
			String sql2 = "delete from t_familyhold where jtbh=?";
			conn.setAutoCommit(false);
			ps2 = (PreparedStatement) conn.prepareStatement(sql2);
			ps1 = (PreparedStatement) conn.prepareStatement(sql1);
			ps2.setString(1, jtbh);
			ps1.setString(1, jtbh);
			j = ps2.executeUpdate();
			i = ps1.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			DBUtils.close(conn, ps2);
			DBUtils.close(conn, ps1);
			try {
				ps2.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		if(i>0&&j>0 || i>0) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public Family check(String jtbh) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Family family = null;
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "select * from t_family where jtbh = ?";
			rs = DBUtils.query(sql, jtbh);
			if(rs.next()) {
				family = new Family(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return family;
	}

	//自动创建家庭编码
	@Override
	public String createCode(String zbh) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select max(jtbh) from t_family where jtbh like ?";
		String code = zbh;
		String jtbh = null;
		int number = 1;
		try {
			String like1 = code+"%";
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, like1);
			rs = ps.executeQuery();
			if(rs.next()) {
				jtbh = rs.getString(1);
			}
			if(jtbh != null) {
				int beginIndex = jtbh.length() - 4;
				String no = jtbh.substring(beginIndex);
				jtbh = jtbh.substring(0, beginIndex);
				number = Integer.parseInt(no);
				++number;
				//使用0补足位数
				no = String.format("%04d", number);
				jtbh = jtbh + no;
			}else {
				String no = String.format("%04d", number);
				jtbh = code+no;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return jtbh;
	}

	@Override
	public int jtrks(String jtbh, String jtrks,String nyrks) {
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		String sql = null;
		try {
			conn = DBUtils.getConnection();
			sql = "update t_family set jtrks=?,nyrks=? where jtbh=? ";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, jtrks);
			ps.setString(2, nyrks);
			ps.setString(3, jtbh);
			i = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps);
		}
		return i;
	}

    //根据家庭编号查询家庭信息
	@Override
	public List<Family> findByJtbh(List<Participation> lp) {
		// 定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//Family family = null;
		ArrayList<Family> listFamily = new ArrayList<>();
		try {
			//创建链接
			conn = DBUtils.getConnection();
			if(lp.size()>0) {
				for(int i =0;i<lp.size();i++) {
					String sql = "select * from t_family where jtbh=?";
					ps = (PreparedStatement) conn.prepareStatement(sql);
					ps.setString(1, lp.get(i).getJtbh());
					rs = ps.executeQuery();
					while(rs.next()) {
						Family family = new Family(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
					    listFamily.add(family);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return listFamily;
	}

}
