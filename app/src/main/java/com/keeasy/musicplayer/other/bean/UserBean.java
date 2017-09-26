package com.keeasy.musicplayer.other.bean;

import java.io.Serializable;

public class UserBean implements Serializable{
	public static final long serialVersionUID = 1L;
	public String userId ;//用户ID
	public String name ;//昵称
	public String mobile ;//手机
	public String password;//密码
	public Integer userType;//用户角色
	public String imageUrl; //图片地址
	public Integer userLevel;//用户等级

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}


	public String getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}

	//1是已经登录，0是。。
	public String isLogin="0";//是否登录
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userId:"+userId+"手机："+mobile+"密码："+password;
	}
}
