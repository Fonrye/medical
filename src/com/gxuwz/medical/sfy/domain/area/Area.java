package com.gxuwz.medical.sfy.domain.area;

/**
 * 行政区域模板类
 * 
 *
 */
public class Area {

	private String areaCode;  //行政区域编号:县、镇、村、组
	private String areaName;  //行政区域名称
	private int grade;  //行政区级别：1表示县级，2表示镇级，3表示村，4表示组
	
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Area(String areaCode, String areaName, int grade) {
		super();
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.grade = grade;
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Area [areaCode=" + areaCode + ", areaName=" + areaName + ", grade=" + grade + "]";
	}
	
	
	
	
}
