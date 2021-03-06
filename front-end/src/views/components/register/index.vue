<template>
    <el-form
        :model="registerForm"
        status-icon
        :rules="registerRules"
        ref="registerForm"
        label-width="100px"
        class="register-form"
    >
        <h3 class="tittle">{{ tittle }}</h3>
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
        <el-form-item label="部门" prop="deptId">
            <el-select v-model="registerForm.deptId" placeholder="请选择部门">
                <el-option label="女性" value="0" />
                <el-option label="男性" value="1" />
                <el-option label="转性" value="2" />
            </el-select>
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
        <el-form-item label="备注" prop="remark">
            <el-input v-model="registerForm.remark" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('registerForm')">
                确定
            </el-button>
            <el-button @click="resetForm('registerForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>
<script>
import { register, checkExist } from "@/api/register";
export default {
    name: "RegisterForm",
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
                if (res.msg === "exist") {
                    callback(new Error("该账号名已被使用"));
                } else {
                    callback();
                }
            });
        };
        var checkEmail = (rule, value, callback) => {
            checkExist("email", value).then((res) => {
                if (res.msg === "exist") {
                    callback(new Error("该邮箱已被使用"));
                } else {
                    callback();
                }
            });
        };
        var checkPhonenumber = (rule, value, callback) => {
            checkExist("phonenumber", value).then((res) => {
                if (res.msg === "exist") {
                    callback(new Error("该电话已被使用"));
                } else {
                    callback();
                }
            });
        };
        return {
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
                sex: [
                    {
                        required: true,
                        trigger: "blur",
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
                    {
                        validator: checkEmail,
                        trigger: "blur",
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
                    {
                        validator: checkPhonenumber,
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    props: {
        redirectPath: String,
        tittle: String,
        registerForm: {
            type: Object,
            default: function () {
                return {
                    userId: "",
                    deptId: "",
                    username: "",
                    password: "",
                    repassword: "",
                    nickname: "",
                    sex: "",
                    email: "",
                    phonenumber: "",
                    remark: "",
                };
            },
        },
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                console.log(this.redirectPath);
                if (valid) {
                    register(this.registerForm).then((res) => {
                        this.$message({
                            message: "操作成功",
                            type: "success",
                        });
                        this.$router.push({ path: this.redirectPath });
                    });
                } else {
                    this.$message({
                        message: "操作失败",
                        type: "error",
                    });
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
.tittle {
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