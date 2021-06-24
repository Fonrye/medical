package com.gxuwz.medical.sfy.domain;

public class MenuTree {

	private String id;//权限id
	private String name;//权限名称
	private String MenuPid;//父节点id\上一级id
//	private String url;//URL
	private String target;//right
	private boolean checked;
	
	public MenuTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuTree(String id, String name, String menuPid, String target, boolean checked) {
		super();
		this.id = id;
		this.name = name;
		MenuPid = menuPid;
		this.target = target;
		this.checked = checked;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuTree [id=" + id + ", name=" + name + ", MenuPid=" + MenuPid + ", target=" + target + ", checked="
				+ checked + "]";
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the menuPid
	 */
	public String getMenuPid() {
		return MenuPid;
	}
	/**
	 * @param menuPid the menuPid to set
	 */
	public void setMenuPid(String menuPid) {
		MenuPid = menuPid;
	}
	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * @return the check
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param check the check to set
	 */
	public void setChecked(boolean check) {
		this.checked = check;
	}
	
}
