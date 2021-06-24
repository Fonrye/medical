package com.gxuwz.medical.sfy.domain.institution;

/**
 * 农合机构管理类
 * 
 *
 */
public class Institution {

	private String areaCode; //行政区域编号
	private String agenCode; //经办机构编号
	private String agenName; //经办机构名称
	private int grade;  //经办机构级别，区别于行政区域级别，1表示县级农合办，2表示镇级农合点
	
	public Institution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Institution(String areaCode, String agenCode, String agenName, int grade) {
		super();
		this.areaCode = areaCode;
		this.agenCode = agenCode;
		this.agenName = agenName;
		this.grade = grade;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAgenCode() {
		return agenCode;
	}
	public void setAgenCode(String agenCode) {
		this.agenCode = agenCode;
	}
	public String getAgenName() {
		return agenName;
	}
	public void setAgenName(String agenName) {
		this.agenName = agenName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Institution [areaCode=" + areaCode + ", agenCode=" + agenCode + ", agenName=" + agenName + ", grade="
				+ grade + "]";
	}
	
}
