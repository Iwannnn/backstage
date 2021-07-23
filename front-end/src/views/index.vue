<template>
    <div>login success</div>
</template>

<script>
import { getToken } from "@/utils/auth";
export default {
    name: "Index",
    created() {
        this.checkToken();
        if (!this.checkToken()) {
            this.$router.replace({
                name: "redirect",
                params: {
                    path: "/login",
                },
                query: {
                    path: "/login",
                },
            });
        }
    },
    methods: {
        checkToken() {
            return getToken() ? true : false;
        },
    },
};
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
    padding: 32px;
    background-color: rgb(240, 242, 245);
    position: relative;

    .chart-wrapper {
        background: #fff;
        padding: 16px 16px 0;
        margin-bottom: 32px;
    }
}

@media (max-width: 1024px) {
    .chart-wrapper {
        padding: 8px;
    }
}
</style>
