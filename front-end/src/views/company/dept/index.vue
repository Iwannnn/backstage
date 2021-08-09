<template>
    <div>company/dept</div>
</template>

<script>
import { getDeptList } from "@/api/company/dept";
export default {
    name: "dept",
    data() {
        return {
            pageRequest: {
                pageNum: 1,
                pageSize: 10,
            },
        };
    },
    created() {
        getDeptList(this.pageRequest).then((res) => {
            console.log(res);
        });
    },
};
</script>
