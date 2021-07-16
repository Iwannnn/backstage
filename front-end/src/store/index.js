/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-16 14:54:19
 * @FilePath: \backstage\front-end\src\store\index.js
 */
import Vue from "vue";
import Vuex from "vuex";
import user from "./modules/user";
import getters from "./getters";

Vue.use(Vuex);

const store = new Vuex.Store({
    modules: {
        user
    },
    getters
});

export default store;
