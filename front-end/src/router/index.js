import Vue from "vue";
import Router from "vue-router";
import HelloWorld from "@/components/HelloWorld";

Vue.use(Router);

export const constantRoutes = [];
export default new Router({
    mode: "history", // 去掉url中的#
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
});
