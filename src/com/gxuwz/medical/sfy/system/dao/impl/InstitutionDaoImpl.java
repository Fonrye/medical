package com.gxuwz.medical.sfy.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.institution.Institution;
import com.gxuwz.medical.sfy.system.dao.InstitutionDao;
import com.gxuwz.medical.sfy.utils.DBUtils;
import com.mysql.jdbc.PreparedStatement;

public class InstitutionDaoImpl implements InstitutionDao {

	//查询农合经办点总数
	@Override
	public int findInstitutionSize() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int i = 0;
		try {
			sql = "select COUNT(*) from t_institution";
			rs = DBUtils.query(sql);
			while(rs.next()) {
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
	public List<Institution> findInstitutionIndex(int start, int size) {
		// 声明变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Institution> ai = new ArrayList<>();
		String sql = null;
		try {
			// 创建Sql语句
			sql = "select * from t_institution limit ?,?";
			// 执行sql语句
			rs = DBUtils.query(sql, start,size);
			// 获取结果
			while(rs.next()) {
				Institution ins = new Institution(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				ai.add(ins);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return ai;
	}

	//添加农合经办机构
	@Override
	public boolean addIns(Institution institution) {
		String sql = "insert into t_institution (area_code,agen_code,agen_name,grade) values(?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(institution.getAreaCode());
		list.add(institution.getAgenCode());
		list.add(institution.getAgenName());
		list.add(institution.getGrade());
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

	//根据AreaCode查询农合经办信息
	@Override
	public List<Institution> findInsAreacode(String areaCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Institution> li = new ArrayList<>();
		String sql = null;
		
		
		try {
			sql = "select * from t_institution where area_code = ?";
			rs = DBUtils.query(sql, areaCode);
			while(rs.next()) {
				Institution institution = new Institution(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				li.add(institution);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return li;
	}

	//根据areaCode修改经办机构
	@Override
	public boolean updateIns(String areaCode, String agenCode, String agenName) {
		String sql = "update t_institution set agen_code=?,agen_name=? where area_code=?";
		int i = DBUtils.executeDML(sql, agenCode,agenName,areaCode);
		if(i!=-1) {
			return true;
		}else {
			return false;
		}
	}

	//根据areaCode删除经办机构
	@Override
	public boolean deleteIns(String areaCode) {
		String sql = "delete from t_institution where area_code = ?";
		int i=DBUtils.executeDML(sql, areaCode);
		if(i!=-1) {
			return true;
		}else {
			return false;
		}
	}

}
