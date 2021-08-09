<template>
    <div>company/task</div>
</template>

<script>
import { getTaskList } from "@/api/company/task";
export default {
    name: "task",
    data() {
        return {
            pageRequest: {
                pageNum: 1,
                pageSize: 10,
            },
        };
    },
    created() {
        getTaskList(this.pageRequest).then((res) => {
            console.log(res);
        });
    },
};
</script>
