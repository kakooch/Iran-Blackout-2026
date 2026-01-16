package ir.nasim;

import com.google.zxing.ReaderException;

/* renamed from: ir.nasim.rA7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C19929rA7 {
    private static final int[] c = {1, 1, 2};
    private final C18747pA7 a = new C18747pA7();
    private final C19338qA7 b = new C19338qA7();

    C19929rA7() {
    }

    X06 a(int i, C3988Df0 c3988Df0, int i2) {
        int[] iArrM = AbstractC20538sA7.m(c3988Df0, i2, false, c);
        try {
            return this.b.b(i, c3988Df0, iArrM);
        } catch (ReaderException unused) {
            return this.a.b(i, c3988Df0, iArrM);
        }
    }
}
