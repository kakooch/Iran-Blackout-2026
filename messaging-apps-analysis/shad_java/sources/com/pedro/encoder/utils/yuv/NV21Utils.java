package com.pedro.encoder.utils.yuv;

/* loaded from: classes3.dex */
public class NV21Utils {
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
            int i7 = i6 + 1;
            bArr2[i6] = bArr[i7];
            bArr2[i7] = bArr[i6];
        }
        return preAllocatedBufferColor;
    }

    public static byte[] toI420(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        System.arraycopy(bArr, 0, preAllocatedBufferColor, 0, i3);
        for (int i5 = 0; i5 < i4; i5++) {
            byte[] bArr2 = preAllocatedBufferColor;
            int i6 = i3 + i5;
            int i7 = (i5 * 2) + i3;
            bArr2[i6] = bArr[i7 + 1];
            bArr2[i6 + i4] = bArr[i7];
        }
        return preAllocatedBufferColor;
    }

    public static byte[] rotate90(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i2 - 1;
            while (i5 >= 0) {
                preAllocatedBufferRotate[i3] = bArr[(i5 * i) + i4];
                i5--;
                i3++;
            }
        }
        int i6 = i * i2;
        int i7 = ((i6 * 3) / 2) - 1;
        for (int i8 = i - 1; i8 > 0; i8 -= 2) {
            for (int i9 = 0; i9 < i2 / 2; i9++) {
                byte[] bArr2 = preAllocatedBufferRotate;
                int i10 = i7 - 1;
                int i11 = (i9 * i) + i6;
                bArr2[i7] = bArr[i11 + i8];
                i7 = i10 - 1;
                bArr2[i10] = bArr[i11 + (i8 - 1)];
            }
        }
        return preAllocatedBufferRotate;
    }

    public static byte[] rotate180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            preAllocatedBufferRotate[i4] = bArr[i5];
            i4++;
        }
        for (int i6 = ((i3 * 3) / 2) - 1; i6 >= i3; i6 -= 2) {
            byte[] bArr2 = preAllocatedBufferRotate;
            int i7 = i4 + 1;
            bArr2[i4] = bArr[i6 - 1];
            i4 = i7 + 1;
            bArr2[i7] = bArr[i6];
        }
        return preAllocatedBufferRotate;
    }

    public static byte[] rotate270(byte[] bArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = i3; i5 >= 0; i5--) {
            int i6 = 0;
            while (i6 < i2) {
                preAllocatedBufferRotate[i4] = bArr[(i6 * i) + i5];
                i6++;
                i4++;
            }
        }
        int i7 = i * i2;
        int i8 = i2 / 2;
        while (i3 >= 0) {
            for (int i9 = i2; i9 < i8 + i2; i9++) {
                byte[] bArr2 = preAllocatedBufferRotate;
                int i10 = i7 + 1;
                int i11 = (i9 * i) + i3;
                bArr2[i7] = bArr[i11 - 1];
                i7 = i10 + 1;
                bArr2[i10] = bArr[i11];
            }
            i3 -= 2;
        }
        return preAllocatedBufferRotate;
    }
}
