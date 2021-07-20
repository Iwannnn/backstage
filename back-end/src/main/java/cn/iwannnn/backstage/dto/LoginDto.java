package cn.iwannnn.backstage.dto;

import lombok.Data;

@Data
public class LoginDto {
	private String account;
	private String password;
	private String uuid;
}
