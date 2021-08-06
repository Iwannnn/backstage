import request from "@/utils/request"

export function getDeptList(pageRequest) {
	const data = {
		pageNum: pageRequest.pageNum,
		pageSize: pageRequest.pageSize
	};
	console.log(data);
	return request({
		url: "/company/dept/getDept",
		method: "post",
		data: data
	})
}