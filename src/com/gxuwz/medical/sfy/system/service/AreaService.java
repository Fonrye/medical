package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface AreaService {

	/**
	 * 查询行政区域
	 * @param pa
	 */
	void pageArea(PageBean<Area> pa);

	List<Area> findAllArea();

	/**
	 * 添加行政区域
	 * @param areaCode
	 * @param grade
	 * @param areaName
	 * @return
	 */
	boolean addArea(String oleareaCode, String oldgrade, String newareaName);

	/**
	 * 删除行政区域
	 * @param areaCode
	 * @return
	 */
	boolean deleteArea(String areaCode,int grade);

	/**
	 * 根据areaId查询行政区域
	 * @param areaCode
	 * @return
	 */
	List<Area> findAreaById(String areaCode);

	/**
	 * 修改行政区域
	 * @param area
	 * @return
	 */
	boolean updateArea(Area area);

	/**
	 * 联动查询行政区域
	 * @param areacode
	 * @param grade
	 * @return
	 */
	List<Area> findByIdArea(String areaCode, String grade);

}
