package cn.iwannnn.backstage.domain;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String deptId;
	private String account;
	private String password;
	private String nickname;
	private String sex;
	private String email;
	private String phonenumber;
	private String isDelete;
	private String loginIp;
	private String loginTime;
	private String createTime;
	private String UpdateTime;
	private String remark;

}
