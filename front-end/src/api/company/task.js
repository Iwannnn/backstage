
import request from "@/utils/request"

export function getTaskList(pageRequest) {
	const data = {
		pageNum: pageRequest.pageNum,
		pageSize: pageRequest.pageSize
	};
	console.log(data);
	return request({
		url: "/company/task/getTaskList",
		method: "post",
		data: data
	})
}