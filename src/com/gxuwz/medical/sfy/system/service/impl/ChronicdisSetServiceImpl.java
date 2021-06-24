package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;
import com.gxuwz.medical.sfy.system.dao.ChronicdisSetDao;
import com.gxuwz.medical.sfy.system.dao.impl.ChronicdisSetDaoImpl;
import com.gxuwz.medical.sfy.system.service.ChronicdisSetService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class ChronicdisSetServiceImpl implements ChronicdisSetService {
	ChronicdisSetDao dao = new ChronicdisSetDaoImpl();

	//分页查询慢性病设置信息
	@Override
	public void pageAll(PageBean<ChronicdisSet> pc, String illName) {
		//查询数据库表获取记录总数
		int totalCount = dao.findAllSize(illName);
		pc.setTotalCount(totalCount);
		//调用Dao层获取指定页数的数据，并放入PageBean的list属性
		int start = pc.getStartRow();
	    int size = pc.getSize();
	    List<ChronicdisSet> list = dao.findAllIndex(start,size,illName);
	    pc.setList(list);
	}

	//添加慢性病政策
	@Override
	public int add(ChronicdisSet set) {
		
		return dao.add(set);
	}

	//验证本年度该慢性病是否添加过
	@Override
	public ChronicdisSet check(String illName, String year) {
		
		return dao.check(illName,year);
	}

	//删除慢病政策
	@Override
	public int delete(int id) {
		
		return dao.delete(id);
	}

	//修改添加慢性病政策
	@Override
	public int update(ChronicdisSet set) {
		
		return dao.update(set);
	}

	@Override
	public ChronicdisSet checkSet(String illName, String year) {
		
		return dao.checkSet(illName,year);
	}

	

}
