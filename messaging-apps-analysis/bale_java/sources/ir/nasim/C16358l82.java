package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.l82, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16358l82 {
    public static final C16358l82 a = new C16358l82();
    private static String b = "J@NcRfUjXn2r5u8x";

    private C16358l82() {
    }

    public static /* synthetic */ String c(C16358l82 c16358l82, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = b;
        }
        return c16358l82.b(str, str2);
    }

    public static /* synthetic */ String f(C16358l82 c16358l82, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = b;
        }
        return c16358l82.e(str, str2);
    }

    public final String a(String str) {
        return c(this, str, null, 2, null);
    }

    public final String b(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        AbstractC13042fc3.i(str2, "key");
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            AbstractC13042fc3.h(charsetForName, "forName(...)");
            byte[] bytes = "encryptionIntVec".getBytes(charsetForName);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes);
            Charset charsetForName2 = Charset.forName("UTF-8");
            AbstractC13042fc3.h(charsetForName2, "forName(...)");
            byte[] bytes2 = str2.getBytes(charsetForName2);
            AbstractC13042fc3.h(bytes2, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] bArrDoFinal = cipher.doFinal(Base64.decode(str, 0));
            AbstractC13042fc3.f(bArrDoFinal);
            return new String(bArrDoFinal, C12275eL0.b);
        } catch (Exception e) {
            C19406qI3.i("EU", e.getLocalizedMessage(), new Object[0]);
            return null;
        }
    }

    public final String d(String str) {
        AbstractC13042fc3.i(str, "value");
        return f(this, str, null, 2, null);
    }

    public final String e(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        AbstractC13042fc3.i(str, "value");
        AbstractC13042fc3.i(str2, "key");
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            AbstractC13042fc3.h(charsetForName, "forName(...)");
            byte[] bytes = "encryptionIntVec".getBytes(charsetForName);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes);
            Charset charsetForName2 = Charset.forName("UTF-8");
            AbstractC13042fc3.h(charsetForName2, "forName(...)");
            byte[] bytes2 = str2.getBytes(charsetForName2);
            AbstractC13042fc3.h(bytes2, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            byte[] bytes3 = str.getBytes(C12275eL0.b);
            AbstractC13042fc3.h(bytes3, "getBytes(...)");
            return Base64.encodeToString(cipher.doFinal(bytes3), 0);
        } catch (Exception e) {
            C19406qI3.i("EU", e.getLocalizedMessage(), new Object[0]);
            return null;
        }
    }

    public final String g(String str, String str2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String strEncodeToString;
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(str2, "publicKey");
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(1, publicKeyGeneratePublic);
            byte[] bytes = str.getBytes(C12275eL0.b);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            strEncodeToString = Base64.encodeToString(cipher.doFinal(bytes), 0);
        } catch (Exception e) {
            C19406qI3.d("EnUtils", e);
            strEncodeToString = "";
        }
        return AbstractC20153rZ6.M(AbstractC20153rZ6.M(strEncodeToString, Separators.SP, "", false, 4, null), Separators.RETURN, "", false, 4, null);
    }
}
