package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class base32 {
    private final String alphabet;
    private final boolean lowercase;
    private final boolean padding;

    public static class Alphabet {
        public static final String BASE32 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";
        public static final String BASE32HEX = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

        private Alphabet() {
        }
    }

    public base32(String str, boolean z, boolean z2) {
        this.alphabet = str;
        this.padding = z;
        this.lowercase = z2;
    }

    private static int blockLenToPadding(int i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToBlockLen(int i) {
        if (i == 0) {
            return 5;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 6 ? -1 : 1;
        }
        return 2;
    }

    public byte[] fromString(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : str.getBytes()) {
            char c = (char) b;
            if (!Character.isWhitespace(c)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c));
            }
        }
        if (!this.padding) {
            while (byteArrayOutputStream.size() % 8 != 0) {
                byteArrayOutputStream.write(61);
            }
        } else if (byteArrayOutputStream.size() % 8 != 0) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i = 0; i < byteArray.length / 8; i++) {
            short[] sArr = new short[8];
            int i2 = 8;
            for (int i3 = 0; i3 < 8; i3++) {
                byte b2 = byteArray[(i * 8) + i3];
                if (((char) b2) == '=') {
                    break;
                }
                short sIndexOf = (short) this.alphabet.indexOf(b2);
                sArr[i3] = sIndexOf;
                if (sIndexOf < 0) {
                    return null;
                }
                i2--;
            }
            int iPaddingToBlockLen = paddingToBlockLen(i2);
            if (iPaddingToBlockLen < 0) {
                return null;
            }
            int i4 = sArr[0] << 3;
            short s = sArr[1];
            int i5 = i4 | (s >> 2);
            int i6 = sArr[2] << 1;
            short s2 = sArr[3];
            int i7 = i6 | ((s & 3) << 6) | (s2 >> 4);
            short s3 = sArr[4];
            int i8 = ((s2 & 15) << 4) | ((s3 >> 1) & 15);
            int i9 = (s3 << 7) | (sArr[5] << 2);
            short s4 = sArr[6];
            int[] iArr = {i5, i7, i8, i9 | (s4 >> 3), sArr[7] | ((s4 & 7) << 5)};
            for (int i10 = 0; i10 < iPaddingToBlockLen; i10++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i10] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < (bArr.length + 4) / 5; i2++) {
            short[] sArr = new short[5];
            int i3 = 5;
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = (i2 * 5) + i4;
                if (i5 < bArr.length) {
                    sArr[i4] = (short) (bArr[i5] & 255);
                } else {
                    sArr[i4] = 0;
                    i3--;
                }
            }
            int iBlockLenToPadding = blockLenToPadding(i3);
            short s = sArr[0];
            int i6 = (byte) ((s >> 3) & 31);
            short s2 = sArr[1];
            int i7 = (byte) (((s & 7) << 2) | ((s2 >> 6) & 3));
            int i8 = (byte) ((s2 >> 1) & 31);
            short s3 = sArr[2];
            int i9 = (byte) (((s2 & 1) << 4) | ((s3 >> 4) & 15));
            short s4 = sArr[3];
            short s5 = sArr[4];
            int[] iArr = {i6, i7, i8, i9, (byte) (((s3 & 15) << 1) | ((s4 >> 7) & 1)), (byte) ((s4 >> 2) & 31), (byte) (((s5 >> 5) & 7) | ((s4 & 3) << 3)), (byte) (s5 & 31)};
            int i10 = 0;
            while (true) {
                i = 8 - iBlockLenToPadding;
                if (i10 >= i) {
                    break;
                }
                char cCharAt = this.alphabet.charAt(iArr[i10]);
                if (this.lowercase) {
                    cCharAt = Character.toLowerCase(cCharAt);
                }
                byteArrayOutputStream.write(cCharAt);
                i10++;
            }
            if (this.padding) {
                while (i < 8) {
                    byteArrayOutputStream.write(61);
                    i++;
                }
            }
        }
        return byteArrayOutputStream.toString();
    }
}
