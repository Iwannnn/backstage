import request from "@/utils/request"

export function getAllUser(pageRequest) {
	const data = {
		pageNum: pageRequest.pageNum,
		pageSize: pageRequest.pageSize
	};
	console.log(data);
	return request({
		url: "/company/user/getUserList",
		method: "post",
		data: data
	})
}