package ir.nasim;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* renamed from: ir.nasim.cI0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC10841cI0 {
    private static final int[] a = e(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    static void a(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int iB = b(i5 ^ iArr[i4], 16);
        iArr[i4] = iB;
        int i6 = iArr[i3] + iB;
        iArr[i3] = i6;
        int iB2 = b(iArr[i2] ^ i6, 12);
        iArr[i2] = iB2;
        int i7 = iArr[i] + iB2;
        iArr[i] = i7;
        int iB3 = b(iArr[i4] ^ i7, 8);
        iArr[i4] = iB3;
        int i8 = iArr[i3] + iB3;
        iArr[i3] = i8;
        iArr[i2] = b(iArr[i2] ^ i8, 7);
    }

    private static int b(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    static void c(int[] iArr, int[] iArr2) {
        int[] iArr3 = a;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    static void d(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    static int[] e(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}
