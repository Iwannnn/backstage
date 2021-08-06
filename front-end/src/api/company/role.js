import request from "@/utils/request"

export function getRoleList(pageRequest) {
	const data = {
		pageNum: pageRequest.pageNum,
		pageSize: pageRequest.pageSize
	};
	console.log(data);
	return request({
		url: "/company/role/getRoleList",
		method: "post",
		data: data
	})
}