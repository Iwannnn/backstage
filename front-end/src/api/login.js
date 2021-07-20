import request from "@/utils/request";

// 登录方法
export function login(account, password, uuid) {
	const data = {
		account,
		password,
		uuid
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

export function getUUID() {
	return request({
		url: "/getUUID",
		method: "get"
	})
}