package cn.iwannnn.backstage.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CompanyDept {

	@TableId(value = "dept_id", type = IdType.AUTO)
	private String deptId;

	private String parentId;

	private String deptName;

	private String orderNum;

	private String userId;

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
