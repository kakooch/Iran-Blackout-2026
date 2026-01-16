package ir.nasim;

import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;

/* renamed from: ir.nasim.Xc3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C8736Xc3 {
    private final LargeJpegImageQuirk a = (LargeJpegImageQuirk) androidx.camera.core.internal.compat.quirk.a.b(LargeJpegImageQuirk.class);

    public static int a(byte[] bArr) {
        byte b;
        int i = 2;
        while (i + 4 <= bArr.length && (b = bArr[i]) == -1) {
            int i2 = i + 2;
            int i3 = ((bArr[i2] & 255) << 8) | (bArr[i + 3] & 255);
            if (b == -1 && bArr[i + 1] == -38) {
                while (true) {
                    int i4 = i2 + 2;
                    if (i4 > bArr.length) {
                        return -1;
                    }
                    if (bArr[i2] == -1 && bArr[i2 + 1] == -39) {
                        return i4;
                    }
                    i2++;
                }
            } else {
                i += i3 + 2;
            }
        }
        return -1;
    }

    public int b(byte[] bArr) {
        LargeJpegImageQuirk largeJpegImageQuirk = this.a;
        if (largeJpegImageQuirk == null || !largeJpegImageQuirk.g(bArr)) {
            return bArr.length;
        }
        int iA = a(bArr);
        return iA != -1 ? iA : bArr.length;
    }
}
