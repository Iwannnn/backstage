<template>
    <div>
        <el-form :model="queryParams" ref="queryForm" label-width="60px">
            <el-row>
                <el-col :span="1.5">
                    <el-form-item label="任务名">
                        <el-input
                            v-model="queryParams.username"
                            placeholder="请输入用户"
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
                    action="http://localhost:8080/company/task/importData"
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
        <el-dialog
            :visible.sync="updateopen"
            width="500px"
            @close="getList"
            append-to-body
        >
            <updateForm :tittle="tittle" :updateForm="form" />
        </el-dialog>
        <el-table :data="pageInfo.list">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="部门id" align="center" prop="deptId" />
            <el-table-column label="部门名称" align="center" prop="deptName" />
            <el-table-column
                label="上级部门id"
                align="center"
                prop="parentId"
            />
            <el-table-column label="负责人id" align="center" prop="userId" />
            <el-table-column label="部门描述" align="center" prop="remark" />
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
            :current-page.sync="queryParams.pageNum"
            :page-size.sync="queryParams.pageSize"
            @prev-click="handlePrevClick"
            @next-click="handleNextClick"
            @current-change="handleCurrentChange"
        />
    </div>
</template>

<script>
import { getDeptList } from "@/api/company/dept";
export default {
    name: "Dept",
    data() {
        return {
            deptList: [],
            pageInfo: {},
            total: 1,
            queryParams: {
                pageNum: 1,
                pageSize: 10,
            },
            form: {},
            tittle: "",
            updateopen: false,
            dialogTittle: "",
            baseUrl: process.env.VUE_APP_BASE_API,
        };
    },
    created() {
        this.getList();
    },
    methods: {
        getList() {
            console.log("get");
            getDeptList(this.queryParams).then((res) => {
                console.log(res.data.list);
                this.pageInfo = res.data;
                this.total = res.data.total;
            });
        },
        handleAdd() {
            this.resetForm();
            this.tittle = "添加部门";
        },
        handleUpdate(row) {
            this.updateopen = true;
            this.tittle = "修改部门信息";
            this.form = {
                deptId: row.deptId,
                deptName: row.deptName,
                parentId: row.parentId,
                userId: row.userId,
                remark: row.remark,
            };
        },
        handleDelete(row) {
            delTask(row.deptId).then((res) => {
                console.log(res);
                if (res.code === 200) {
                    this.getList();
                }
            });
        },
        handleExport() {},
        handleQuery() {
            console.log(this.queryParams);
            this.queryParams.pageNum = 1;
            this.getList();
        },
        resetQuery() {
            this.queryParams = {
                username: "",
                nickname: "",
                email: "",
                phonenumber: "",
            };
        },
        resetForm() {
            this.form = {};
        },
        handleNextClick() {
            this.queryParams.pageNum++;
            this.getList();
        },
        handlePrevClick() {
            this.queryParams.pageNum--;
            this.getList();
        },
        handleCurrentChange(val) {
            this.queryParams.pageNum = val;
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