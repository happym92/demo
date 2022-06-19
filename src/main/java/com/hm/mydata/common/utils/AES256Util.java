package com.hm.mydata.common.utils;

/******************************************************************
 * <pre>
 * <b>Description  : AES256 �븫蹂듯샇�솕 �쑀�떥 �겢�옒�뒪</b>
 * <b>Project Name : framework 怨듯넻</b>
 * package  : kmds.com.framework.util
 * </pre>
 *
 * @author   :
 * @version  : 1.0
 * @since<pre>
 * Modification Information
 *    �닔�젙�씪            �닔�젙�옄                   �닔�젙�궡�슜
 * ------------   ------------------   ----------------------------
 * </pre>
 * @see <b>Copyright (C) by 援먮낫利앷텒 留덉씠�뜲�씠�꽣 Company All right reserved.</b>
 *******************************************************************/
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Util {

    public static String alg = "AES/CBC/PKCS5Padding";
    //private final String key = "01234567890123456789012345678901";

    //private final String iv = key.substring(0, 16); // 16byte

    public String encrypt(String key,String text) throws Exception {
    	String iv = key.substring(0, 16); // 16byte

    	Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String key,String cipherText) throws Exception {
    	String iv = key.substring(0, 16); // 16byte

        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }

}