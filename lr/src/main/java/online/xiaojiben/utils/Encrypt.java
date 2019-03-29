/**
 *
 */
package online.xiaojiben.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月20日 上午9:44:21
 */
public class Encrypt {
	public static String getStrMD5(String inStr) {
		// 获取md5实例
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.toString());
			return "";
		}
		
		// 加密字符串转化为字符数组
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		
		// 开始加密
		for(int i=0;i<charArray.length;i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] digest = md5.digest(byteArray);
		StringBuilder sbBuilder = new StringBuilder();
		for(int i=0;i<digest.length;i++) {
			int var = digest[i] & 0xff;
			if (var < 16) {
				sbBuilder.append("0");
			}
			sbBuilder.append(Integer.toHexString(var));
		}
		return sbBuilder.toString();
	}
}