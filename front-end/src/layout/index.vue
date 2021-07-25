<template>
    <el-container>
        <el-header><navbar /></el-header>
        <el-container>
            <el-aside><sidebar /></el-aside>
            <el-container>
                <el-main><router-view /></el-main>
            </el-container>
        </el-container>
        <el-footer>Footer</el-footer>
    </el-container>
</template>

<script>
import sidebar from "@/layout/components/sidebar";
import navbar from "@/layout/components/navbar";
export default {
    name: "Layout",
    components: {
        sidebar,
        navbar,
    },
};
</script>

<style lang="scss" scoped>
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
body > .el-container {
    margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
    line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
    line-height: 320px;
}
</style>
