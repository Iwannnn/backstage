<template>
    <el-container>
        <el-aside width="250px"><sidebar /></el-aside>
        <el-container>
            <el-header><navbar /></el-header>
            <el-main>
                <breadcrumb />
                <keep-alive><router-view /></keep-alive>
            </el-main>
            <el-footer>iwannnn.cn</el-footer>
        </el-container>
    </el-container>
</template>

<script>
import sidebar from "@/layout/components/sidebar";
import navbar from "@/layout/components/navbar";
import breadcrumb from "@/layout/components/breadcrumb";
export default {
    name: "Layout",
    components: {
        sidebar,
        navbar,
        breadcrumb,
    },
};
</script>

<style lang="scss" scoped>
.el-container {
    height: 100%;
}
.el-header,
.el-footer {
    background-color: #b3c0d1;
    color: #333;
    text-align: center;
    line-height: 60px;
}
.el-aside {
    background-color: #d3dce6;
    color: #333;
    text-align: center;
    line-height: 200px;
}
.el-main {
    background-color: #e9eef3;
    color: #333;
    text-align: center;
    line-height: 160px;
}
</style>
