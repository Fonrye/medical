package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.system.dao.AreaDao;
import com.gxuwz.medical.sfy.system.dao.impl.AreaDaoImpl;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class AreaServiceImpl implements AreaService {

	AreaDao ad = new AreaDaoImpl();
	
	/**
	 * 行政区域分页展示
	 */
	@Override
	public void pageArea(PageBean<Area> pa) {
		//查询数据库表获取记录总数
		int totalCount = ad.findAreaSize();
		//使用记录总数计算PageBean中其他属性：totalPageCount(总页数)，numbers(页数集合)
		pa.setTotalCount(totalCount);
		//调用Dao层获取指定页数的学生数据，并放入PageBean的list属性
		int start = pa.getStartRow();
		int size = pa.getSize();
		List<Area> la = ad.findAreaIndex(start,size);
		pa.setList(la);
	}

	// 查询所有行政区域
	@Override
	public List<Area> findAllArea() {
		
		return ad.findAllArea();
	}

	//添加行政区域
	@Override
	public boolean addArea(String oldareaCode, String oldgrade, String newareaName) {
		
		//先查询所属行政区域的是否存在下级行政区域
		String maxcode = "";
		Integer number = 1;
		int grade = Integer.parseInt(oldgrade)+1;//先将所属行政区域的等级变为下一等级
		String areacode = ad.findNextArea(oldareaCode,grade);//获取所属行政区域的下级行政区域的最后一位的areacode，若没有下级行政区域，areacode则为空
		
		if(areacode != null) {
			int beginIndex = areacode.length()-2;
			
			String no = areacode.substring(beginIndex);
			
			number = Integer.parseInt(no);
			
			++number;
			
			no = String.format("%02d", number);
			
			maxcode = oldareaCode+no;
			
		}else {
			String no=String.format("%02d", number);
			maxcode = oldareaCode+no;
		}
		//再将行新的行政区域保存
		return ad.saveArea(maxcode,grade,newareaName);
	}

	//删除行政区域
	@Override
	public boolean deleteArea(String areaCode,int grade) {
		
		return ad.deleteArea(areaCode,grade);
	}

	//根据areaId查询行政区域
	@Override
	public List<Area> findAreaById(String areaCode) {
		
		return ad.findAllAreaById(areaCode);
	}

	//修改行政区域
	@Override
	public boolean updateArea(Area area) {
		
		return ad.updateArea(area);
	}

	//根据父areacode和下一级等级查找父区域的下一层子区域
	@Override
	public List<Area> findByIdArea(String areaCode, String grade) {
		
		return ad.findByIdArea(areaCode,grade);
	}

}
