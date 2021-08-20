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
		path: "/register",
		component: resolve => require(["@/views/register"], resolve),
		hidden: true
	},
	{
		path: "/redirect",
		name: "redirect",
		component: (resolve) => require(["@/views/redirect"], resolve)
	},
	{
		path: "/company",
		name: "company",
		component: Layout,
		children: [
			{
				path: "user",
				name: "user",
				component: (resolve) => require(["@/views/company/user"], resolve),
				meta: {
					breadcrumb: [
						{
							name: "企业管理",
							path: ""
						},
						{
							name: "人员管理",
							path: ""
						}
					]
				}
			},
			{
				path: "dept",
				name: "dept",
				component: (resolve) => require(["@/views/company/dept"], resolve),
				meta: {
					breadcrumb: [
						{
							name: "企业管理",
							path: ""
						},
						{
							name: "部门管理",
							path: ""
						}
					]
				}
			},
			{
				path: "task",
				name: "task",
				component: (resolve) => require(["@/views/company/task"], resolve),
				meta: {
					breadcrumb: [
						{
							name: "企业管理",
							path: ""
						},
						{
							name: "任务管理",
							path: ""
						}
					]
				}
			}
		]
	},
	{
		path: "/system",
		name: "system",
		component: Layout,
		children: [
			{
				path: "druid",
				name: "druid",
				component: (resolve) => require(["@/views/system/druid"], resolve),
				meta: {
					breadcrumb: [
						{
							name: "系统管理",
							path: ""
						},
						{
							name: "数据监控",
							path: ""
						}
					]
				}
			}

		]
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