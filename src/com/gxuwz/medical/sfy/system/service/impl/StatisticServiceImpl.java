package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.system.dao.StatisticDao;
import com.gxuwz.medical.sfy.system.dao.impl.StatisticDaoImpl;
import com.gxuwz.medical.sfy.system.service.StatisticService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class StatisticServiceImpl implements StatisticService {
	StatisticDao dao = new StatisticDaoImpl();

	@Override
	public void pageReim(PageBean<Reimbursement> pr, String name, String startTime, String endTime, String illName,
			String areaCode) {
		int toatalCount = dao.findAllCount(name, startTime, endTime,illName,areaCode);
		pr.setTotalCount(toatalCount);
		int start = pr.getStartRow();
		int size = pr.getSize();
       
		List<Reimbursement> list = dao.findAllIndex(start, size, name, startTime, endTime,illName,areaCode);
		pr.setList(list);	
		
	}

	@Override
	public List<Reimbursement> getAllReim(String name, String startTime, String endTime, String illName,
			String areaCode) {
		
		return dao.getAllRime(name,startTime,endTime,illName,areaCode);
	}
	

}
