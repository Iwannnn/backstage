/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-16 14:35:14
 * @FilePath: \backstage\front-end\src\store\modules\user.js
 */

import { login, logout } from "@/api/login";
import { getToken, setToken, removeToken } from "@/utils/auth";

const user = {
	state: {
		token: getToken(),
		name: ""
	},
	mutations: {
		SET_TOKEN: (state, token) => {
			state.token = token;
		},
		SET_NAME: (state, name) => {
			state.name = name;
		}
	},
	actions: {
		Login({ commit }, loginInfo) {
			console.log("store user");
			console.log(loginInfo);
			const username = loginInfo.account.trim();
			const password = loginInfo.password;
			const uuid = loginInfo.uuid;
			return new Promise((resolve, reject) => {
				login(username, password, uuid)
					.then(res => {
						console.log(res);
						setToken(res.data);
						commit("SET_TOKEN", res.data);
						resolve();
					})
					.catch(error => {
						reject(error);
					});
			});
		},
		Logout({ commit, state }) {
			return new Promise((resolve, reject) => {
				logout(state, token)
					.then(() => {
						commit("SET_TOKEN", "");
						removeToken();
						resolve();
					})
					.catch(error => {
						reject(error);
					});
			});
		}
	}
};

export default user;
