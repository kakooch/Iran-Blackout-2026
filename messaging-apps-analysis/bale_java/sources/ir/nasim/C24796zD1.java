package ir.nasim;

/* renamed from: ir.nasim.zD1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24796zD1 implements InterfaceC6180Mn0 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    public /* synthetic */ C24796zD1(long j, long j2, long j3, long j4, ED1 ed1) {
        this(j, j2, j3, j4);
    }

    @Override // ir.nasim.InterfaceC6180Mn0
    public InterfaceC9664aL6 a(boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-655254499);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-655254499, i, -1, "androidx.compose.material.DefaultButtonColors.backgroundColor (Button.kt:584)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(C24381yX0.k(z ? this.a : this.c), interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return interfaceC9664aL6Q;
    }

    @Override // ir.nasim.InterfaceC6180Mn0
    public InterfaceC9664aL6 b(boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-2133647540);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-2133647540, i, -1, "androidx.compose.material.DefaultButtonColors.contentColor (Button.kt:589)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(C24381yX0.k(z ? this.b : this.d), interfaceC22053ub1, 0);
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
        if (obj == null || C24796zD1.class != obj.getClass()) {
            return false;
        }
        C24796zD1 c24796zD1 = (C24796zD1) obj;
        return C24381yX0.q(this.a, c24796zD1.a) && C24381yX0.q(this.b, c24796zD1.b) && C24381yX0.q(this.c, c24796zD1.c) && C24381yX0.q(this.d, c24796zD1.d);
    }

    public int hashCode() {
        return (((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d);
    }

    private C24796zD1(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }
}
