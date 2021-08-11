import request from "@/utils/request";


// 登录方法
export function register(username, password, nickname, sex, email, phonenumber) {
	const data = {
		username,
		password,
		nickname,
		sex,
		email,
		phonenumber
	};
	console.log(data);
	return request({
		url: "/company/user/register",
		method: "post",
		data: data
	});
}

