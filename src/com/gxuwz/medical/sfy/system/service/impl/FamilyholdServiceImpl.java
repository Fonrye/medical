package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.system.dao.FamilyholdDao;
import com.gxuwz.medical.sfy.system.dao.impl.FamilyholdDaoImpl;
import com.gxuwz.medical.sfy.system.service.FamilyholdService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class FamilyholdServiceImpl implements FamilyholdService {

	FamilyholdDao fhd = new FamilyholdDaoImpl();

	@Override
	public List<Familyhold> findAllFamilyhold(String jtbh) {
		
		return fhd.findAllFamilyhold(jtbh);
	}

	@Override
	public int addMamilyhold(Familyhold familyhold) {
		
		return fhd.saveFamilyhold(familyhold);
	}

	@Override
	public Familyhold findById(int id) {
		
		return fhd.findById(id);
	}

	@Override
	public int update(Familyhold familyhold) {
		
		return fhd.update(familyhold);
	}

	@Override
	public int delete(int id) {
		
		return fhd.delete(id);
	}

	@Override
	public void pageFamilyhold(PageBean<Familyhold> pfh,String xm) {
		//查询数据库获取总记录数
		int totalCount = fhd.findFamilyhold(xm);
		//使用记录总数计算PageBean中其他属性：totalPageCount(总页数)，numbers(页数集合)
		pfh.setTotalCount(totalCount);
		int start = pfh.getStartRow();
		int size = pfh.getSize();
		List<Familyhold> lfh = fhd.findFamilyholdIndex(start,size,xm);
		pfh.setList(lfh);
		
	}

	@Override
	public String getHnbhMax(String jtbh) {
		
		return fhd.getHnbhMax(jtbh);
	}

	@Override
	public Familyhold checkSfzh(String sfzh) {
		
		return fhd.checkSfzh(sfzh);
	}
	
}
