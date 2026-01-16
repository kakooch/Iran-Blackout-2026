package ir.resaneh1.iptv.helper;

import android.util.Base64;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import ir.resaneh1.iptv.logger.MyLog;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class EncryptionHelper {
    private static final byte[] ivBytes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static String keyMaster2 = "bsxEoINUE6/sBI";
    public static String keyMaster1 = "xbYQgWxILYBvH6tH7U";

    public static String encrypt(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2, 0), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(Base64.decode(str, 0)), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2, 0), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            String strEncodeToString = Base64.encodeToString(cipher.doFinal(Base64.decode(str, 0)), 0);
            MyLog.e("CardInfoToPayFragment:", "decrypt: " + strEncodeToString);
            return strEncodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static byte[] makeKey(String str) {
        String strSubstring = str.substring(0, 8);
        String strSubstring2 = str.substring(8, 16);
        String str2 = str.substring(16, 24) + strSubstring + str.substring(24, 32) + strSubstring2;
        StringBuilder sb = new StringBuilder(str2);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                sb.setCharAt(i, (char) ((((str2.charAt(i) - '0') + 5) % 10) + 48));
            }
            if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
                sb.setCharAt(i, (char) ((((str2.charAt(i) - 'a') + 9) % 26) + 97));
            }
        }
        return sb.toString().getBytes();
    }

    public static String encryptAuth(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            byte[] bArrMakeKey = makeKey(str2);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArrMakeKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            byte[] bArrDoFinal = cipher.doFinal(str.getBytes());
            MyLog.e("LogAPIMessenger", str);
            return Base64.encodeToString(bArrDoFinal, 0);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            return null;
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static String decryptAuth(String str, String str2) throws Exception {
        byte[] bArrMakeKey = makeKey(str2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrMakeKey, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        String str3 = new String(cipher.doFinal(Base64.decode(str, 0)));
        MyLog.e("LogAPIMessenger", str3);
        return str3;
    }
}
