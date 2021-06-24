package com.gxuwz.medical.sfy.domain.illcard;

public class IllCard {

	private int id;
	private String xm; //姓名
	private String illCardId; //慢病证号
	private String sfzh;  //身份证号
	private String nhzh;  //农合证号
	private String illName;  //疾病名称
	private String startTime;  //开始时间
	private String endTime; //结束时间
	
	public IllCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllCard(int id, String xm, String illCardId, String sfzh, String nhzh, String illName, String startTime,
			String endTime) {
		super();
		this.id = id;
		this.xm = xm;
		this.illCardId = illCardId;
		this.sfzh = sfzh;
		this.nhzh = nhzh;
		this.illName = illName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getIllCardId() {
		return illCardId;
	}

	public void setIllCardId(String illCardId) {
		this.illCardId = illCardId;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getNhzh() {
		return nhzh;
	}

	public void setNhzh(String nhzh) {
		this.nhzh = nhzh;
	}

	public String getIllName() {
		return illName;
	}

	public void setIllName(String illName) {
		this.illName = illName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "IllCard [id=" + id + ", xm=" + xm + ", illCardId=" + illCardId + ", sfzh=" + sfzh + ", nhzh=" + nhzh
				+ ", illName=" + illName + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
