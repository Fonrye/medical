package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface ChronicdisService {

	/**
	 * 慢性病信息分页显示
	 * @param pc
	 */
	void pageChronicdis(PageBean<Chronicdis> pc);

	/**
	 * 修改慢性病信息
	 * @param chr
	 * @return
	 */
	boolean updateChr(Chronicdis chr);

	/**
	 * 添加慢性病信息
	 * @param chr
	 * @return
	 */
	boolean addChr(Chronicdis chr);

	/**
	 * 删除慢性病信息
	 * @param illCode
	 * @return
	 */
	boolean deleteChr(String illCode);

	/**
	 * 查询所有慢性病
	 * @return
	 */
	List<Chronicdis> findAllChronicdis();

	

	

}
