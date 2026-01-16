package ir.nasim;

import android.graphics.Typeface;
import ir.nasim.C3418Au2;

/* renamed from: ir.nasim.Af5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3286Af5 implements InterfaceC24463yf5 {
    private final Typeface c(String str, C4593Fu2 c4593Fu2, int i) {
        C3418Au2.a aVar = C3418Au2.b;
        if (C3418Au2.f(i, aVar.b()) && AbstractC13042fc3.d(c4593Fu2, C4593Fu2.b.d()) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), c4593Fu2.t(), C3418Au2.f(i, aVar.a()));
    }

    @Override // ir.nasim.InterfaceC24463yf5
    public Typeface a(C4593Fu2 c4593Fu2, int i) {
        return c(null, c4593Fu2, i);
    }

    @Override // ir.nasim.InterfaceC24463yf5
    public Typeface b(TE2 te2, C4593Fu2 c4593Fu2, int i) {
        return c(te2.o(), c4593Fu2, i);
    }
}
