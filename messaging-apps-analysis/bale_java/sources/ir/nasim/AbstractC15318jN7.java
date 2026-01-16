package ir.nasim;

import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.jN7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15318jN7 {
    private static volatile NZ b;
    public static Pattern a = Pattern.compile("[\\-0-9]+");
    protected static final char[] c = "0123456789ABCDEF".toCharArray();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            C19406qI3.d("baleMessages", e);
            return null;
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = c;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] c(byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr, i, i2);
            return messageDigest.digest();
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
            return null;
        }
    }

    public static NZ d() {
        if (b == null) {
            synchronized (AbstractC15318jN7.class) {
                try {
                    if (b == null) {
                        b = SZ.g("Q_U_Stage");
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static Integer e(String str) {
        int i = 0;
        if (str == null) {
            return i;
        }
        try {
            Matcher matcher = a.matcher(str);
            return matcher.find() ? Integer.valueOf(Integer.parseInt(matcher.group(0))) : i;
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
            return i;
        }
    }
}
