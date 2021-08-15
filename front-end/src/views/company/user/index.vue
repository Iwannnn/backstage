<template>
    <div>
        <el-upload
            :show-file-list="false"
            accept=".xlsx"
            action="http://localhost:8080/company/user/importData"
            style="display: inline"
        >
            <el-button size="mini" type="success"> 导入文件 </el-button>
        </el-upload>
    </div>
</template>

<script>
import { getUserList } from "@/api/company/user";
export default {
    name: "User",
    data() {
        return {
            pageRequest: {
                pageNum: 1,
                pageSize: 10,
            },
            baseUrl: process.env.VUE_APP_BASE_API,
        };
    },
    created() {
        getUserList(this.pageRequest).then((res) => {
            console.log(res);
        });
    },
};
</script>
