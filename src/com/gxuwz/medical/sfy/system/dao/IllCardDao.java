package com.gxuwz.medical.sfy.system.dao;

import java.util.List;

import com.gxuwz.medical.sfy.domain.illcard.IllCard;

public interface IllCardDao {

	int findIllCardSize(String illCardId, String sfzh, String nhzh, String illName,String xm);

	List<IllCard> findIllCardIndex(int start, int size, String illCardId, String sfzh, String nhzh, String illName,String xm);

	List<IllCard> findIllCardByXm(String xm);

	int saveIllCard(IllCard illcard);

	int delete(int id);

	List<IllCard> findIllcardById(int id);

	int update(IllCard ic);

	List<IllCard> getAll(String xm);

	List<IllCard> findSfzh(String sfzh);

	IllCard checkIllcard(String illName, String jzsj, String sfzh);

}
