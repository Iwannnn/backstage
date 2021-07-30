<template>
    <div class="sidebar">
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#d3dce6"
            text-color="#000000"
            active-text-color="#123456"
            :router="true"
        >
            <el-submenu
                v-for="menu in menus"
                :key="menu.menuId"
                :index="menu.component"
            >
                <template slot="title">
                    <span>{{ menu.menuName }}</span>
                </template>
                <el-menu-item-group
                    v-for="content in contents"
                    :key="content.menuId"
                >
                    <template slot="title">{{ content.menuName }}</template>
                    <el-menu-item
                        v-for="item in items"
                        :key="item.menuId"
                        :index="item.component.toString()"
                        v-show="item.parentId === menu.menuId"
                    >
                        <span>
                            {{ item.menuName }}
                        </span>
                    </el-menu-item>
                </el-menu-item-group>
                <el-menu-item
                    v-for="item in items"
                    :key="item.menuId"
                    :index="item.component.toString()"
                    v-show="item.parentId === menu.menuId"
                >
                    <span>
                        {{ item.menuName }}
                    </span>
                </el-menu-item>
            </el-submenu>
        </el-menu>
    </div>
</template>
<script>
import { getMenuList } from "@/api/system/menu.js";
export default {
    name: "sidebar",
    data() {
        return {
            menus: [],
            contents: [],
            items: [],
            isCollapse: true,
        };
    },
    created() {
        getMenuList().then((res) => {
            // console.log(res);
            for (var i = 0; i < res.data.length; i++) {
                if (res.data[i].menuType === "M") {
                    this.menus.push(res.data[i]);
                } else if (res.data[i].menuType === "C") {
                    this.contents.push(res.data[i]);
                } else {
                    this.items.push(res.data[i]);
                }
            }
            // console.log(this.menus);
            // console.log(this.contents);
            // console.log(this.items);
        });
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
    },
};
</script>
<style>
</style>