import request from "@/utils/request";


export function register(registerForm) {
	return request({
		url: "/company/user/addUser",
		method: "post",
		data: registerForm
	});
}

export function checkExist(type, info) {
	const data = {
		type,
		info
	};
	return request({
		url: "/company/user/checkExist",
		method: "post",
		data: data
	})
}
