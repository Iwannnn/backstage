import request from '@/utils/request';


export function getMenuList() {
	return request({
		url: "/system/menu/getMenuList",
		method: "get",
	});
}