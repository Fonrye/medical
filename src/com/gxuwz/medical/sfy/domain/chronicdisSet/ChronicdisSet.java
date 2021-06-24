package com.gxuwz.medical.sfy.domain.chronicdisSet;
/**
 * 慢病报销管理类
 * 
 *
 */
public class ChronicdisSet {

	private int id;          
	private String year;         //年度
	private String illName;      //慢性病名称
	private String moneyCapping; //封顶线
	private String percentage;   //报销百分比
	
	public ChronicdisSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChronicdisSet(int id, String year, String illName, String moneyCapping, String percentage) {
		super();
		this.id = id;
		this.year = year;
		this.illName = illName;
		this.moneyCapping = moneyCapping;
		this.percentage = percentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIllName() {
		return illName;
	}

	public void setIllName(String illName) {
		this.illName = illName;
	}

	public String getMoneyCapping() {
		return moneyCapping;
	}

	public void setMoneyCapping(String moneyCapping) {
		this.moneyCapping = moneyCapping;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "ChronicdisSet [id=" + id + ", year=" + year + ", illName=" + illName + ", moneyCapping=" + moneyCapping
				+ ", percentage=" + percentage + "]";
	}
	
	
	
}
