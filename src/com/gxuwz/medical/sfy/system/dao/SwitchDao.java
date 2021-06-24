package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;

public interface SwitchDao {

	int findAllSize(String year);

	List<Tswitch> findSwitchIndex(int start, int size,String year);

	int saveSwitch(Tswitch tswitch);

	int update(String year, Double money, String start, String end);

	Tswitch checkYear(String year);

	int delete(String year);

}
