package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.system.dao.SwitchDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class SwitchDaoImpl implements SwitchDao {

	//查询记录总数
	@Override
	public int findAllSize(String year) {
		Connection conn = null;
		//PreparedStatement ps = null;
		Statement ps = null;
		ResultSet rs = null;
		//String sql = "select count(*) from t_switch";
		int i = 0;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new  StringBuilder("select count(*) from t_switch where 1=1");
			if(year != null & !"".equals(year)) {
				sql.append(" and year like '"+year+"'");
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
	public List<Tswitch> findSwitchIndex(int start, int size,String year) {
		Connection conn = null;
		//PreparedStatement ps = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Tswitch> la = new ArrayList<>();
		//String sql = null;
		try {
			conn = DBUtils.getConnection();
			StringBuilder sql = new StringBuilder("select f.* from t_switch f where 1=1");
			if(year != null & !"".equals(year)) {
				sql.append(" and year like '"+year+"'");
			}
			String sql2 = "select f3.* from(select f2.* from("+sql.toString()+") f2 limit "+start+","+size+")f3";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql2);
			// 创建Sql语句
			//sql = "select * from t_switch limit ?,?";
			// 执行sql语句
			//rs =DBUtils.query(sql, start,size);
			// 获取结果
			while (rs.next()) {
				Tswitch a = new Tswitch(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				la.add(a);
			}
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(rs, ps, conn);
			}
			// 关闭连接
			return la;
	}

	@Override
	public int saveSwitch(Tswitch tswitch) {
		String money1 = tswitch.getMoney();
		Double money = Double.parseDouble(money1);
		//声明变量
		String sql = "insert into t_switch(year,money,start_time,end_time) value(?,?,?,?)";
		return DBUtils.executeDML(sql, tswitch.getYear(),money,tswitch.getStart(),tswitch.getEnd());
	}

	@Override
	public int update(String year, Double money, String start, String end) {
		String sql = "update t_switch set money=?,start_time=?,end_time=? where year=?";
		return DBUtils.executeDML(sql, money,start,end,year);
	}

	////根据year查询该年度是否存在
	@Override
	public Tswitch checkYear(String year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tswitch tswitch = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_switch where year = ?";
			rs = DBUtils.query(sql, year);
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
			DBUtils.close(conn, ps, rs);
		}
		return tswitch;
	}

	//删除年度参合缴费信息
	@Override
	public int delete(String year) {
		String sql = "delete from t_switch where year = ?";
		return DBUtils.executeDML(sql, year);
	}

}
