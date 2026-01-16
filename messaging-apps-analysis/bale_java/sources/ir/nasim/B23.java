package ir.nasim;

/* loaded from: classes8.dex */
public abstract class B23 {
    public static void a(int[] iArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            int i4 = (iArr[i] >> 24) & 255;
            float f = i4 * 0.003921569f;
            iArr[i] = ((int) ((r0 & 255) * f)) | (i4 << 24) | (((int) (((r0 >> 16) & 255) * f)) << 16) | (((int) (((r0 >> 8) & 255) * f)) << 8);
            i++;
        }
    }

    public static void b(int[] iArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            int i4 = iArr[i];
            int i5 = (i4 >> 24) & 255;
            int i6 = (i4 >> 16) & 255;
            int i7 = (i4 >> 8) & 255;
            int i8 = i4 & 255;
            if (i5 != 0 && i5 != 255) {
                float f = 255.0f / i5;
                int i9 = (int) (i6 * f);
                int i10 = (int) (i7 * f);
                int i11 = (int) (i8 * f);
                if (i9 > 255) {
                    i9 = 255;
                }
                if (i10 > 255) {
                    i10 = 255;
                }
                iArr[i] = (i5 << 24) | (i9 << 16) | (i10 << 8) | (i11 <= 255 ? i11 : 255);
            }
            i++;
        }
    }
}
