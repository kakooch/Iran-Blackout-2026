package androidMessenger.network;

import android.util.Base64;
import androidMessenger.utilites.MyLog;
import com.facebook.stetho.common.Utf8Charset;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class EncryptionHelper {
    private static final byte[] ivBytes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decryptAuth(String str, String str2) throws Exception {
        byte[] bArrMakeKey = makeKey(str2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrMakeKey, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        String str3 = new String(cipher.doFinal(Base64.decode(str, 0)));
        if (MyLog.isDebugAble) {
            MyLog.e("LogAPIMessenger", str3);
        }
        return str3;
    }

    public static String signRsa(PrivateKey privateKey, String str) throws Exception {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(Utf8Charset.NAME);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(bytes);
        return Base64.encodeToString(signature.sign(), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8, types: [int] */
    public static String encodeChars(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        String str2 = BuildConfig.FLAVOR;
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                c = ((29 - (c - 65)) % 26) + 65;
            } else if (Character.isLowerCase(c)) {
                c = ((32 - (c - 97)) % 26) + 97;
            } else if (Character.isDigit(c)) {
                c = ((13 - (c - 48)) % 10) + 48;
            }
            str2 = str2 + Character.toString((char) c);
        }
        return str2;
    }

    public static String decryptRSA(String str, PrivateKey privateKey) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPPadding");
        cipher.init(2, privateKey);
        return new String(cipher.doFinal(Base64.decode(str, 0)));
    }
}
