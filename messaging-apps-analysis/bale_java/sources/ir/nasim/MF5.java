package ir.nasim;

/* loaded from: classes.dex */
public final class MF5 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    public /* synthetic */ MF5(long j, long j2, long j3, long j4, ED1 ed1) {
        this(j, j2, j3, j4);
    }

    public final MF5 a(long j, long j2, long j3, long j4) {
        return new MF5(j != 16 ? j : this.a, j2 != 16 ? j2 : this.b, j3 != 16 ? j3 : this.c, j4 != 16 ? j4 : this.d, null);
    }

    public final InterfaceC9664aL6 b(boolean z, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC9664aL6 interfaceC9664aL6Q;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1840145292, i, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:228)");
        }
        long j = (z && z2) ? this.a : (!z || z2) ? (z || !z2) ? this.d : this.c : this.b;
        if (z) {
            interfaceC22053ub1.W(350067971);
            interfaceC9664aL6Q = BD6.a(j, AbstractC5999Lt.l(100, 0, null, 6, null), null, null, interfaceC22053ub1, 48, 12);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(350170674);
            interfaceC9664aL6Q = AbstractC10222bH6.q(C24381yX0.k(j), interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6Q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MF5)) {
            return false;
        }
        MF5 mf5 = (MF5) obj;
        return C24381yX0.q(this.a, mf5.a) && C24381yX0.q(this.b, mf5.b) && C24381yX0.q(this.c, mf5.c) && C24381yX0.q(this.d, mf5.d);
    }

    public int hashCode() {
        return (((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d);
    }

    private MF5(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }
}
