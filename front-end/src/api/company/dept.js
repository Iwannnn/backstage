import request from "@/utils/request"

export function getDeptList(pageRequest) {
	const data = {
		pageNum: pageRequest.pageNum,
		pageSize: pageRequest.pageSize
	};
	console.log(data);
	return request({
		url: "/company/dept/getDeptList",
		method: "post",
		data: data
	})
}