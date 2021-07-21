import request from "@/utils/request";


// 登录方法
export function login(username, password) {
	const data = {
		username,
		password,
	};
	console.log(data);
	return request({
		url: "/login",
		method: "post",
		data: data
	});
}


// 退出方法
export function logout() {
	return request({
		url: "/logout",
		method: "post"
	});
}

