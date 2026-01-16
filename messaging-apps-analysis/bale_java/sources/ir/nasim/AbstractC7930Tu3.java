package ir.nasim;

import ir.nasim.AbstractC23365wn7;

/* renamed from: ir.nasim.Tu3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7930Tu3 {
    public static final long a(long j, boolean z, int i, float f) {
        return C17833ne1.b.b(0, c(j, z, i, f), 0, C17833ne1.k(j));
    }

    public static final int b(boolean z, int i, int i2) {
        if (z || !d(i)) {
            return AbstractC23053wG5.e(i2, 1);
        }
        return 1;
    }

    public static final int c(long j, boolean z, int i, float f) {
        int iL = ((z || d(i)) && C17833ne1.h(j)) ? C17833ne1.l(j) : Integer.MAX_VALUE;
        return C17833ne1.n(j) == iL ? iL : AbstractC23053wG5.m(AbstractC3815Cl7.a(f), C17833ne1.n(j), iL);
    }

    public static final boolean d(int i) {
        AbstractC23365wn7.a aVar = AbstractC23365wn7.a;
        return AbstractC23365wn7.g(i, aVar.b()) || AbstractC23365wn7.g(i, aVar.d()) || AbstractC23365wn7.g(i, aVar.c());
    }
}
