package com.pedro.encoder.utils.yuv;

/* loaded from: classes3.dex */
public class YV12Utils {
    private static byte[] preAllocatedBufferColor;
    private static byte[] preAllocatedBufferRotate;

    public static void preAllocateBuffers(int i) {
        preAllocatedBufferRotate = new byte[i];
        preAllocatedBufferColor = new byte[i];
    }

    public static byte[] toNV12(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        System.arraycopy(bArr, 0, preAllocatedBufferColor, 0, i3);
        for (int i5 = 0; i5 < i4; i5++) {
            byte[] bArr2 = preAllocatedBufferColor;
            int i6 = (i5 * 2) + i3;
            int i7 = i3 + i5;
            bArr2[i6] = bArr[i7 + i4];
            bArr2[i6 + 1] = bArr[i7];
        }
        return preAllocatedBufferColor;
    }

    public static byte[] toI420(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        System.arraycopy(bArr, 0, preAllocatedBufferColor, 0, i3);
        int i5 = i3 + i4;
        System.arraycopy(bArr, i5, preAllocatedBufferColor, i3, i4);
        System.arraycopy(bArr, i3, preAllocatedBufferColor, i5, i4);
        return preAllocatedBufferColor;
    }

    public static byte[] rotate90(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i2 - 1;
            while (i6 >= 0) {
                preAllocatedBufferRotate[i4] = bArr[(i6 * i) + i5];
                i6--;
                i4++;
            }
        }
        int i7 = i2 * i;
        int i8 = i7 / 4;
        int i9 = i8 / i;
        while (true) {
            int i10 = i / 2;
            if (i3 >= i10) {
                return preAllocatedBufferRotate;
            }
            for (int i11 = i9 - 1; i11 >= 0; i11--) {
                byte[] bArr2 = preAllocatedBufferRotate;
                int i12 = i4 + i8;
                int i13 = i * i11;
                int i14 = i8 + i7 + i13 + i3;
                bArr2[i12] = bArr[i14 + i10];
                bArr2[i12 + 1] = bArr[i14];
                int i15 = i4 + 1;
                int i16 = i13 + i7 + i3;
                bArr2[i4] = bArr[i16 + i10];
                i4 = i15 + 1;
                bArr2[i15] = bArr[i16];
            }
            i3++;
        }
    }

    public static byte[] rotate180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 - 1;
        int i5 = 0;
        while (i4 >= 0) {
            preAllocatedBufferRotate[i5] = bArr[i4];
            i4--;
            i5++;
        }
        int i6 = (i3 / 4) + i3;
        int i7 = i6 - 1;
        while (i7 >= i3) {
            preAllocatedBufferRotate[i5] = bArr[i7];
            i7--;
            i5++;
        }
        int length = bArr.length - 1;
        while (length >= i6) {
            preAllocatedBufferRotate[i5] = bArr[length];
            length--;
            i5++;
        }
        return preAllocatedBufferRotate;
    }

    public static byte[] rotate270(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            int i5 = 0;
            while (i5 < i2) {
                preAllocatedBufferRotate[i3] = bArr[(i5 * i) + i4];
                i5++;
                i3++;
            }
        }
        int i6 = i2 * i;
        int i7 = i6 / 4;
        int i8 = i7 / i;
        int i9 = 0;
        while (true) {
            if (i9 >= i / 2) {
                return preAllocatedBufferRotate;
            }
            for (int i10 = 0; i10 < i8; i10++) {
                byte[] bArr2 = preAllocatedBufferRotate;
                int i11 = i3 + i7;
                int i12 = i * i10;
                int i13 = ((i7 + i6) + i12) - i9;
                bArr2[i11] = bArr[(i13 + r5) - 1];
                bArr2[i11 + 1] = bArr[(i13 + i) - 1];
                int i14 = i3 + 1;
                int i15 = (i12 + i6) - i9;
                bArr2[i3] = bArr[(i15 + r5) - 1];
                i3 = i14 + 1;
                bArr2[i14] = bArr[(i15 + i) - 1];
            }
            i9++;
        }
    }
}
