package com.gxuwz.medical.sfy.domain.family;

/**
 * 参合人员信息表
 * 
 *
 */
public class Familyhold {

	private  int id;
	private String jtbh; //家庭编号
	private String nhzh; //农合证号
	private String ylzkh; //医疗证卡号
	private String hnbh; //户内编号
	private String xm; //姓名
	private String yhzgx; //与户主关系
	private String sfzh; //身份证号
	private String xb; //性别
	private String jkzk; //健康状况
	private String mz; //民族
	private String whcd; //文化程度
	private String nl; //年龄
	private String csrq; //出生日期
	private String rysx; //人员属性
	private String sfnchk; //是否农村户口
	private String zy; //职业
	private String gzdw; //工作单位
	private String lxdh; //联系电话
	private String czdz; //常住地址
	private String moneyState; //参合缴费状态
	
	public Familyhold() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Familyhold(int id, String jtbh, String nhzh, String ylzkh, String hnbh, String xm, String yhzgx, String sfzh,
			String xb, String jkzk, String mz, String whcd, String nl, String csrq, String rysx, String sfnchk,
			String zy, String gzdw, String lxdh, String czdz, String moneyState) {
		super();
		this.id = id;
		this.jtbh = jtbh;
		this.nhzh = nhzh;
		this.ylzkh = ylzkh;
		this.hnbh = hnbh;
		this.xm = xm;
		this.yhzgx = yhzgx;
		this.sfzh = sfzh;
		this.xb = xb;
		this.jkzk = jkzk;
		this.mz = mz;
		this.whcd = whcd;
		this.nl = nl;
		this.csrq = csrq;
		this.rysx = rysx;
		this.sfnchk = sfnchk;
		this.zy = zy;
		this.gzdw = gzdw;
		this.lxdh = lxdh;
		this.czdz = czdz;
		this.moneyState = moneyState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJtbh() {
		return jtbh;
	}

	public void setJtbh(String jtbh) {
		this.jtbh = jtbh;
	}

	public String getNhzh() {
		return nhzh;
	}

	public void setNhzh(String nhzh) {
		this.nhzh = nhzh;
	}

	public String getYlzkh() {
		return ylzkh;
	}

	public void setYlzkh(String ylzkh) {
		this.ylzkh = ylzkh;
	}

	public String getHnbh() {
		return hnbh;
	}

	public void setHnbh(String hnbh) {
		this.hnbh = hnbh;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getYhzgx() {
		return yhzgx;
	}

	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getJkzk() {
		return jkzk;
	}

	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getRysx() {
		return rysx;
	}

	public void setRysx(String rysx) {
		this.rysx = rysx;
	}

	public String getSfnchk() {
		return sfnchk;
	}

	public void setSfnchk(String sfnchk) {
		this.sfnchk = sfnchk;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getGzdw() {
		return gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getCzdz() {
		return czdz;
	}

	public void setCzdz(String czdz) {
		this.czdz = czdz;
	}

	public String getMoneyState() {
		return moneyState;
	}

	public void setMoneyState(String moneyState) {
		this.moneyState = moneyState;
	}

	@Override
	public String toString() {
		return "Familyhold [id=" + id + ", jtbh=" + jtbh + ", nhzh=" + nhzh + ", ylzkh=" + ylzkh + ", hnbh=" + hnbh
				+ ", xm=" + xm + ", yhzgx=" + yhzgx + ", sfzh=" + sfzh + ", xb=" + xb + ", jkzk=" + jkzk + ", mz=" + mz
				+ ", whcd=" + whcd + ", nl=" + nl + ", csrq=" + csrq + ", rysx=" + rysx + ", sfnchk=" + sfnchk + ", zy="
				+ zy + ", gzdw=" + gzdw + ", lxdh=" + lxdh + ", czdz=" + czdz + ", moneyState=" + moneyState + "]";
	}
	
	

}
