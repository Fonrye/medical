package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.medical.Medical;
import com.gxuwz.medical.sfy.domain.medical.S201;
import com.gxuwz.medical.sfy.system.dao.MedicalDao;
import com.gxuwz.medical.sfy.system.dao.impl.MedicalDaoImpl;
import com.gxuwz.medical.sfy.system.service.MedicalService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class MedicalServiceImpl implements MedicalService {

	MedicalDao md = new MedicalDaoImpl();

	@Override
	public void pageMedical(PageBean<Medical> pm) {
		//查询数据库获取总记录数
		int totalCount = md.findMedical();
		//使用记录总数计算PageBean中其他属性：totalPageCount(总页数)，numbers(页数集合)
		pm.setTotalCount(totalCount);
		int start = pm.getStartRow();
		int size = pm.getSize();
		List<Medical> lm = md.findMedicalIndex(start,size);
		pm.setList(lm);
	}

	@Override
	public List<S201> findAllS201() {
		
		return md.findAllS201();
	}

	@Override
	public int saveMedical(Medical medical) {
		
		return md.saveMedical(medical);
	}

	@Override
	public Medical findById(String jgbm) {
		
		return md.findById(jgbm);
	}

	@Override
	public int update(Medical medical) {
		
		return md.update(medical);
	}

	@Override
	public int deleteMedical(String jgbm) {
		
		return md.deleteMedical(jgbm);
	}

	
	
}
