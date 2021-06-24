package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.system.dao.SwitchDao;
import com.gxuwz.medical.sfy.system.dao.impl.SwitchDaoImpl;
import com.gxuwz.medical.sfy.system.service.SwitchService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class SwitchServiceImpl implements SwitchService {

	SwitchDao sd = new SwitchDaoImpl();
	
	//所有设置缴费年度信息分页显示
	@Override
	public void pageSwitch(PageBean<Tswitch> pt,String year) {
		//查询数据库表获取记录总数
		int totalCount = sd.findAllSize(year);
		pt.setTotalCount(totalCount);
		//调用Dao层获取指定页数的学生数据，并放入PageBean的list属性
		int start = pt.getStartRow();
	    int size = pt.getSize();
	    List<Tswitch> lts = sd.findSwitchIndex(start,size,year);
	    pt.setList(lts);
		
	}

	//设置缴费年度信息
	@Override
	public int addSwitch(Tswitch tswitch) {
		
		return sd.saveSwitch(tswitch);
	}

	//修改设置缴费年度信息
	@Override
	public int update(String year, Double money, String start, String end) {
		
		return sd.update(year,money,start,end);
	}

	//根据year查询该年度是否存在
	@Override
	public Tswitch checkYear(String year) {
		
		return sd.checkYear(year);
	}

	//删除年度参合缴费信息
	@Override
	public int delete(String year) {
		
		return sd.delete(year);
	}

}
