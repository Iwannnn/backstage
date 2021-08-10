<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
            <el-breadcrumb-item><a href="/">首页</a></el-breadcrumb-item>
            <el-breadcrumb-item
                v-for="(item, index) in $route.meta"
                v-bind:key="index"
            >
                {{ item }}
            </el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>

<script>
export default {
    name: "breadcrumb",
};
</script>

