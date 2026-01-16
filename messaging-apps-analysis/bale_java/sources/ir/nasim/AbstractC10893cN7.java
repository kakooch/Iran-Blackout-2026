package ir.nasim;

import com.google.crypto.tink.internal.TinkBugException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Objects;

/* renamed from: ir.nasim.cN7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10893cN7 {
    public static final Charset a = Charset.forName("UTF-8");

    private static final byte a(char c) throws GeneralSecurityException {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new GeneralSecurityException("Not a printable ASCII character: " + c);
    }

    public static final C8575Wo0 b(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = a(str.charAt(i));
        }
        return C8575Wo0.a(bArr);
    }

    public static Integer c() {
        if (d()) {
            return AbstractC8314Vl0.a();
        }
        return null;
    }

    public static boolean d() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    public static boolean e(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr2[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int f() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i;
    }

    private static final byte g(char c) {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c);
    }

    public static final C8575Wo0 h(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = g(str.charAt(i));
        }
        return C8575Wo0.a(bArr);
    }
}
