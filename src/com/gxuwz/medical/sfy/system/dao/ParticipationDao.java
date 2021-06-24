package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;

public interface ParticipationDao {

	/**
	 * 查询需要缴费的家庭成员
	 * @param jtbh
	 * @return
	 */
	List<Familyhold> findAllFamilyhold(String jtbh);

	/**
	 * 参合缴费登记
	 * @param chzh
	 * @param jtbh
	 * @param sfzh
	 * @param jfsj
	 * @param sdf
	 * @param money
	 * @return
	 */
	int saveParticipation(String[] chzh, String[] jtbh, String[] sfzh, String jfsj, String jfnd, Double money,String czy,String[] xm);

	/**
	 * 查询所有参合登记成员
	 * @return
	 */
	List<Participation> getAllParticipation();

	int findAllCount(String jfnd,String qssj,String jssj,String areaCode,String xm);

	List<Participation> findAllIndex(int start, int size, String jfnd, String qssj, String jssj,
			String areaCode,String xm);

	List<Participation> getAllPart(String jfnd, String qssj, String jssj, String areaCode, String xm);

	/**
	 * 查询本年度是否在参合缴费时间内
	 * @param jfsj
	 * @return
	 */
	Tswitch findById(String jfsj,String jfnd);

	/**
	 * 根据姓名查找缴费表
	 * @param xm
	 * @return
	 */
	List<Participation> findByXm(String xm);

	/**
	 * 查指定参合农民信息
	 * @param sfzh
	 * @return
	 */
	Participation findBySfzh(String sfzh);

	

}
