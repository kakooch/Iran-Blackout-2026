package ir.nasim;

/* renamed from: ir.nasim.vV2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22589vV2 {
    protected static final char[] a = "0123456789abcdef".toCharArray();

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((b(str.charAt(i2)) << 4) + b(str.charAt(i2 + 1)));
        }
        return bArr;
    }

    private static int b(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c < 'a' || c > 'f') {
            throw new RuntimeException();
        }
        return c - 'W';
    }

    public static String c(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
