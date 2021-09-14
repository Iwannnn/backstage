import request from "@/utils/request"

export function getTaskList(queryParams) {
	return request({
		url: "/company/task/getTaskList",
		method: "post",
		data: queryParams
	})
}


export function delTask(taskId) {
	return request({
		url: "/company/task/delTask",
		method: "get",
		params: { taskId: taskId }
	})
}

export function updateTask(taskInfo) {
	return request({
		url: "/company/task/updateTask",
		method: "post",
		data: taskInfo
	})
}