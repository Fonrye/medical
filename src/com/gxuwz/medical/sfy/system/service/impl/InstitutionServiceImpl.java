package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.institution.Institution;
import com.gxuwz.medical.sfy.system.dao.InstitutionDao;
import com.gxuwz.medical.sfy.system.dao.impl.InstitutionDaoImpl;
import com.gxuwz.medical.sfy.system.service.InstitutionService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class InstitutionServiceImpl implements InstitutionService {

	InstitutionDao id = new InstitutionDaoImpl();
	
	// 农合经办机构分页展示
	@Override
	public void pageInstitution(PageBean<Institution> pi) {
		
		//查询数据库表获取记录总数
		int totalCount = id.findInstitutionSize();
		//使用记录总数计算PageBean中其他属性：totalPageCount(总页数)，numbers(页数集合)
		pi.setTotalCount(totalCount);
		//调用Dao层获取指定页数的学生数据，并放入PageBean的list属性
		int start = pi.getStartRow();
		int size = pi.getSize();
		List<Institution> li = id.findInstitutionIndex(start,size);
		pi.setList(li);
	}

	//添加农合经办机构
	@Override
	public boolean addIns(Institution institution) {
		
		
		if(institution != null && institution.getAreaCode() != null) {
			
			return id.addIns(institution);
		}
		return false;
	}

	//根据AreaCode查询农合经办信息
	@Override
	public List<Institution> findIntAreacode(String areaCode) {
		if(areaCode != null) {
			return id.findInsAreacode(areaCode);
		}
		return null;
	}

	//根据areaCode修改经办机构
	@Override
	public boolean updateIns(String areaCode, String agenCode, String agenName) {
		
		return id.updateIns(areaCode,agenCode,agenName);
	}

	//根据areaCode删除经办机构
	@Override
	public boolean deleteIns(String areaCode) {
		
		return id.deleteIns(areaCode);
	}

}
