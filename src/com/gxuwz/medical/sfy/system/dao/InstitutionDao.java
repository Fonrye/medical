package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.institution.Institution;

public interface InstitutionDao {

	/**
	 * 查询农合经办点总数
	 * @return
	 */
	int findInstitutionSize();

	List<Institution> findInstitutionIndex(int start, int size);

	/**
	 * 添加农合经办机构
	 * @param institution
	 * @return 
	 */
	boolean addIns(Institution institution);

	/**
	 * 根据AreaCode查询农合经办信息
	 * @param areaCode
	 * @return
	 */
	List<Institution> findInsAreacode(String areaCode);

	/**
	 * 根据areaCode修改经办机构
	 * @param areaCode
	 * @param agenCode
	 * @param agenName
	 * @return
	 */
	boolean updateIns(String areaCode, String agenCode, String agenName);

	/**
	 * 根据areaCode删除经办机构
	 * @param areaCode
	 * @return
	 */
	boolean deleteIns(String areaCode);

}
