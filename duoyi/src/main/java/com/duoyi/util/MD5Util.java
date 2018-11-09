package com.duoyi.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

/**用来实现加密
 * @author 浩子
 *2018年10月22日
 */
public class MD5Util {

	/**
	 * @param str 要加密的字符串
	 * @return  加密后的字符串
	 */
	public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	
	/**把账号一起放进去加密
	 * @param password 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
	 */
	public static String getMD5(String password, String key) throws Exception {
        //加密后的字符串
        String encodeStr=DigestUtils.md5Hex(password + key);
        return encodeStr;
        }

	public static void main(String[] args) throws Exception {
		
		System.out.println(getMD5("admin","admin"));
	}
}
