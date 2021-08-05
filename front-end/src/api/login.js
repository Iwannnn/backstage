import request from "@/utils/request";


// 登录方法
export function login(username, password) {
	const data = {
		username,
		password,
	};
	console.log(data);
	return request({
		url: "/company/login",
		method: "post",
		data: data
	});
}
