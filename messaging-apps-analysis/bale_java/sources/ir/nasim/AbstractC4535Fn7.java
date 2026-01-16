package ir.nasim;

/* renamed from: ir.nasim.Fn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4535Fn7 {
    public static final long a(int i) {
        return b(i, i);
    }

    public static final long b(int i, int i2) {
        return C4301En7.c(d(i, i2));
    }

    public static final long c(long j, int i, int i2) {
        int iN = C4301En7.n(j);
        if (iN < i) {
            iN = i;
        }
        if (iN > i2) {
            iN = i2;
        }
        int i3 = C4301En7.i(j);
        if (i3 >= i) {
            i = i3;
        }
        if (i <= i2) {
            i2 = i;
        }
        return (iN == C4301En7.n(j) && i2 == C4301En7.i(j)) ? j : b(iN, i2);
    }

    private static final long d(int i, int i2) {
        if (!(i >= 0 && i2 >= 0)) {
            N73.a("start and end cannot be negative. [start: " + i + ", end: " + i2 + ']');
        }
        return (i2 & 4294967295L) | (i << 32);
    }

    public static final String e(CharSequence charSequence, long j) {
        return charSequence.subSequence(C4301En7.l(j), C4301En7.k(j)).toString();
    }
}
