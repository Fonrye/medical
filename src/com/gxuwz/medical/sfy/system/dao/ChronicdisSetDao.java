package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;

public interface ChronicdisSetDao {

	/**
	 * 查询总数
	 * @param illName
	 * @return
	 */
	int findAllSize(String illName);

	List<ChronicdisSet> findAllIndex(int start, int size, String illName);

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
