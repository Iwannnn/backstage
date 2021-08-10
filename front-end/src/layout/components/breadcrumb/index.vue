<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item
                v-for="item in breadcrumb"
                v-bind:key="item.name"
            >
                {{ item.name }}
            </el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>

<script>
export default {
    name: "breadcrumb",
    computed: {
        breadcrumb() {
            return this.$route.meta.breadcrumb;
        },
    },
};
</script>

