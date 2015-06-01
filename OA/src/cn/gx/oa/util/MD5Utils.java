package cn.gx.oa.util;

import java.security.MessageDigest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


public class MD5Utils {
	
	public static String digest(String message){
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			String msg=Base64.encode(md.digest(message.getBytes()));
			return msg;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
