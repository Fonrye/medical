package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.medical.Medical;
import com.gxuwz.medical.sfy.domain.medical.S201;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface MedicalService {

	/**
	 * 医疗机构信息分页显示
	 * @param pm
	 */
	void pageMedical(PageBean<Medical> pm);

	
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
