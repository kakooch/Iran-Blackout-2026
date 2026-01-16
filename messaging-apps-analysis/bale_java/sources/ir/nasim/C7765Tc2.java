package ir.nasim;

/* renamed from: ir.nasim.Tc2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C7765Tc2 implements A98 {
    private final A98 b;
    private final A98 c;

    public C7765Tc2(A98 a98, A98 a982) {
        this.b = a98;
        this.c = a982;
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return AbstractC23053wG5.e(this.b.a(wh1) - this.c.a(wh1), 0);
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return AbstractC23053wG5.e(this.b.b(wh1, enumC12613eu3) - this.c.b(wh1, enumC12613eu3), 0);
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return AbstractC23053wG5.e(this.b.c(wh1) - this.c.c(wh1), 0);
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return AbstractC23053wG5.e(this.b.d(wh1, enumC12613eu3) - this.c.d(wh1, enumC12613eu3), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7765Tc2)) {
            return false;
        }
        C7765Tc2 c7765Tc2 = (C7765Tc2) obj;
        return AbstractC13042fc3.d(c7765Tc2.b, this.b) && AbstractC13042fc3.d(c7765Tc2.c, this.c);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return '(' + this.b + " - " + this.c + ')';
    }
}
