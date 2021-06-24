package com.gxuwz.medical.sfy.system.service;

import java.util.List;

import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.utils.PageBean;

public interface ReimbursementService {

	/**
	 * 查询该报销人的报销信息
	 * @param sfzh
	 * @param year
	 * @return
	 */
	List<Reimbursement> findReimbursement(String sfzh, String year);

	/**
	 * 添加报销信息
	 * @param reim
	 * @return
	 */
	int addReim(Reimbursement reim);

	/**
	 * 分頁查詢報銷信息
	 * @param pr
	 * @param name
	 * @param startTime
	 * @param endTime
	 * @param status
	 */
	void pageReim(PageBean<Reimbursement> pr, String name, String startTime, String endTime, String status);

	/**
	 * 报销状态管理
	 * @param sfzh
	 * @param zt
	 * @return
	 */
	int updateStatus(String id, int zt);

	

}
