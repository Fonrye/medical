package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface StatisticService {

	/**
	 * 分页查询所有报销信息
	 * @param pr
	 * @param name
	 * @param startTime
	 * @param endTime
	 * @param illName
	 * @param areaCode
	 */
	void pageReim(PageBean<Reimbursement> pr, String name, String startTime, String endTime, String illName,
			String areaCode);

	List<Reimbursement> getAllReim(String name, String startTime, String endTime, String illName, String areaCode);

}
