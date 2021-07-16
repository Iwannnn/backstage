/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 17:17:38
 * @FilePath: \backstage\front-end\config\dev.env.js
 */
"use strict";
const merge = require("webpack-merge");
const prodEnv = require("./prod.env");

module.exports = merge(prodEnv, {
    NODE_ENV: '"development"',
    VUE_APP_BASE_API: '"http://localhost:8080"'
});
