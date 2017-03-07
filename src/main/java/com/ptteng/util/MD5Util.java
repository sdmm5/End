package com.ptteng.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by maweijiang on 2017/3/6.
 */
public class MD5Util {
    public static String stringToMD5(String string){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(string.getBytes());
        return new BigInteger(1,messageDigest.digest()).toString(16);
    }
}
