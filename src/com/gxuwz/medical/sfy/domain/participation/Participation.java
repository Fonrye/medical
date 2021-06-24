package com.gxuwz.medical.sfy.domain.participation;

/**
 * 参合缴费登记实例
 * 
 *
 */
public class Participation {

	private int id;
	
	private String chzh;  //参合证号
	
	private String chfph;  //参合发票号
	
	private String jfje;   //缴费金额
	
	private String jfnd;  //缴费年度
	
	private String jfsj;  //缴费时间
	
	private String czy;   //操作员
	
	private String jtbh;  //家庭编号
	
	private String sfzh;
	
	private String xm;

	public Participation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participation(int id, String chzh, String chfph, String jfje, String jfnd, String jfsj, String czy,
			String jtbh, String sfzh, String xm) {
		super();
		this.id = id;
		this.chzh = chzh;
		this.chfph = chfph;
		this.jfje = jfje;
		this.jfnd = jfnd;
		this.jfsj = jfsj;
		this.czy = czy;
		this.jtbh = jtbh;
		this.sfzh = sfzh;
		this.xm = xm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChzh() {
		return chzh;
	}

	public void setChzh(String chzh) {
		this.chzh = chzh;
	}

	public String getChfph() {
		return chfph;
	}

	public void setChfph(String chfph) {
		this.chfph = chfph;
	}

	public String getJfje() {
		return jfje;
	}

	public void setJfje(String jfje) {
		this.jfje = jfje;
	}

	public String getJfnd() {
		return jfnd;
	}

	public void setJfnd(String jfnd) {
		this.jfnd = jfnd;
	}

	public String getJfsj() {
		return jfsj;
	}

	public void setJfsj(String jfsj) {
		this.jfsj = jfsj;
	}

	public String getCzy() {
		return czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getJtbh() {
		return jtbh;
	}

	public void setJtbh(String jtbh) {
		this.jtbh = jtbh;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", chzh=" + chzh + ", chfph=" + chfph + ", jfje=" + jfje + ", jfnd=" + jfnd
				+ ", jfsj=" + jfsj + ", czy=" + czy + ", jtbh=" + jtbh + ", sfzh=" + sfzh + ", xm=" + xm + "]";
	}

	
}
