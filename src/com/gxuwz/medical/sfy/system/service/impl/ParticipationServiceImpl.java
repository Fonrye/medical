package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.system.dao.ParticipationDao;
import com.gxuwz.medical.sfy.system.dao.impl.ParticipationDaoImpl;
import com.gxuwz.medical.sfy.system.service.ParticipationService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class ParticipationServiceImpl implements ParticipationService {

	ParticipationDao pd = new ParticipationDaoImpl();

	@Override
	public List<Familyhold> findAllFamilyhold(String jtbh) {

		return pd.findAllFamilyhold(jtbh);
	}

	@Override
	public int saveParticipation(String[] chzh, String[] jtbh, String[] sfzh, String jfsj, String jfnd, Double money,
			String czy,String[] xm) {

		return pd.saveParticipation(chzh, jtbh, sfzh, jfsj, jfnd, money, czy,xm);
	}

	@Override
	public List<Participation> getAllParticipation() {

		return pd.getAllParticipation();
	}

	@Override
	public void pageParticipation(PageBean<Participation> pp, String jfnd, String qssj, String jssj,String areaCode,String xm) {
		//// 查询数据库获取总记录数
		int toatalCount = pd.findAllCount(jfnd, qssj, jssj,areaCode,xm);
		pp.setTotalCount(toatalCount);
		int start = pp.getStartRow();
		int size = pp.getSize();
       
		List<Participation> list = pd.findAllIndex(start, size, jfnd, qssj, jssj,areaCode, xm);
		pp.setList(list);
	}

	@Override
	public List<Participation> getAllPart(String jfnd, String qssj, String jssj, String areaCode, String xm) {
		
		return pd.getAllPart(jfnd,qssj,jssj,areaCode,xm);
	}

	//查询本年度是否在参合缴费时间内
	@Override
	public Tswitch findById(String jfsj,String jfnd) {
		
		return pd.findById(jfsj,jfnd);
	}

	//根据姓名查找缴费表
	@Override
	public List<Participation> findByXm(String xm) {
		
		return pd.findByXm(xm);
	}

	@Override
	public Participation findBySfzh(String sfzh) {
		
		return pd.findBySfzh(sfzh);
	}
	
}
