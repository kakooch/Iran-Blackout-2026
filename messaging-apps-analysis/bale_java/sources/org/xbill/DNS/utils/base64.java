package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class base64 {
    private static final String BASE_64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static final String BASE_64_URL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    private base64() {
    }

    public static String formatString(byte[] bArr, int i, String str, boolean z) {
        return BaseUtils.wrapLines(toString(bArr), i, str, z);
    }

    public static byte[] fromString(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (byte b : str.getBytes()) {
            if (!Character.isWhitespace((char) b)) {
                byteArrayOutputStream.write(b);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 4 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i2 = 0;
        while (i2 < (byteArray.length + 3) / 4) {
            short[] sArr = new short[4];
            short[] sArr2 = new short[3];
            for (int i3 = i; i3 < 4; i3++) {
                sArr[i3] = (short) BASE_64.indexOf(byteArray[(i2 * 4) + i3]);
            }
            int i4 = sArr[i] << 2;
            short s = sArr[1];
            sArr2[i] = (short) (i4 + (s >> 4));
            short s2 = sArr[2];
            if (s2 == 64) {
                sArr2[2] = -1;
                sArr2[1] = -1;
                if ((sArr[1] & 15) != 0) {
                    return null;
                }
            } else {
                short s3 = sArr[3];
                if (s3 == 64) {
                    sArr2[1] = (short) (((s << 4) + (s2 >> 2)) & 255);
                    sArr2[2] = -1;
                    if ((sArr[2] & 3) != 0) {
                        return null;
                    }
                } else {
                    sArr2[1] = (short) (((s << 4) + (s2 >> 2)) & 255);
                    sArr2[2] = (short) (((s2 << 6) + s3) & 255);
                }
            }
            for (int i5 = 0; i5 < 3; i5++) {
                try {
                    short s4 = sArr2[i5];
                    if (s4 >= 0) {
                        dataOutputStream.writeByte(s4);
                    }
                } catch (IOException unused) {
                }
            }
            i2++;
            i = 0;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, false);
    }

    public static String toString(byte[] bArr, boolean z) {
        String str = z ? BASE_64_URL : BASE_64;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bArr.length + 2) / 3; i++) {
            short[] sArr = new short[3];
            short[] sArr2 = new short[4];
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = (i * 3) + i2;
                if (i3 < bArr.length) {
                    sArr[i2] = (short) (bArr[i3] & 255);
                } else {
                    sArr[i2] = -1;
                }
            }
            sArr2[0] = (short) (sArr[0] >> 2);
            short s = sArr[1];
            if (s == -1) {
                sArr2[1] = (short) ((sArr[0] & 3) << 4);
            } else {
                sArr2[1] = (short) (((sArr[0] & 3) << 4) + (s >> 4));
            }
            short s2 = sArr[1];
            if (s2 == -1) {
                sArr2[3] = 64;
                sArr2[2] = 64;
            } else {
                short s3 = sArr[2];
                if (s3 == -1) {
                    sArr2[2] = (short) ((s2 & 15) << 2);
                    sArr2[3] = 64;
                } else {
                    sArr2[2] = (short) (((s2 & 15) << 2) + (s3 >> 6));
                    sArr2[3] = (short) (sArr[2] & 63);
                }
            }
            for (int i4 = 0; i4 < 4; i4++) {
                short s4 = sArr2[i4];
                if (s4 != 64 || !z) {
                    byteArrayOutputStream.write(str.charAt(s4));
                }
            }
        }
        return byteArrayOutputStream.toString();
    }
}
