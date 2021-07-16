/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 17:17:38
 * @FilePath: \backstage\front-end\src\main.js
 */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";

import Cookies from "js-cookie";

import App from "./App";
import store from "./store";
import router from "./router";

import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

Vue.use(ElementUI);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
    el: "#app",
    router,
    store,
    render: h => h(App)
});
