import request from "@/utils/request"

export function getDeptList(queryParams) {
	return request({
		url: "/company/dept/getDeptList",
		method: "post",
		data: queryParams
	})
}


export function delDept(deptId) {
	return request({
		url: "/company/dept/delDept",
		method: "get",
		params: { deptId: deptId }
	})
}

export function updateDept(deptInfo) {
	return request({
		url: "/company/dept/updateDept",
		method: "post",
		data: deptInfo
	})
}