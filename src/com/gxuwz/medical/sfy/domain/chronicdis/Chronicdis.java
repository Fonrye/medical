package com.gxuwz.medical.sfy.domain.chronicdis;

/**
 * 慢性病分类管理类
 * 
 *
 */
public class Chronicdis {

	//疾病编码
	private String illCode;
	//疾病名称
	private String illName;
	//疾病拼音码
	private String pyCode;
	//疾病五笔码
	private String wbCode;
	
	public Chronicdis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chronicdis(String illCode, String illName, String pyCode, String wbCode) {
		super();
		this.illCode = illCode;
		this.illName = illName;
		this.pyCode = pyCode;
		this.wbCode = wbCode;
	}

	public String getIllCode() {
		return illCode;
	}

	public void setIllCode(String illCode) {
		this.illCode = illCode;
	}

	public String getIllName() {
		return illName;
	}

	public void setIllName(String illName) {
		this.illName = illName;
	}

	public String getPyCode() {
		return pyCode;
	}

	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	public String getWbCode() {
		return wbCode;
	}

	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}

	@Override
	public String toString() {
		return "Chronicdis [illCode=" + illCode + ", illName=" + illName + ", pyCode=" + pyCode + ", wbCode=" + wbCode
				+ "]";
	}
	
	
	
	
}
