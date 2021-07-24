<template>
    <div class="app-wrapper">
        <div class="navbar" />
        <sidebar />
        <router-view class="main" />
        <div class="foot" />
    </div>
</template>

<script>
import sidebar from "@/layout/components/sidebar";
export default {
    name: "Layout",
    components: {
        sidebar,
    },
};
</script>

<style lang="scss" scoped>
</style>
