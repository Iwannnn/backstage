/*
 * @Author: iwan
 * @Description:
 * @Date: 2021-07-15 17:31:21
 * @FilePath: \backstage\front-end\src\utils\jsencrypt.js
 */
import JSEncrypt from "jsencrypt/bin/jsencrypt.min";

// 密钥对生成 http://web.chacuo.net/netrsakeypair

const publicKey =
    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDc+7YVSx7IOGsmzRMn1lKdhGX4" +
    "EwYj5d/Z4QgCR5gFC7Ae6rXqdG6QmyEABNh3Z7LDXGyiaN/W/9xE+1ixcqGQJrp8" +
    "EWgiACWhFXd4JJp/viU2/t8cUpdMxKv+U3fyh5k1vqDQaRzDI7jHz663WU1csWM/" +
    "+2yfiPgM7o8dYApG3wIDAQAB";

const privateKey =
    "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANz7thVLHsg4aybN" +
    "EyfWUp2EZfgTBiPl39nhCAJHmAULsB7qtep0bpCbIQAE2HdnssNcbKJo39b/3ET7" +
    "WLFyoZAmunwRaCIAJaEVd3gkmn++JTb+3xxSl0zEq/5Td/KHmTW+oNBpHMMjuMfP" +
    "rrdZTVyxYz/7bJ+I+Azujx1gCkbfAgMBAAECgYBTaQssdGNVDb6cMbH2SnZ6kDvw" +
    "7DVYHW9mDQN54M4nsWaz9MHfkj0dhgBpwmp2f4TBKsSydMVwoLjirMCoke0bCV6H" +
    "r1Qj6pc5hSQSRmyeA6LY6hqdSxr4Dhp22qNZOOT8OuyOuJ+Rw5OnpLHGkYQ+BPnN" +
    "VQgd1K94svorhu/LAQJBAPfQLuwA8vWZe9vfsJ2pRQucwK1Jx7N2KHs1gr3TVb0N" +
    "9cUGMjQ4V/J1/NkiPlWRBc5JAU928iePVp8Z/Km3mV8CQQDkSJ7SI0rp2plbMIZA" +
    "bRxvRvVfTOpXc1IJ373WQl9BGTQ9hpthJsA/jwfaKvPc7ez21E3QV3cVAAzP23kP" +
    "NMKBAkAoShmG1zSpB3YirkCJsX5/P9H3mno0TC6SsYV7FUPoQ7/Ec5hv8wUhb1tX" +
    "dgDKapSWEDp9T+pY0i4UGeaBNU9jAkBfyICrFxfVq1zxQBj0a1Ok9Rb7V6Bz9PUV" +
    "I4XZopupCtQ6hIIpb0L26CKZTbBooIPuxQGpSymx7AV0KVhQIwkBAkBJF5LIIkjR" +
    "LMBTB6QokxIwhlVdoU9SDM++dV9Hp5BECR39eOVhpyVbxsFXT7AilEKvJiczMrP2" +
    "t9+KJcjXgjgu";

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
