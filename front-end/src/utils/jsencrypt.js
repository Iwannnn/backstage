/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 14:46:12
 * @FilePath: \backstage\front-end\src\utils\jsencrypt.js
 */
import JSEncrypt from "jsencrypt/bin/jsencrypt.min";

// 密钥对生成 http://web.chacuo.net/netrsakeypair

const publicKey =
    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDwht7Qa3fzkn0t4fVKksiDE5q" +
    "Kst9sB5fVEIxW437UdNpZBtiFJIablgsRZrbvd+Yce8ulqoxh691Eiy51Qv6RXYS" +
    "U7R5TrQErcHZYcRO+nkOztJN7rhUz2+xs3rT214WKBgk1NIarjv7YQJVOAVmLH6K" +
    "cJd45zkcIjvTgaa/KwIDAQAB";

const privateKey =
    "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMPCG3tBrd/OSfS3" +
    "h9UqSyIMTmoqy32wHl9UQjFbjftR02lkG2IUkhpuWCxFmtu935hx7y6WqjGHr3US" +
    "LLnVC/pFdhJTtHlOtAStwdlhxE76eQ7O0k3uuFTPb7GzetPbXhYoGCTU0hquO/th" +
    "AlU4BWYsfopwl3jnORwiO9OBpr8rAgMBAAECgYAgai/qxQFpodsVLp7LaWlvheIm" +
    "KlfvxA4DcwxS5/omt3HubakrIITg44yuKAhwgoxXzeXxLPmZogInvI6zZtfImqF4" +
    "BPi4PfTsd4SXqyjBLcudbvaEAoqwQiV9lNPptBH5ZXVjRH7M4x8j1evR1tyLAFui" +
    "1UG4XhHhXqYJhQnKYQJBAP5fw5Ae3FS+oFX0jLlDvskkN6kOmx0ZcciSkKLBMn68" +
    "7xBxMVAlRSElgZRfXXDKvn9bWXZfKlDqPDsBJ1rloNUCQQDFAm3wk7KFlac78MxV" +
    "dHolhIK6ek9uqs32+E+4FdrsEKb21+g+tIoEdAL5d0jdcSbCNkVuvfo725RO2drJ" +
    "it//AkARcGVK4yK92JfLbMmdBez1gzshpvOxagYn9wxdbBtXHwLQwMHducBkhlq8" +
    "3lDco7mtp4iZmeqfw38/mFOnYqjFAkAumm+FXHr7jLY9wK2lfWMzotAF6s8Ff9Qv" +
    "GvhItKrP8vR8KgDfbHfFq+fUOXp8H7sqcAomszwRktTXfkN6L6bjAkEA27+rV4Jo" +
    "Gwu0DCdo0JS5K/7cPSpH4aLGpas54vIoV/4SHjYmfkjv2IjnJLaULvJbRjgGV2SX" +
    "6mw1aHSbvDyDpA==";

// 加密
export function encrypt(txt) {
    const encryptor = new JSEncrypt();
    encryptor.setPublicKey(publicKey); // 设置公钥
    return encryptor.encrypt(txt); // 对数据进行加密
}

// 解密
export function decrypt(txt) {
    const encryptor = new JSEncrypt();
    encryptor.setPrivateKey(privateKey); // 设置私钥
    return encryptor.decrypt(txt); // 对数据进行解密
}
