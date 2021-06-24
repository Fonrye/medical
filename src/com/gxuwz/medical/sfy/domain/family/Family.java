package com.gxuwz.medical.sfy.domain.family;

/**
 *参合家庭档案类
 * 
 *
 */
public class Family {

	private String xjbh; //县级编号
	
	private String xzbh; //乡镇编号
	
	private String cbh;  //村编号
	
	private String zbh;  //组编号
	
	private String jtbh; //家庭编号
	
	private String hsx;  //户属性
	
	private String hzxm; //户主姓名
	
	private String jtrks; //家庭人口数
	
	private String nyrks; //农业人口数
	
	private String jtdz;  //家庭住址
	
	private String cjdasj; //创建档案时间
	
	private String djy; //登记员

	public Family() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Family(String xjbh, String xzbh, String cbh, String zbh, String jtbh, String hsx, String hzxm, String jtrks,
			String nyrks, String jtdz, String cjdasj, String djy) {
		super();
		this.xjbh = xjbh;
		this.xzbh = xzbh;
		this.cbh = cbh;
		this.zbh = zbh;
		this.jtbh = jtbh;
		this.hsx = hsx;
		this.hzxm = hzxm;
		this.jtrks = jtrks;
		this.nyrks = nyrks;
		this.jtdz = jtdz;
		this.cjdasj = cjdasj;
		this.djy = djy;
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

	public String getHsx() {
		return hsx;
	}

	public void setHsx(String hsx) {
		this.hsx = hsx;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getJtrks() {
		return jtrks;
	}

	public void setJtrks(String jtrks) {
		this.jtrks = jtrks;
	}

	public String getNyrks() {
		return nyrks;
	}

	public void setNyrks(String nyrks) {
		this.nyrks = nyrks;
	}

	public String getJtdz() {
		return jtdz;
	}

	public void setJtdz(String jtdz) {
		this.jtdz = jtdz;
	}

	public String getCjdasj() {
		return cjdasj;
	}

	public void setCjdasj(String cjdasj) {
		this.cjdasj = cjdasj;
	}

	public String getDjy() {
		return djy;
	}

	public void setDjy(String djy) {
		this.djy = djy;
	}

	@Override
	public String toString() {
		return "Family [xjbh=" + xjbh + ", xzbh=" + xzbh + ", cbh=" + cbh + ", zbh=" + zbh + ", jtbh=" + jtbh + ", hsx="
				+ hsx + ", hzxm=" + hzxm + ", jtrks=" + jtrks + ", nyrks=" + nyrks + ", jtdz=" + jtdz + ", cjdasj="
				+ cjdasj + ", djy=" + djy + "]";
	}
	
	
}
