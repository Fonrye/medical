package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.medical.Medical;
import com.gxuwz.medical.sfy.domain.medical.S201;

public interface MedicalDao {

	int findMedical();

	List<Medical> findMedicalIndex(int start, int size);

	List<S201> findAllS201();

	/**
	 * 添加医疗机构信息
	 * @param medical
	 * @return
	 */
	int saveMedical(Medical medical);

	Medical findById(String jgbm);

	/**
	 * 修改医疗机构信息
	 * @param medical
	 * @return
	 */
	int update(Medical medical);

	/**
	 * 删除医疗机构信息
	 * @param jgbm
	 * @return
	 */
	int deleteMedical(String jgbm);

	

}
