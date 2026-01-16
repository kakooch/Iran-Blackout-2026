package ir.nasim;

/* renamed from: ir.nasim.qB7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C19347qB7 implements A98 {
    private final A98 b;
    private final A98 c;

    public C19347qB7(A98 a98, A98 a982) {
        this.b = a98;
        this.c = a982;
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return Math.max(this.b.a(wh1), this.c.a(wh1));
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return Math.max(this.b.b(wh1, enumC12613eu3), this.c.b(wh1, enumC12613eu3));
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return Math.max(this.b.c(wh1), this.c.c(wh1));
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return Math.max(this.b.d(wh1, enumC12613eu3), this.c.d(wh1, enumC12613eu3));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19347qB7)) {
            return false;
        }
        C19347qB7 c19347qB7 = (C19347qB7) obj;
        return AbstractC13042fc3.d(c19347qB7.b, this.b) && AbstractC13042fc3.d(c19347qB7.c, this.c);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.c.hashCode() * 31);
    }

    public String toString() {
        return '(' + this.b + " ∪ " + this.c + ')';
    }
}
