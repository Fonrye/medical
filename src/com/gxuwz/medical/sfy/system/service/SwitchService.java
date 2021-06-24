package com.gxuwz.medical.sfy.system.service;

import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface SwitchService {

	/**
	 * 查询所有设置缴费年度信息
	 * @param pt
	 */
	void pageSwitch(PageBean<Tswitch> pt,String year);

	/**
	 * 设置缴费年度信息
	 * @param tswitch
	 * @return
	 */
	int addSwitch(Tswitch tswitch);

	/**
	 * 修改设置缴费年度信息
	 * @param year
	 * @param money
	 * @param start
	 * @param end
	 * @return
	 */
	int update(String year, Double money, String start, String end);

	/**
	 * 根据year查询该年度是否存在
	 * @param year
	 * @return
	 */
	Tswitch checkYear(String year);

	/**
	 * 删除年度参合缴费信息
	 * @param year
	 * @return
	 */
	int delete(String year);

}
