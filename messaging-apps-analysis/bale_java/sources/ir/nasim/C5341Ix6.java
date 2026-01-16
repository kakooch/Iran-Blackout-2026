package ir.nasim;

/* renamed from: ir.nasim.Ix6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5341Ix6 {
    private final AbstractC8333Vn1 a;
    private final AbstractC8333Vn1 b;
    private final AbstractC8333Vn1 c;

    public C5341Ix6(AbstractC8333Vn1 abstractC8333Vn1, AbstractC8333Vn1 abstractC8333Vn12, AbstractC8333Vn1 abstractC8333Vn13) {
        this.a = abstractC8333Vn1;
        this.b = abstractC8333Vn12;
        this.c = abstractC8333Vn13;
    }

    public static /* synthetic */ C5341Ix6 b(C5341Ix6 c5341Ix6, AbstractC8333Vn1 abstractC8333Vn1, AbstractC8333Vn1 abstractC8333Vn12, AbstractC8333Vn1 abstractC8333Vn13, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC8333Vn1 = c5341Ix6.a;
        }
        if ((i & 2) != 0) {
            abstractC8333Vn12 = c5341Ix6.b;
        }
        if ((i & 4) != 0) {
            abstractC8333Vn13 = c5341Ix6.c;
        }
        return c5341Ix6.a(abstractC8333Vn1, abstractC8333Vn12, abstractC8333Vn13);
    }

    public final C5341Ix6 a(AbstractC8333Vn1 abstractC8333Vn1, AbstractC8333Vn1 abstractC8333Vn12, AbstractC8333Vn1 abstractC8333Vn13) {
        return new C5341Ix6(abstractC8333Vn1, abstractC8333Vn12, abstractC8333Vn13);
    }

    public final AbstractC8333Vn1 c() {
        return this.c;
    }

    public final AbstractC8333Vn1 d() {
        return this.b;
    }

    public final AbstractC8333Vn1 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5341Ix6)) {
            return false;
        }
        C5341Ix6 c5341Ix6 = (C5341Ix6) obj;
        return AbstractC13042fc3.d(this.a, c5341Ix6.a) && AbstractC13042fc3.d(this.b, c5341Ix6.b) && AbstractC13042fc3.d(this.c, c5341Ix6.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Shapes(small=" + this.a + ", medium=" + this.b + ", large=" + this.c + ')';
    }

    public /* synthetic */ C5341Ix6(AbstractC8333Vn1 abstractC8333Vn1, AbstractC8333Vn1 abstractC8333Vn12, AbstractC8333Vn1 abstractC8333Vn13, int i, ED1 ed1) {
        this((i & 1) != 0 ? N46.d(C17784nZ1.q(4)) : abstractC8333Vn1, (i & 2) != 0 ? N46.d(C17784nZ1.q(4)) : abstractC8333Vn12, (i & 4) != 0 ? N46.d(C17784nZ1.q(0)) : abstractC8333Vn13);
    }
}
