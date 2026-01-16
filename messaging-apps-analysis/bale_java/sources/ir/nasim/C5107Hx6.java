package ir.nasim;

/* renamed from: ir.nasim.Hx6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5107Hx6 {
    private final AbstractC8333Vn1 a;
    private final AbstractC8333Vn1 b;
    private final AbstractC8333Vn1 c;
    private final AbstractC8333Vn1 d;
    private final AbstractC8333Vn1 e;

    public C5107Hx6(AbstractC8333Vn1 abstractC8333Vn1, AbstractC8333Vn1 abstractC8333Vn12, AbstractC8333Vn1 abstractC8333Vn13, AbstractC8333Vn1 abstractC8333Vn14, AbstractC8333Vn1 abstractC8333Vn15) {
        this.a = abstractC8333Vn1;
        this.b = abstractC8333Vn12;
        this.c = abstractC8333Vn13;
        this.d = abstractC8333Vn14;
        this.e = abstractC8333Vn15;
    }

    public final AbstractC8333Vn1 a() {
        return this.e;
    }

    public final AbstractC8333Vn1 b() {
        return this.a;
    }

    public final AbstractC8333Vn1 c() {
        return this.d;
    }

    public final AbstractC8333Vn1 d() {
        return this.c;
    }

    public final AbstractC8333Vn1 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5107Hx6)) {
            return false;
        }
        C5107Hx6 c5107Hx6 = (C5107Hx6) obj;
        return AbstractC13042fc3.d(this.a, c5107Hx6.a) && AbstractC13042fc3.d(this.b, c5107Hx6.b) && AbstractC13042fc3.d(this.c, c5107Hx6.c) && AbstractC13042fc3.d(this.d, c5107Hx6.d) && AbstractC13042fc3.d(this.e, c5107Hx6.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.a + ", small=" + this.b + ", medium=" + this.c + ", large=" + this.d + ", extraLarge=" + this.e + ')';
    }

    public /* synthetic */ C5107Hx6(AbstractC8333Vn1 abstractC8333Vn1, AbstractC8333Vn1 abstractC8333Vn12, AbstractC8333Vn1 abstractC8333Vn13, AbstractC8333Vn1 abstractC8333Vn14, AbstractC8333Vn1 abstractC8333Vn15, int i, ED1 ed1) {
        this((i & 1) != 0 ? C15663jx6.a.b() : abstractC8333Vn1, (i & 2) != 0 ? C15663jx6.a.e() : abstractC8333Vn12, (i & 4) != 0 ? C15663jx6.a.d() : abstractC8333Vn13, (i & 8) != 0 ? C15663jx6.a.c() : abstractC8333Vn14, (i & 16) != 0 ? C15663jx6.a.a() : abstractC8333Vn15);
    }
}
