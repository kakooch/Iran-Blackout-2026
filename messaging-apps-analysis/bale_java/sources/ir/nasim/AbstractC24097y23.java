package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.y23, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24097y23 {
    private static int a(D23 d23, int i) {
        int iA = d23.a();
        int i2 = 1;
        for (int iB = d23.b(); iB * iA > i; iB /= 2) {
            i2 *= 2;
            iA /= 2;
        }
        return i2;
    }

    private static int b(D23 d23, int i, int i2) {
        int iB = d23.b();
        int iA = d23.a();
        int i3 = 1;
        while (true) {
            iB /= 2;
            if (iB <= i || (iA = iA / 2) <= i2) {
                break;
            }
            i3 *= 2;
        }
        return i3;
    }

    private static Bitmap c(AbstractC10702c33 abstractC10702c33) {
        return abstractC10702c33.b();
    }

    private static Bitmap d(AbstractC10702c33 abstractC10702c33, int i) {
        return abstractC10702c33.c(i);
    }

    public static Bitmap e(String str, int i, int i2) {
        return h(new C17914nm2(str), i, i2);
    }

    public static Bitmap f(byte[] bArr) {
        return c(new V34(bArr));
    }

    private static Bitmap g(AbstractC10702c33 abstractC10702c33, int i) {
        return d(abstractC10702c33, a(abstractC10702c33.a(), i));
    }

    private static Bitmap h(AbstractC10702c33 abstractC10702c33, int i, int i2) {
        return d(abstractC10702c33, b(abstractC10702c33.a(), i, i2));
    }

    public static Bitmap i(String str) {
        return j(str, 1440000);
    }

    public static Bitmap j(String str, int i) {
        return g(new C17914nm2(str), i);
    }

    public static Bitmap k(byte[] bArr) {
        return g(new V34(bArr), 1440000);
    }
}
