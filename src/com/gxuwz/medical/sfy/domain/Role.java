package com.gxuwz.medical.sfy.domain;

/**
 * 角色的实体类
 * 
 *
 */
public class Role {

	private Integer roleId;
	private String roleName;
	private String roleMark;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleMark() {
		return roleMark;
	}
	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleMark=" + roleMark + "]";
	}
	
	
	
}
