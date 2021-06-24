package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;

public interface ChronicdisDao {

	int findChronicdis();

	List<Chronicdis> findChronicdisIndex(int start, int size);

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

	List<Chronicdis> findAllChronicdis();

	

}
