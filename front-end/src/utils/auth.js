/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 11:40:42
 * @FilePath: \backstage\front-end\src\utils\auth.js
 */

import Cookies from "js-cookie";

const TokenKey = "Admin-Token";

export function getToken() {
    return Cookies.get(TokenKey);
}

export function setToken(token) {
    return Cookies.set(TokenKey, token);
}

export function removeToken() {
    return Cookies.remove(TokenKey);
}
