package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;

public interface StatisticDao {

	int findAllCount(String name, String startTime, String endTime, String illName, String areaCode);

	List<Reimbursement> findAllIndex(int start, int size, String name, String startTime, String endTime, String illName,
			String areaCode);

	List<Reimbursement> getAllRime(String name, String startTime, String endTime, String illName, String areaCode);

}
