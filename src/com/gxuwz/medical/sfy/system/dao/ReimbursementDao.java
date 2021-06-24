package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;

public interface ReimbursementDao {

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
	 * 计算报销信息总数
	 * @param name
	 * @param startTime
	 * @param endTime
	 * @param status
	 * @return
	 */
	int findAllCount(String name, String startTime, String endTime, String status);

	
	
	List<Reimbursement> findAllIndex(int start, int size, String name, String startTime, String endTime, String status);

	/**
	 * 报销状态管理
	 * @param sfzh
	 * @param zt
	 * @return
	 */
	int updateStatus(String id, int zt);

}
