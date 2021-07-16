/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 17:37:16
 * @FilePath: \backstage\front-end\src\store\getters.js
 */
const getters = {
    token: state => state.user.token,
    name: state => state.user.name
};
export default getters;
