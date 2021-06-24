package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.institution.Institution;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface InstitutionService {

	/**
	 *  农合经办机构分页展示
	 * @param pi
	 */
	void pageInstitution(PageBean<Institution> pi);

	/**
	 * 添加农合经办机构信息
	 * @param institution
	 * @return
	 */
	boolean addIns(Institution institution);

	/**
	 * 根据AreaCode查询农合经办信息
	 * @param areaCode
	 * @return
	 */
	List<Institution> findIntAreacode(String areaCode);

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
