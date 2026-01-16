package ir.nasim;

import android.graphics.Typeface;

/* renamed from: ir.nasim.Bf5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3525Bf5 implements InterfaceC24463yf5 {
    private final Typeface c(String str, C4593Fu2 c4593Fu2, int i) {
        if (C3418Au2.f(i, C3418Au2.b.b()) && AbstractC13042fc3.d(c4593Fu2, C4593Fu2.b.d()) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        int iC = AbstractC13195fp.c(c4593Fu2, i);
        return (str == null || str.length() == 0) ? Typeface.defaultFromStyle(iC) : Typeface.create(str, iC);
    }

    private final Typeface d(String str, C4593Fu2 c4593Fu2, int i) {
        if (str.length() == 0) {
            return null;
        }
        Typeface typefaceC = c(str, c4593Fu2, i);
        if (AbstractC13042fc3.d(typefaceC, Typeface.create(Typeface.DEFAULT, AbstractC13195fp.c(c4593Fu2, i))) || AbstractC13042fc3.d(typefaceC, c(null, c4593Fu2, i))) {
            return null;
        }
        return typefaceC;
    }

    @Override // ir.nasim.InterfaceC24463yf5
    public Typeface a(C4593Fu2 c4593Fu2, int i) {
        return c(null, c4593Fu2, i);
    }

    @Override // ir.nasim.InterfaceC24463yf5
    public Typeface b(TE2 te2, C4593Fu2 c4593Fu2, int i) {
        Typeface typefaceD = d(AbstractC3759Cf5.b(te2.o(), c4593Fu2), c4593Fu2, i);
        return typefaceD == null ? c(te2.o(), c4593Fu2, i) : typefaceD;
    }
}
