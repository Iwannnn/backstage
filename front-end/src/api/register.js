import request from "@/utils/request";


// 登录方法
export function register(registerForm) {
	let username = registerForm.username
	let password = registerForm.password
	let nickname = registerForm.nickname
	let sex = registerForm.sex
	let email = registerForm.email
	let phonenumber = registerForm.phonenumber
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

