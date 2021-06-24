package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CreationHelper;

import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.system.dao.ParticipationDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;


public class ParticipationDaoImpl implements ParticipationDao {

	@Override
	public List<Familyhold> findAllFamilyhold(String jtbh) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	    ArrayList<Familyhold> list = new ArrayList<Familyhold>();
	    String sql = null;
	    try {
			conn = DBUtils.getConnection();
			sql = "select * from t_familyhold where money_state = '"+0+"' and jtbh = ?";
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
	public int saveParticipation(String[] chzh, String[] jtbh, String[] sfzh, String jfsj, String jfnd,
			Double money,String czy,String[] xm) {
		    String chfph = null;
		    String sql = null;
		    int j = 0;
			for(int i =0;i<sfzh.length;i++) {
				chfph = jfnd+jtbh[i]+chzh[i];
				sql = "insert into t_participation(id,chzh,chfph,jfje,jfnd,jfsj,czy,jtbh,sfzh,xm) values(default,?,?,?,?,?,?,?,?,?)";
				 j = DBUtils.executeDML(sql, chzh[i],chfph,money,jfnd,jfsj,czy,jtbh[i],sfzh[i],xm[i]);
			}
		
		return j;
	}

	@Override
	public List<Participation> getAllParticipation() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Participation> list = new ArrayList<Participation>();
		try {
			// 创建Sql语句
			String sql = "select * from t_participation";
			// 执行sql语句
			rs = DBUtils.query(sql);
			while (rs.next()) {
				Participation pa = new Participation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				list.add(pa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}

	////查询数据库获取总记录数
	@Override
	public int findAllCount(String jfnd,String qssj,String jssj,String areaCode,String xm) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select count(*) from t_participation where 1=1");
			if(jfnd != null & !"".equals(jfnd)) {
				sql.append(" and jfnd ="+jfnd);
			}
			if(qssj != null & !"".equals(qssj)) {
				sql.append(" and jfsj >='"+qssj+"'");
			}
			if(jssj != null & !"".equals(jssj)) {
				sql.append(" and jfsj <='"+jssj+"'");
			}
			if(areaCode != null & !"".equals(areaCode)) {
				sql.append(" and jtbh like '"+areaCode+"%'");
			}
			if(xm != null & !"".equals(xm)) {
				sql.append(" and xm like '%"+xm+"%'");
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
	public List<Participation> findAllIndex(int start, int size,String jfnd,String qssj,String jssj,String areaCode,String xm) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Participation> list = new ArrayList<Participation>();
		try {
			conn = DBUtils.getConnection();
			//StringBuilder sql = new StringBuilder("select f.*,b.*,c.* from t_participation f,t_familyhold b,t_area c where 1=1");
			
			StringBuilder sql = new StringBuilder("select f.* from t_participation f where 1=1");
			//StringBuilder sql = new StringBuilder("select f.*,a.xm from t_participation f,t_familyhold a where 1=1");
			if(jfnd != null & !"".equals(jfnd)) {
				sql.append(" and jfnd ="+jfnd);
			}
			if(qssj != null & !"".equals(qssj)) {
				//System.out.println("qssj="+qssj);
				sql.append(" and jfsj >='"+qssj+"'");
			}
			if(jssj != null & !"".equals(jssj)) {
				sql.append(" and jfsj <='"+jssj+"'");
			}

			if(areaCode != null & !"".equals(areaCode)) {
				sql.append(" and jtbh like '"+areaCode+"%'");
			}
			if(xm != null & !"".equals(xm)) {
				sql.append(" and xm like '%"+xm+"%'");
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
		    	Participation p = new Participation();
		    	p.setChzh(rs.getString("chzh"));
		    	p.setChfph(rs.getString("chfph"));
		    	p.setJfje(rs.getString("jfje"));
		    	p.setJfnd(rs.getString("jfnd"));
		    	p.setJfsj(rs.getString("jfsj"));
		    	p.setCzy(rs.getString("czy"));
		    	p.setJtbh(rs.getString("jtbh"));
		    	p.setSfzh(rs.getString("sfzh"));
		    	p.setXm(rs.getString("xm"));
		    	list.add(p);
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return list;
	}

	@Override
	public List<Participation> getAllPart(String jfnd, String qssj, String jssj, String areaCode, String xm) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Participation> list = new ArrayList<Participation>();
		try {
			conn = DBUtils.getConnection();
			
			StringBuilder sql = new StringBuilder("select f.* from t_participation f where 1=1");
			
			if(jfnd != null & !"".equals(jfnd)) {
				sql.append(" and jfnd ="+jfnd);
			}
			if(qssj != null & !"".equals(qssj)) {
				//System.out.println("qssj="+qssj);
				sql.append(" and jfsj >='"+qssj+"'");
			}
			if(jssj != null & !"".equals(jssj)) {
				sql.append(" and jfsj <='"+jssj+"'");
			}

			if(areaCode != null & !"".equals(areaCode)) {
				sql.append(" and jtbh like '"+areaCode+"%'");
			}
			if(xm != null & !"".equals(xm)) {
				sql.append(" and xm like '%"+xm+"%'");
			}
		    String sql2 = "select f1.* from("+sql.toString()+") f1";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			
		    while(rs.next()) {
		    	Participation p = new Participation();
		    	p.setChzh(rs.getString("chzh"));
		    	p.setChfph(rs.getString("chfph"));
		    	p.setJfje(rs.getString("jfje"));
		    	p.setJfnd(rs.getString("jfnd"));
		    	p.setJfsj(rs.getString("jfsj"));
		    	p.setCzy(rs.getString("czy"));
		    	p.setJtbh(rs.getString("jtbh"));
		    	p.setSfzh(rs.getString("sfzh"));
		    	p.setXm(rs.getString("xm"));
		    	list.add(p);
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return list;
	}

	//查询本年度是否在参合缴费时间内
	@Override
	public Tswitch findById(String jfsj,String jfnd) {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		Tswitch tswitch = null;
		//String sql = "select * from t_switch where start_time <= '"+jfsj+"' and end_time >='"+jfsj+"'";
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_switch where start_time <= '"+jfsj+"' and end_time >='"+jfsj+"' and year = '"+jfnd+"'";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);
			if(rs.next()) {
				tswitch = new Tswitch();
				tswitch.setYear(rs.getString("year"));
				tswitch.setMoney(rs.getString("money"));
				tswitch.setStart(rs.getString("start_time"));
				tswitch.setEnd(rs.getString("end_time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return tswitch;
	}

	@Override
	public List<Participation> findByXm(String xm) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select f.* from t_participation f where 1=1 and xm like '%"+xm+"%'";
		ArrayList<Participation> list = new ArrayList<>();
		try {
			rs = DBUtils.query(sql);
			while(rs.next()) {
				Participation p = new Participation();
				p.setId(rs.getInt("id"));
		    	p.setChzh(rs.getString("chzh"));
		    	p.setChfph(rs.getString("chfph"));
		    	p.setJfje(rs.getString("jfje"));
		    	p.setJfnd(rs.getString("jfnd"));
		    	p.setJfsj(rs.getString("jfsj"));
		    	p.setCzy(rs.getString("czy"));
		    	p.setJtbh(rs.getString("jtbh"));
		    	p.setSfzh(rs.getString("sfzh"));
		    	p.setXm(rs.getString("xm"));
		    	list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Participation findBySfzh(String sfzh) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select * from t_participation where sfzh='"+sfzh+"'";
		Participation p = null;
		try {
			rs = DBUtils.query(sql);
			while(rs.next()) {
			    p = new Participation();
				p.setId(rs.getInt("id"));
		    	p.setChzh(rs.getString("chzh"));
		    	p.setChfph(rs.getString("chfph"));
		    	p.setJfje(rs.getString("jfje"));
		    	p.setJfnd(rs.getString("jfnd"));
		    	p.setJfsj(rs.getString("jfsj"));
		    	p.setCzy(rs.getString("czy"));
		    	p.setJtbh(rs.getString("jtbh"));
		    	p.setSfzh(rs.getString("sfzh"));
		    	p.setXm(rs.getString("xm"));
		    	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return p;
	}

}
