<template>
    <div>company/user</div>
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
        };
    },
    created() {
        getUserList(this.pageRequest).then((res) => {
            console.log(res);
        });
    },
};
</script>
