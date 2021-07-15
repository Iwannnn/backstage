/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 11:52:23
 * @FilePath: \backstage\front-end\config\test.env.js
 */
"use strict";
const merge = require("webpack-merge");
const devEnv = require("./dev.env");

module.exports = merge(devEnv, {
    ENV: '"testing"',
    VUE_APP_BASE_API: "/test-api"
});
