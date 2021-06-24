package com.gxuwz.medical.sfy.system.service.impl;


import java.util.List;

import com.gxuwz.medical.sfy.domain.illcard.IllCard;
import com.gxuwz.medical.sfy.system.dao.IllCardDao;
import com.gxuwz.medical.sfy.system.dao.impl.IllCardDaoImpl;
import com.gxuwz.medical.sfy.system.service.IllCardService;
import com.gxuwz.medical.sfy.utils.PageBean;


public class IllCardServiceImpl implements IllCardService {
	
	IllCardDao dao = new IllCardDaoImpl();

	@Override
	public void pageIllCard(PageBean<IllCard> pi, String illCardId, String sfzh, String nhzh, String illName,String xm) {
		int totalCount = dao.findIllCardSize(illCardId,sfzh,nhzh,illName,xm);
		
		pi.setTotalCount(totalCount);//设置总页数
		int start = pi.getStartRow();//设置开始页数
		int size = pi.getSize();//设置每页显示数量
		List<IllCard> li = dao.findIllCardIndex(start,size,illCardId,sfzh,nhzh,illName,xm);
		pi.setList(li);
	}

	//查询所有办理慢病证的成员
	@Override
	public List<IllCard> findIllCardByXm(String xm) {
		
		return dao.findIllCardByXm(xm);
	}

	//保存慢病证
	@Override
	public int saveIllCard(IllCard illcard) {
		
		return dao.saveIllCard(illcard);
	}

	@Override
	public int delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public List<IllCard> findIllcardById(int id) {
		
		return dao.findIllcardById(id);
	}

	//更新慢性病信息
	@Override
	public int update(IllCard ic) {
		
		return dao.update(ic);
	}

	@Override
	public List<IllCard> getAll(String xm) {
		
		return dao.getAll(xm);
	}

	//根据身份证号查询慢性病证信息
	@Override
	public List<IllCard> findSfzh(String sfzh) {
		
		return dao.findSfzh(sfzh);
	}

	@Override
	public IllCard checkIllcard(String illName, String jzsj, String sfzh) {
		
		return dao.checkIllcard(illName,jzsj,sfzh);
	}
		
	

}
