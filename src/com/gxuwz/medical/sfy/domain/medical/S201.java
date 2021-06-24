package com.gxuwz.medical.sfy.domain.medical;

/**
 * 基础数据模块
 * 
 *
 */
public class S201 {

	private int id;
	private String itemcode;
	private String itemname;
	private String type;
	
	public S201() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public S201(String itemname) {
		super();
		this.itemname = itemname;
	}


	public S201(int id, String itemcode, String itemname, String type) {
		super();
		this.id = id;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "S201 [id=" + id + ", itemcode=" + itemcode + ", itemname=" + itemname + ", type=" + type + "]";
	}
	
	
}
