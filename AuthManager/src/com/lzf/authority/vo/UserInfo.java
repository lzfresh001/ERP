package com.lzf.authority.vo;

import java.util.Date;

public class UserInfo {
	// 用户编号
    private Integer userId;
    // 用户组编号
    private Integer groupId;
    // 用户昵称
    private String nickName;
    // 用户账号
    private String userCode;
    // 用户密码
    private String userPwd;
    // 用户类型
    private String userType;

    private String userState;

    private String isDelete;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;
    
    // 关联role 一对一
    private Role role;
    // 管理user_group 一对一
    private UserGroup userGroup;
    

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", groupId=" + groupId + ", nickName=" + nickName + ", userCode="
				+ userCode + ", userPwd=" + userPwd + ", userType=" + userType + ", userState=" + userState
				+ ", isDelete=" + isDelete + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + ", role=" + role + ", userGroup=" + userGroup + "]";
	}
	
	
    
}