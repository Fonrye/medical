package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Familyhold;

public interface FamilyholdDao {

	/**
	 * 查询家庭参合人员列表
	 * @param jtbh
	 * @return
	 */
	List<Familyhold> findAllFamilyhold(String jtbh);

	/**
	 * 添加参合人员信息
	 * @param familyhold
	 * @return
	 */
	int saveFamilyhold(Familyhold familyhold);

	/**
	 * 根据id查参合人员信息
	 * @param id
	 * @return
	 */
	Familyhold findById(int id);

	/**
	 * 修改参合人员信息
	 * @param familyhold
	 * @return
	 */
	int update(Familyhold familyhold);

	/**
	 * 删除参合人员信息
	 * @param id
	 * @return
	 */
	int delete(int id);

	int findFamilyhold(String xm);

	List<Familyhold> findFamilyholdIndex(int start, int size,String xm);

	/**
	 * 查询最大户内编号
	 * @param jtbh
	 * @return
	 */
	String getHnbhMax(String jtbh);

	/**
	 * 验证身份证号是否存在
	 * @param sfzh
	 * @return
	 */
	Familyhold checkSfzh(String sfzh);

}
