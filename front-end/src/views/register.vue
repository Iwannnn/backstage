<template>
    <div class="register">
        <el-form
            :model="registerForm"
            status-icon
            :rules="registerRules"
            ref="registerForm"
            label-width="100px"
            class="register-form"
        >
            <h3 class="title">注册账号</h3>
            <el-form-item label="账号" prop="username">
                <el-input v-model="registerForm.username" />
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input
                    type="password"
                    v-model="registerForm.password"
                    autocomplete="off"
                />
            </el-form-item>
            <el-form-item label="确认密码" prop="repassword">
                <el-input
                    type="password"
                    v-model="registerForm.repassword"
                    autocomplete="off"
                />
            </el-form-item>
            <el-form-item label="昵称" prop="nickname">
                <el-input v-model="registerForm.nickname" />
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-select v-model="registerForm.sex" placeholder="请选择性别">
                    <el-option label="女性" value="0" />
                    <el-option label="男性" value="1" />
                    <el-option label="转性" value="2" />
                </el-select>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="registerForm.email" />
            </el-form-item>
            <el-form-item label="电话" prop="phonenumber">
                <el-input v-model="registerForm.phonenumber" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('registerForm')"
                    >提交</el-button
                >
                <el-button @click="resetForm('registerForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import { register, checkExist } from "@/api/register";
export default {
    name: "Register",
    data() {
        var validatePassword = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入密码"));
            } else {
                if (this.registerForm.repassword !== "") {
                    this.$refs.registerForm.validateField("repassword");
                }
                callback();
            }
        };
        var validateRePassword = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请再次输入密码"));
            } else if (value !== this.registerForm.password) {
                callback(new Error("两次输入密码不一致!"));
            } else {
                callback();
            }
        };
        var validatePhonenumber = (rule, value, callback) => {
            if (
                /^(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$/.test(
                    value
                ) == false
            ) {
                callback(new Error("请输入正确的手机号"));
            } else {
                callback();
            }
        };
        var checkUsername = (rule, value, callback) => {
            checkExist("username", value).then((res) => {
                console.log(res);
                callback;
            });
        };
        var checkEmail = (rule, value, callback) => {
            if (checkExist(value)) {
                callback(new Error("账号重复"));
            } else {
                callback();
            }
        };
        var checkPhonenumber = (rule, value, callback) => {
            if (checkExist(value)) {
                callback(new Error("账号重复"));
            } else {
                callback();
            }
        };
        return {
            registerForm: {
                username: "",
                password: "",
                repassword: "",
                nickname: "",
                sex: "",
                email: "",
                phonenumber: "",
            },
            registerRules: {
                username: [
                    {
                        required: true,
                        message: "请输入账号",
                        trigger: "blur",
                    },
                    {
                        validator: checkUsername,
                        trigger: "blur",
                    },
                ],
                password: [
                    {
                        required: true,
                        validator: validatePassword,
                        trigger: "blur",
                    },
                ],
                repassword: [
                    {
                        required: true,
                        validator: validateRePassword,
                        trigger: "change",
                    },
                ],
                email: [
                    {
                        required: true,
                        message: "请输入邮箱地址",
                        trigger: "blur",
                    },
                    {
                        type: "email",
                        message: "请输入正确的邮箱地址",
                        trigger: ["blur", "change"],
                    },
                ],
                phonenumber: [
                    {
                        required: true,
                        message: "请输入手机号",
                        trigger: "blur",
                    },
                    {
                        validator: validatePhonenumber,
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    register(this.registerForm);
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
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
.title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
}
.register-form {
    border-radius: 6px;
    background: #ffffff;
    width: 400px;
    padding: 25px 25px 5px 25px;
    .el-input {
        height: 38px;
        input {
            height: 38px;
        }
    }
    .input-icon {
        height: 39px;
        width: 14px;
        margin-left: 2px;
    }
}
</style>