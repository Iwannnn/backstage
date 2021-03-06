package cn.iwannnn.backstage.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.iwannnn.backstage.utils.Md5Utils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class CompanyUser {
	@TableId(value = "user_id", type = IdType.AUTO)
	private String userId;

	private String deptId;

	private String username;

	@Setter(AccessLevel.NONE)
	private String password;

	private String nickname;

	private String sex;

	private String email;

	private String phonenumber;

	private String isDelete;

	private String loginIp;

	@TableField(fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String loginTime;

	@TableField(fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String createTime;

	@TableField(fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String updateTime;

	private String remark;

	public void setPassword(String value) {
		this.password = Md5Utils.createMD5(value);
	}

}
