package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.system.dao.FamilyDao;
import com.gxuwz.medical.sfy.system.dao.impl.FamilyDaoImpl;
import com.gxuwz.medical.sfy.system.service.FamilyService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class FamilyServiceImpl implements FamilyService {

	FamilyDao fd = new FamilyDaoImpl();
	
	@Override
	public void pageFamily(PageBean<Family> pf,String hzxm) {
		//查询数据库获取总记录数
		int totalCount = fd.findFamily(hzxm);
		//使用记录总数计算PageBean中其他属性：totalPageCount(总页数)，numbers(页数集合)
		pf.setTotalCount(totalCount);
		int start = pf.getStartRow();
		int size = pf.getSize();
		List<Family> lf = fd.findFamilyIndex(start,size,hzxm);
		pf.setList(lf);
	}

	@Override
	public int addFamily(Family family) {
		
		return fd.addFamily(family);
	}

	@Override
	public Family findByFamily(String jtbh) {
		
		return fd.findByFamily(jtbh);
	}

	@Override
	public int update(Family family) {
		
		return fd.update(family);
	}

	@Override
	public int delete(String jtbh) {
		
		return fd.delete(jtbh);
	}

	@Override
	public Family check(String jtbh) {
		
		return fd.check(jtbh);
	}

	@Override
	public String createCode(String zbh) {
		
		return fd.createCode(zbh);
	}

	@Override
	public int jtrks(String jtbh, String jtrks,String nyrks) {
		
		return fd.jtrks(jtbh,jtrks,nyrks);
	}

	@Override
	public List<Family> findByJtbh(List<Participation> lp) {
		
		return fd.findByJtbh(lp);
	}

	

}
