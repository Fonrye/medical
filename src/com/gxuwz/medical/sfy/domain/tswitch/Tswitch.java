package com.gxuwz.medical.sfy.domain.tswitch;

/**
 * 参合设置表实体类
 *
 *
 */
public class Tswitch {

	private String year;  //当前年份
	private String money; //缴费金额
	private String start; //缴费开始时间
	private String end;   //缴费结束时间
	
	public Tswitch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tswitch(String year, String money, String start, String end) {
		super();
		this.year = year;
		this.money = money;
		this.start = start;
		this.end = end;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "tswitch [year=" + year + ", money=" + money + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
