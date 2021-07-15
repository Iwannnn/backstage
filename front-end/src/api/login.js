/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 12:00:09
 * @FilePath: \backstage\front-end\src\api\login.js
 */

import request from "@/utils/request";

export function login(username, password, code, uuid) {
    const data = {
        username,
        password,
        code,
        uuid
    };
    return request({
        url: "/login",
        method: "post",
        data: data
    });
}
