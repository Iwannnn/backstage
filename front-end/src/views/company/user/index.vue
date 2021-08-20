<template>
    <div>
        <el-form :model="queryParams" ref="queryForm" label-width="60px">
            <el-row>
                <el-col :span="1.5">
                    <el-form-item label="用户名">
                        <el-input
                            v-model="queryParams.username"
                            placeholder="请输入用户名"
                            clearable
                            size="small"
                        />
                    </el-form-item>
                </el-col>
                <el-col :span="1.5">
                    <el-form-item label="昵称">
                        <el-input
                            v-model="queryParams.nickname"
                            placeholder="请输入昵称"
                            clearable
                            size="small"
                        />
                    </el-form-item>
                </el-col>
                <el-col :span="1.5">
                    <el-form-item label="邮箱">
                        <el-input
                            v-model="queryParams.email"
                            placeholder="请输入邮箱"
                            clearable
                            size="small"
                        />
                    </el-form-item>
                </el-col>
                <el-col :span="1.5">
                    <el-form-item label="电话">
                        <el-input
                            v-model="queryParams.phonenumber"
                            placeholder="请输入电话"
                            clearable
                            size="small"
                        />
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="1.5">
                    <el-button
                        type="primary"
                        icon="el-icon-search"
                        size="mini"
                        @click="handleQuery"
                        >搜索
                    </el-button>
                </el-col>
                <el-col :span="1.5">
                    <el-button
                        icon="el-icon-refresh"
                        size="mini"
                        @click="resetQuery"
                        >重置
                    </el-button>
                </el-col>
            </el-row>
        </el-form>
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button
                    type="primary"
                    plain
                    icon="el-icon-plus"
                    size="mini"
                    @click="handleAdd"
                    >新增</el-button
                >
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="warning"
                    plain
                    icon="el-icon-download"
                    size="mini"
                    @click="handleExport"
                    >导出</el-button
                >
            </el-col>
            <el-col :span="1.5">
                <el-upload
                    :show-file-list="false"
                    accept=".xlsx"
                    action="http://localhost:8080/company/user/importData"
                    style="display: inline"
                >
                    <el-button
                        size="mini"
                        plain
                        type="warning"
                        icon="el-icon-upload2"
                        >导入</el-button
                    >
                </el-upload>
            </el-col>
        </el-row>
        <el-dialog :visible.sync="open">
            <registerform :redirectPath="'/company/user'" />
        </el-dialog>
        <el-table :data="pageInfo.list">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="用户id" align="center" prop="userId" />
            <el-table-column label="部门id" align="center" prop="deptId" />
            <el-table-column label="账号名" align="center" prop="username" />
            <el-table-column label="昵称" align="center" prop="nickname" />
            <el-table-column label="性别" align="center" prop="sex" />
            <el-table-column label="邮箱" align="center" prop="email" />
            <el-table-column label="电话" align="center" prop="phonenumber" />
            <el-table-column
                label="操作"
                align="center"
                class-name="small-padding fixed-width"
            >
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-edit"
                        @click="handleUpdate(scope.row)"
                        >修改</el-button
                    >
                    <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-delete"
                        @click="handleDelete(scope.row)"
                        >删除</el-button
                    >
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
            v-show="total"
            :total="total"
            :current-page.sync="pageRequest.pageNum"
            :page-size.sync="pageRequest.pageSize"
            @prev-click="prevClick"
            @next-click="nextClick"
        />
    </div>
</template>

<script>
import { getUserList, delUser, updateUser } from "@/api/company/user";
import registerform from "@/views/components/register";
export default {
    name: "User",
    data() {
        return {
            pageRequest: {
                pageNum: 1,
                pageSize: 10,
            },
            userList: [],
            pageInfo: {},
            total: 1,
            queryParams: {
                username: "",
                nickname: "",
                email: "",
                phonenumber: "",
            },
            open: false,
            baseUrl: process.env.VUE_APP_BASE_API,
        };
    },
    components: {
        registerform,
    },
    created() {
        this.getList();
    },
    methods: {
        getList() {
            getUserList(this.pageRequest).then((res) => {
                console.log(res.data.list);
                this.pageInfo = res.data;
                this.total = res.data.total;
            });
        },
        handleAdd() {
            this.open = true;
        },
        handleUpdate() {},
        handleDelete(row) {
            delUser(row.userId).then((res) => {
                console.log(res);
                if (res.code === 200) {
                    this.getList();
                }
            });
        },
        handleExport() {},
        handleQuery() {},
        resetQuery() {
            this.queryParams = {
                username: "",
                nickname: "",
                email: "",
                phonenumber: "",
            };
        },
        nextClick() {
            this.pageRequest.pageNum++;
            this.getList();
        },
        prevClick() {
            this.pageRequest.pageNum--;
            this.getList();
        },
    },
};
</script>
<style scoped>
.el-row {
    line-height: 60px;
}
</style>