package com.gxuwz.medical.sfy.system.service;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;
import com.gxuwz.medical.sfy.system.service.impl.ChronicdisSetServiceImpl;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface ChronicdisSetService {

	/**
	 * 分页查询慢性病设置信息
	 * @param pc
	 * @param illName
	 */
	void pageAll(PageBean<ChronicdisSet> pc, String illName);

	/**
	 * 添加慢性病政策
	 * @param set
	 * @return
	 */
	int add(ChronicdisSet set);

	/**
	 * 验证本年度该慢性病是否添加过
	 * @param illName
	 * @param year
	 * @return
	 */
	ChronicdisSet check(String illName, String year);

	/**
	 * 删除慢病政策
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 修改添加慢性病政策
	 * @param set
	 * @return
	 */
	int update(ChronicdisSet set);

	ChronicdisSet checkSet(String illName, String year);

	
	
	

}
