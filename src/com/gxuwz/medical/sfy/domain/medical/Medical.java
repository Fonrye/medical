package com.gxuwz.medical.sfy.domain.medical;

/**
 * 医疗机构管理类
 * 
 *
 */
public class Medical {

	/**
	 * 机构编码
	 */
	private String jgbm;
	/**
	 * 组织机构编码
	 */
	private String zzjgbm;
	/**
	 * 机构名称
	 */
	private String jgmc;
	/**
	 * 地区编码
	 */
	private String dqbm;
	/**
	 * 行政区域编码
	 */
	private String areacode;
	/**
	 * 隶属关系
	 */
	private String lsgx;
	
	
	/**
	 * 机构级别
	 */
	private String jgjb;
	/**
	 * 申报定点类型
	 */
	private String sbddlx;
	/**
	 * 批准定点类型
	 */
	private String pzddlx;
	/**
	 * 所属经济类型
	 */
	private String ssjjlx;
	/**
	 * 卫生机构大类
	 */
	private String wsjgdl;
	/**
	 * 卫生机构小类
	 */
	private String wsjgxl;
	
	/**
	 * 主管单位
	 */
	private String zgdw;
	/**
	 * 开业时间
	 */
	private String kysj;
	/**
	 * 法人代表
	 */
	private String frdb;
	/**
	 * 注册资金
	 */
	private double zczj;
	
	public Medical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medical(String jgbm, String zzjgbm, String jgmc, String dqbm, String areacode, String lsgx, String jgjb,
			String sbddlx, String pzddlx, String ssjjlx, String wsjgdl, String wsjgxl, String zgdw, String kysj,
			String frdb, double zczj) {
		super();
		this.jgbm = jgbm;
		this.zzjgbm = zzjgbm;
		this.jgmc = jgmc;
		this.dqbm = dqbm;
		this.areacode = areacode;
		this.lsgx = lsgx;
		this.jgjb = jgjb;
		this.sbddlx = sbddlx;
		this.pzddlx = pzddlx;
		this.ssjjlx = ssjjlx;
		this.wsjgdl = wsjgdl;
		this.wsjgxl = wsjgxl;
		this.zgdw = zgdw;
		this.kysj = kysj;
		this.frdb = frdb;
		this.zczj = zczj;
	}

	public String getJgbm() {
		return jgbm;
	}

	public void setJgbm(String jgbm) {
		this.jgbm = jgbm;
	}

	public String getZzjgbm() {
		return zzjgbm;
	}

	public void setZzjgbm(String zzjgbm) {
		this.zzjgbm = zzjgbm;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getLsgx() {
		return lsgx;
	}

	public void setLsgx(String lsgx) {
		this.lsgx = lsgx;
	}

	public String getJgjb() {
		return jgjb;
	}

	public void setJgjb(String jgjb) {
		this.jgjb = jgjb;
	}

	public String getSbddlx() {
		return sbddlx;
	}

	public void setSbddlx(String sbddlx) {
		this.sbddlx = sbddlx;
	}

	public String getPzddlx() {
		return pzddlx;
	}

	public void setPzddlx(String pzddlx) {
		this.pzddlx = pzddlx;
	}

	public String getSsjjlx() {
		return ssjjlx;
	}

	public void setSsjjlx(String ssjjlx) {
		this.ssjjlx = ssjjlx;
	}

	public String getWsjgdl() {
		return wsjgdl;
	}

	public void setWsjgdl(String wsjgdl) {
		this.wsjgdl = wsjgdl;
	}

	public String getWsjgxl() {
		return wsjgxl;
	}

	public void setWsjgxl(String wsjgxl) {
		this.wsjgxl = wsjgxl;
	}

	public String getZgdw() {
		return zgdw;
	}

	public void setZgdw(String zgdw) {
		this.zgdw = zgdw;
	}

	public String getKysj() {
		return kysj;
	}

	public void setKysj(String kysj) {
		this.kysj = kysj;
	}

	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	public double getZczj() {
		return zczj;
	}

	public void setZczj(double zczj) {
		this.zczj = zczj;
	}

	@Override
	public String toString() {
		return "Medical [jgbm=" + jgbm + ", zzjgbm=" + zzjgbm + ", jgmc=" + jgmc + ", dqbm=" + dqbm + ", areacode="
				+ areacode + ", lsgx=" + lsgx + ", jgjb=" + jgjb + ", sbddlx=" + sbddlx + ", pzddlx=" + pzddlx
				+ ", ssjjlx=" + ssjjlx + ", wsjgdl=" + wsjgdl + ", wsjgxl=" + wsjgxl + ", zgdw=" + zgdw + ", kysj="
				+ kysj + ", frdb=" + frdb + ", zczj=" + zczj + "]";
	}

	
}
