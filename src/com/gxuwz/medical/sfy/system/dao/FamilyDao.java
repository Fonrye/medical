package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.participation.Participation;

public interface FamilyDao {

	int findFamily(String hzxm);

	List<Family> findFamilyIndex(int start, int size,String hzxm);

	/**
	 * 添加家庭档案信息
	 * @param family
	 * @return
	 */
	int addFamily(Family family);

	/**
	 * 根据jtbh查询家庭档案信息
	 * @param jtbh
	 * @return
	 */
	Family findByFamily(String jtbh);

	/**
	 * 修改家庭档案信息
	 * @param family
	 * @return
	 */
	int update(Family family);

	/**
	 * 删除家庭档案信息
	 * @param jtbh
	 * @return
	 */
	int delete(String jtbh);

	/**
	 * 验证家庭编号是否存在
	 * @param jtbh
	 * @return
	 */
	Family check(String jtbh);

	/**
	 * 自动生成家庭编号
	 * @param zbh
	 * @return
	 */
	String createCode(String zbh);

	/**
	 * 自动更新家庭人口数
	 * @param jtbh
	 * @param jtrks
	 * @param nyrks 
	 * @return
	 */
	int jtrks(String jtbh, String jtrks, String nyrks);

	/**
	 * 根据家庭编号查询家庭信息
	 * @param lp
	 * @return
	 */
	List<Family> findByJtbh(List<Participation> lp);

}
