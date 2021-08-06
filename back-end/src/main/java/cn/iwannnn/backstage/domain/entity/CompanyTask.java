package cn.iwannnn.backstage.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CompanyTask {

	@TableId(value = "id")
	private String taskId;

	private String taskName;

	private String leaderId;

	private String leaderName;

	private String phone;

	private String email;

	private String createBy;

	@TableField(fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String createTime;

	private String updateBy;

	@TableField(fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String updateTime;

	private String remark;

}
