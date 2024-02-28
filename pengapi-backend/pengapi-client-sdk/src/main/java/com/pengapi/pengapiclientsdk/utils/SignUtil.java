package com.pengapi.pengapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: 生成签名
 * @date 2024/1/27 16:47
 */
public class SignUtil {
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;

        // 5393554e94bf0eb6436f240a4fd71282
        String digestHex = md5.digestHex(content);

        return digestHex;
    }
}
