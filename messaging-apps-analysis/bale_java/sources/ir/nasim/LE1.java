package ir.nasim;

/* loaded from: classes.dex */
final class LE1 implements NF5 {
    private final long a;
    private final long b;
    private final long c;

    public /* synthetic */ LE1(long j, long j2, long j3, ED1 ed1) {
        this(j, j2, j3);
    }

    @Override // ir.nasim.NF5
    public InterfaceC9664aL6 a(boolean z, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC9664aL6 interfaceC9664aL6Q;
        interfaceC22053ub1.W(1243421834);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1243421834, i, -1, "androidx.compose.material.DefaultRadioButtonColors.radioColor (RadioButton.kt:177)");
        }
        long j = !z ? this.c : !z2 ? this.b : this.a;
        if (z) {
            interfaceC22053ub1.W(1872435883);
            interfaceC9664aL6Q = BD6.a(j, AbstractC5999Lt.l(100, 0, null, 6, null), null, null, interfaceC22053ub1, 48, 12);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1872538586);
            interfaceC9664aL6Q = AbstractC10222bH6.q(C24381yX0.k(j), interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return interfaceC9664aL6Q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LE1.class != obj.getClass()) {
            return false;
        }
        LE1 le1 = (LE1) obj;
        return C24381yX0.q(this.a, le1.a) && C24381yX0.q(this.b, le1.b) && C24381yX0.q(this.c, le1.c);
    }

    public int hashCode() {
        return (((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c);
    }

    private LE1(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }
}
