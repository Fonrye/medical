package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.area.Area;

public interface AreaDao {

	int findAreaSize();

	List<Area> findAreaIndex(int start, int size);

	List<Area> findAllArea();

	/**
	 * 查询该行政区域是否存在下级行政区域
	 * @param areaCode
	 * @param newgrade
	 * @return
	 */
	String findNextArea(String oldareaCode, int grade);

	/**
	 * 保存新行政区域
	 * @param areacode1
	 * @param grade
	 * @param newareaName
	 * @return
	 */
	boolean saveArea(String areacode, int grade, String newareaName);

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
	List<Area> findAllAreaById(String areaCode);

	/**
	 * 修改行政区域
	 * @param area
	 * @return
	 */
	boolean updateArea(Area area);

	/**
	 * 根据父areacode查找下一层子区域
	 * @param areacode
	 * @param grade
	 * @return
	 */
	List<Area> findByIdArea(String areaCode, String grade);

}
