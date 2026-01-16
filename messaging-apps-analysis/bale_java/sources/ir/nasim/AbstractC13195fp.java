package ir.nasim;

import ir.nasim.C4593Fu2;

/* renamed from: ir.nasim.fp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13195fp {
    public static final C4593Fu2 a(C4593Fu2.a aVar) {
        return aVar.h();
    }

    public static final int b(boolean z, boolean z2) {
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }

    public static final int c(C4593Fu2 c4593Fu2, int i) {
        return b(c4593Fu2.compareTo(a(C4593Fu2.b)) >= 0, C3418Au2.f(i, C3418Au2.b.a()));
    }
}
