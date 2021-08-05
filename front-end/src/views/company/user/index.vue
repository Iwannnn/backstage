<template>
    <div>company/user</div>
</template>

<script>
import { getAllUser } from "@/api/company/user";
export default {
    name: "user",
    data() {
        return {
            pageRequest: {
                pageNum: 1,
                pageSize: 10,
            },
        };
    },
    created() {
        getAllUser(this.pageRequest).then((res) => {
            console.log(res);
        });
    },
};
</script>
