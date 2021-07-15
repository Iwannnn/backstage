/*
 * @Author: iwan
 * @Description: 路由文件
 * @Date: 2021-07-15 17:17:38
 * @FilePath: \backstage\front-end\src\router\index.js
 */
import Vue from "vue";
import Router from "vue-router";
import HelloWorld from "@/components/HelloWorld";

Vue.use(Router);

const constantRouters = [
    {
        path: "/",
        name: "HelloWorld",
        component: HelloWorld
    },
    {
        path: "/login",
        component: resolve => require(["@/views/login.vue"], resolve),
        hidden: true
    },
    {
        path: "/401",
        component: resolve => require(["@/views/error/401.vue"], resolve),
        hidden: true
    },
    {
        path: "/404",
        component: resolve => require(["@/views/error/404.vue"], resolve),
        hidden: true
    }
];

export default new Router({
    mode: "history",
    routes: constantRouters
});
