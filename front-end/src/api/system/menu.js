import request from '@/utils/request';


export function getMenuList() {
	return request({
		url: "/getMenuList",
		method: "get",
	});
}