package com.gxuwz.medical.sfy.domain;

public class Menu {

	private Integer menuId;
	private Integer menMenuId;
	private String parentMenuName;
	private String menuName;
	private String menuUrl;
	private String menuMark;
	//判断是否有子节点 有 1 无 0 
	private String isMark;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getMenMenuId() {
		return menMenuId;
	}
	public void setMenMenuId(Integer menMenuId) {
		this.menMenuId = menMenuId;
	}
	public String getParentMenuName() {
		return parentMenuName;
	}
	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuMark() {
		return menuMark;
	}
	public void setMenuMark(String menuMark) {
		this.menuMark = menuMark;
	}
	public String getIsMark() {
		return isMark;
	}
	public void setIsMark(String isMark) {
		this.isMark = isMark;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menMenuId=" + menMenuId + ", parentMenuName=" + parentMenuName
				+ ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuMark=" + menuMark + ", isMark=" + isMark
				+ "]";
	}
	
	
	
}
