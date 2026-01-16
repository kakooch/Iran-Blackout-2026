package ir.nasim;

/* renamed from: ir.nasim.yz3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24657yz3 implements A98 {
    private final A98 b;
    private final int c;

    public /* synthetic */ C24657yz3(A98 a98, int i, ED1 ed1) {
        this(a98, i);
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        if (AbstractC23236wa8.j(this.c, AbstractC23236wa8.a.g())) {
            return this.b.a(wh1);
        }
        return 0;
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        if (AbstractC23236wa8.j(this.c, enumC12613eu3 == EnumC12613eu3.a ? AbstractC23236wa8.a.a() : AbstractC23236wa8.a.b())) {
            return this.b.b(wh1, enumC12613eu3);
        }
        return 0;
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        if (AbstractC23236wa8.j(this.c, AbstractC23236wa8.a.e())) {
            return this.b.c(wh1);
        }
        return 0;
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        if (AbstractC23236wa8.j(this.c, enumC12613eu3 == EnumC12613eu3.a ? AbstractC23236wa8.a.c() : AbstractC23236wa8.a.d())) {
            return this.b.d(wh1, enumC12613eu3);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24657yz3)) {
            return false;
        }
        C24657yz3 c24657yz3 = (C24657yz3) obj;
        return AbstractC13042fc3.d(this.b, c24657yz3.b) && AbstractC23236wa8.i(this.c, c24657yz3.c);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + AbstractC23236wa8.k(this.c);
    }

    public String toString() {
        return '(' + this.b + " only " + ((Object) AbstractC23236wa8.m(this.c)) + ')';
    }

    private C24657yz3(A98 a98, int i) {
        this.b = a98;
        this.c = i;
    }
}
