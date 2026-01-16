package ir.nasim;

/* renamed from: ir.nasim.i90, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14582i90 {
    private static final char[] b;
    public static final C14582i90 a = new C14582i90();
    private static final byte[] c = new byte[128];

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        b = cArr;
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            c[b[i]] = (byte) i;
        }
    }

    private C14582i90() {
    }

    public static final byte[] a(String str) {
        AbstractC13042fc3.i(str, "data");
        int length = str.length();
        int i = 0;
        if (length == 0) {
            return new byte[0];
        }
        char[] cArr = new char[length];
        str.getChars(0, length, cArr, 0);
        int i2 = (length / 4) * 3;
        if (cArr[length - 2] == '=') {
            i2--;
        }
        if (cArr[length - 1] == '=') {
            i2--;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i < length) {
            byte[] bArr2 = c;
            byte b2 = bArr2[cArr[i] & 255];
            byte b3 = bArr2[cArr[i + 1] & 255];
            int i4 = i + 3;
            byte b4 = bArr2[cArr[i + 2] & 255];
            i += 4;
            int i5 = bArr2[cArr[i4] & 255] | (b3 << 12) | (b2 << 18) | (b4 << 6);
            int i6 = i3 + 1;
            bArr[i3] = (byte) (i5 >> 16);
            if (i6 == i2) {
                break;
            }
            int i7 = i3 + 2;
            bArr[i6] = (byte) (i5 >> 8);
            if (i7 == i2) {
                break;
            }
            i3 += 3;
            bArr[i7] = (byte) i5;
        }
        return bArr;
    }

    public static final String b(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        AbstractC13042fc3.i(bArr, "data");
        int length = bArr.length;
        if (length == 0) {
            return "";
        }
        char[] cArr = new char[((length + 2) / 3) * 4];
        int i5 = 0;
        int i6 = 0;
        while (length > 0) {
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 255;
            if (length > 1) {
                i = i5 + 2;
                i2 = bArr[i7] & 255;
            } else {
                i = i7;
                i2 = 0;
            }
            if (length > 2) {
                i3 = i + 1;
                i4 = bArr[i] & 255;
            } else {
                i3 = i;
                i4 = 0;
            }
            int i9 = i4 | (i2 << 8) | (i8 << 16);
            int i10 = (i9 >> 18) & 63;
            int i11 = (i9 >> 12) & 63;
            int i12 = (i9 >> 6) & 63;
            int i13 = i9 & 63;
            char[] cArr2 = b;
            cArr[i6] = cArr2[i10];
            int i14 = i6 + 2;
            cArr[i6 + 1] = cArr2[i11];
            int i15 = i6 + 3;
            char c2 = '=';
            cArr[i14] = length > 1 ? cArr2[i12] : '=';
            i6 += 4;
            if (length > 2) {
                c2 = cArr2[i13];
            }
            cArr[i15] = c2;
            length -= 3;
            i5 = i3;
        }
        return new String(cArr);
    }
}
