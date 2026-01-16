package ir.nasim;

/* renamed from: ir.nasim.Pn7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6920Pn7 {
    public static final float a(C13774gn7 c13774gn7, int i, boolean z, boolean z2) {
        return c13774gn7.j(i, c13774gn7.c(((!z || z2) && (z || !z2)) ? Math.max(i + (-1), 0) : i) == c13774gn7.y(i));
    }

    public static final long b(C13774gn7 c13774gn7, int i, boolean z, boolean z2) {
        int iQ = c13774gn7.q(i);
        if (iQ >= c13774gn7.n()) {
            return ZG4.b.b();
        }
        float fL = AbstractC23053wG5.l(a(c13774gn7, i, z, z2), 0.0f, (int) (c13774gn7.B() >> 32));
        float fL2 = AbstractC23053wG5.l(c13774gn7.m(iQ), 0.0f, (int) (c13774gn7.B() & 4294967295L));
        return ZG4.e((Float.floatToRawIntBits(fL) << 32) | (Float.floatToRawIntBits(fL2) & 4294967295L));
    }
}
