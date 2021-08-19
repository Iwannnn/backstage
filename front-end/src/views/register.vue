<template>
    <div class="register">
        <registerform />
    </div>
</template>
<script>
import registerform from "@/views/components/register";
export default {
    name: "Register",
    components: {
        registerform,
    },
};
</script>

<style lang="scss" scope>
.register {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;
    position: fixed;
    background-size: 100% 100%;
    background-image: url("../assets/images/background.jpg");
}
</style>