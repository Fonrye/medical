package com.gxuwz.medical.sfy.domain;

public class Utils {

	private String areaCode;  //行政区域编号:县、镇、村、组
	private String areaName;  //行政区域名称
    private String xjbh; //县级编号
	private String xzbh; //乡镇编号
	private String cbh;  //村编号
	private String zbh;  //组编号
	private String jtbh; //家庭编号
	
	public Utils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utils(String areaCode, String areaName, String xjbh, String xzbh, String cbh, String zbh, String jtbh) {
		super();
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.xjbh = xjbh;
		this.xzbh = xzbh;
		this.cbh = cbh;
		this.zbh = zbh;
		this.jtbh = jtbh;
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

	public String getXjbh() {
		return xjbh;
	}

	public void setXjbh(String xjbh) {
		this.xjbh = xjbh;
	}

	public String getXzbh() {
		return xzbh;
	}

	public void setXzbh(String xzbh) {
		this.xzbh = xzbh;
	}

	public String getCbh() {
		return cbh;
	}

	public void setCbh(String cbh) {
		this.cbh = cbh;
	}

	public String getZbh() {
		return zbh;
	}

	public void setZbh(String zbh) {
		this.zbh = zbh;
	}

	public String getJtbh() {
		return jtbh;
	}

	public void setJtbh(String jtbh) {
		this.jtbh = jtbh;
	}

	@Override
	public String toString() {
		return "Utils [areaCode=" + areaCode + ", areaName=" + areaName + ", xjbh=" + xjbh + ", xzbh=" + xzbh + ", cbh="
				+ cbh + ", zbh=" + zbh + ", jtbh=" + jtbh + "]";
	}
	
	
}
