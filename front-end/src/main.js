/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-14 21:15:12
 * @FilePath: \backstage\front-end\src\main.js
 */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import App from "./App";
import Vue from "vue";
import router from "./router";
import store from "./store";

Vue.use(router);
Vue.config.productionTip = false;
/* eslint-disable no-new */
new Vue({
    el: "#app",
    router,
    store,
    components: { App },
    template: "<App/>"
});
