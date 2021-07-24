import Vue from "vue";
import Router from "vue-router";
import Layout from "@/layout"


Vue.use(Router);

const constantRouters = [
	{
		path: "/",
		component: Layout,
		redirect: "index",
		children: [
			{
				path: "/index",
				component: resolve => require(["@/views/index"], resolve),
				hidden: true
			},
		]
	},
	{
		path: "/login",
		component: resolve => require(["@/views/login"], resolve),
		hidden: true
	},
	{
		path: "/redirect",
		name: "redirect",
		component: (resolve) => require(["@/views/redirect"], resolve)
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
