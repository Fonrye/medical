package com.gxuwz.medical.sfy.system.service.impl;

import java.util.List;

import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.system.dao.ReimbursementDao;
import com.gxuwz.medical.sfy.system.dao.impl.ReimbursementDaoImpl;
import com.gxuwz.medical.sfy.system.service.ReimbursementService;
import com.gxuwz.medical.sfy.utils.PageBean;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementDao dao = new ReimbursementDaoImpl();

	@Override
	public List<Reimbursement> findReimbursement(String sfzh, String year) {
		
		return dao.findReimbursement(sfzh,year);
	}

	@Override
	public int addReim(Reimbursement reim) {
		
		return dao.addReim(reim);
	}

	@Override
	public void pageReim(PageBean<Reimbursement> pr, String name, String startTime, String endTime, String status) {
	//// 查询数据库获取总记录数
			int toatalCount = dao.findAllCount(name, startTime, endTime,status);
			pr.setTotalCount(toatalCount);
			int start = pr.getStartRow();
			int size = pr.getSize();
	       
			List<Reimbursement> list = dao.findAllIndex(start, size, name, startTime, endTime,status);
			pr.setList(list);	
	}

	@Override
	public int updateStatus(String id, int zt) {
		
		return dao.updateStatus(id,zt);
	}

	
}
