import Vue from "vue";
import Router from "vue-router";


Vue.use(Router);

const constantRouters = [
	{
		path: "/",
		redirect: "/login"
	},
	{
		path: "/index",
		component: resolve => require(["@/views/index"], resolve),
		hidden: true
	},
	{
		path: "/login",
		component: resolve => require(["@/views/login"], resolve),
		hidden: true
	},
	{
		path: "/401",
		component: resolve => require(["@/views/error/401"], resolve),
		hidden: true
	},
	{
		path: "/404",
		component: resolve => require(["@/views/error/404"], resolve),
		hidden: true
	}
];

export default new Router({
	mode: "history",
	routes: constantRouters
});
