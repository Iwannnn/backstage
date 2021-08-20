import request from "@/utils/request"

export function getUserList(queryParams) {
	return request({
		url: "/company/user/getUserList",
		method: "post",
		data: queryParams
	})
}


export function delUser(userId) {
	return request({
		url: "/company/user/delUser",
		method: "get",
		params: { userId: userId }
	})
}

export function updateUser(userInfo) {
	return request({
		url: "/company/user/updateUser",
		method: "post",
		data: userInfo
	})
}