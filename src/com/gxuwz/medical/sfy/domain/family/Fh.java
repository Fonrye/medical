package com.gxuwz.medical.sfy.domain.family;

public class Fh {
	private String Pid;//家庭编号
	private String id;//农合证号
	private String name;//姓名
	public Fh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fh(String pid, String id, String name) {
		super();
		Pid = pid;
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pa [Pid=" + Pid + ", id=" + id + ", name=" + name + "]";
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
