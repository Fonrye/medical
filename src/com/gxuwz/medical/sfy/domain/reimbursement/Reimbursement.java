package com.gxuwz.medical.sfy.domain.reimbursement;

public class Reimbursement {

	private int id;
	private String name;  //姓名
	private String illcardNo; //慢病证号
	private String sfzh;  //身份号
	private String nhzh;  //农合证号
	private String illname; //疾病名称
	private String illMoney; //医疗费用
	private String money;   //本次报销金额
	private String yyfph;  //医院发票号
	private String jzsj;  //就诊时间
	private String status; //状态
	private String bxsj;  //报销时间
	private String year;  //报销年份
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, String name, String illcardNo, String sfzh, String nhzh, String illname,
			String illMoney, String money, String yyfph, String jzsj, String status, String bxsj, String year) {
		super();
		this.id = id;
		this.name = name;
		this.illcardNo = illcardNo;
		this.sfzh = sfzh;
		this.nhzh = nhzh;
		this.illname = illname;
		this.illMoney = illMoney;
		this.money = money;
		this.yyfph = yyfph;
		this.jzsj = jzsj;
		this.status = status;
		this.bxsj = bxsj;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIllcardNo() {
		return illcardNo;
	}

	public void setIllcardNo(String illcardNo) {
		this.illcardNo = illcardNo;
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

	public String getIllname() {
		return illname;
	}

	public void setIllname(String illname) {
		this.illname = illname;
	}

	public String getIllMoney() {
		return illMoney;
	}

	public void setIllMoney(String illMoney) {
		this.illMoney = illMoney;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getYyfph() {
		return yyfph;
	}

	public void setYyfph(String yyfph) {
		this.yyfph = yyfph;
	}

	public String getJzsj() {
		return jzsj;
	}

	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBxsj() {
		return bxsj;
	}

	public void setBxsj(String bxsj) {
		this.bxsj = bxsj;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", name=" + name + ", illcardNo=" + illcardNo + ", sfzh=" + sfzh + ", nhzh="
				+ nhzh + ", illname=" + illname + ", illMoney=" + illMoney + ", money=" + money + ", yyfph=" + yyfph
				+ ", jzsj=" + jzsj + ", status=" + status + ", bxsj=" + bxsj + ", year=" + year + "]";
	}

	
	
}
