package com.gxuwz.medical.sfy.domain;

/**
 * 用户信息管理实体类对象
 * 
 *
 */
public class User {

	private Integer userId;
	private String userName;
	private String userNumber;
	private String userPwd;
	private String userMark;
	private Integer roleId;
	private String roleName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userNumber=" + userNumber + ", userPwd="
				+ userPwd + ", userMark=" + userMark + ", roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
	
}
