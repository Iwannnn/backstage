import request from "@/utils/request"

export function getUserList(pageRequest) {
	return request({
		url: "/company/user/getUserList",
		method: "post",
		data: pageRequest
	})
}

export function addUser(userInfo) {
	return request({
		url: "/compant/user/addUser",
		method: "post",
		data: userInfo
	})
}

export function delUser(userId) {
	return request({
		url: "/compant/user/delUser",
		method: "get",
		data: userId
	})
}

export function updateUser(userInfo) {
	return request({
		url: "/compant/user/updateUser",
		method: "post",
		data: userInfo
	})
}