package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.illcard.IllCard;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface IllCardService {

	void pageIllCard(PageBean<IllCard> pi, String illCardId, String sfzh, String nhzh, String illName,String xm);

	List<IllCard> findIllCardByXm(String xm);

	/**
	 * 保存慢病证
	 * @param illcare
	 * @return
	 */
	int saveIllCard(IllCard illcard);

	/**
	 * 删除慢病证
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 根据id查慢病表
	 * @param id
	 * @return
	 */
	List<IllCard> findIllcardById(int id);

    /**
     * 更新慢性病信息
     * @param ic
     * @return
     */
	int update(IllCard ic);

	List<IllCard> getAll(String xm);

	/**
	 * 根据身份证号查询慢性病证信息
	 * @param sfzh
	 * @return
	 */
	List<IllCard> findSfzh(String sfzh);

	/**
	 * 校验报销信息是否合法
	 * @param illName
	 * @param jzsj
	 * @param sfzh
	 * @return
	 */
	IllCard checkIllcard(String illName, String jzsj, String sfzh);

}
