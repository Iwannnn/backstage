<template>
    <div>redirect</div>
</template>
<script>
export default {
    created() {
        const { query } = this.$route;
        const { path } = query;
        console.log(path);
        this.$router.replace({
            path: path,
        });
    },
    render: function (h) {
        return h();
    },
};
</script>
