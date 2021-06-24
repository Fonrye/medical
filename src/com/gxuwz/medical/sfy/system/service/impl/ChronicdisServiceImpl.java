package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;
import com.gxuwz.medical.sfy.system.dao.ChronicdisDao;
import com.gxuwz.medical.sfy.system.dao.impl.ChronicdisDaoImpl;
import com.gxuwz.medical.sfy.system.service.ChronicdisService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class ChronicdisServiceImpl implements ChronicdisService {

	ChronicdisDao cd = new ChronicdisDaoImpl();

	//慢性病信息分页显示
	@Override
	public void pageChronicdis(PageBean<Chronicdis> pc) {
		//查询数据库表获取记录总数
		int totalCount = cd.findChronicdis();
		//使用记录总数计算PageBean中其他属性：totalPageCount(总页数)，numbers(页数集合)
		pc.setTotalCount(totalCount);
		//调用Dao层获取指定页数的学生数据，并放入PageBean的list属性
		int start = pc.getStartRow();
		int size = pc.getSize();
		List<Chronicdis> lc = cd.findChronicdisIndex(start,size);
		pc.setList(lc);
	}

	//修改慢性病信息
	@Override
	public boolean updateChr(Chronicdis chr) {
		
		return cd.updateChr(chr);
	}

	//添加慢性病信息
	@Override
	public boolean addChr(Chronicdis chr) {
		
		return cd.addChr(chr);
	}

	@Override
	public boolean deleteChr(String illCode) {
		if(illCode != null) {
			return cd.deleteChr(illCode);
		}
		return false;
	}

	//查询所有慢性病
	@Override
	public List<Chronicdis> findAllChronicdis() {
		
		return cd.findAllChronicdis();
	}
	
	

	
	

}
