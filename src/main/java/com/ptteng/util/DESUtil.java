package com.ptteng.util;

import com.sun.crypto.provider.DESKeyFactory;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by maweijiang on 2017/3/6.
 */
@Component
public class DESUtil {

  public byte[] encrypt(byte[] datasource,String password){
      try{
          SecureRandom random = new SecureRandom();
          DESKeySpec keySpec = new DESKeySpec(password.getBytes());
          SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
          SecretKey secretKey = keyFactory.generateSecret(keySpec);
          Cipher cipher = Cipher.getInstance("DES");
          cipher.init(Cipher.ENCRYPT_MODE,secretKey,random);
          return cipher.doFinal(datasource);
      }catch (Throwable e){
          e.printStackTrace();
      }
      return null;
  }
}
