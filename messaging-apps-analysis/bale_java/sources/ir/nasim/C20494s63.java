package ir.nasim;

/* renamed from: ir.nasim.s63, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20494s63 implements InterfaceC5766Kt {
    public static final int d = 8;
    private final R12 a;
    private final EO5 b;
    private final long c;

    public /* synthetic */ C20494s63(R12 r12, EO5 eo5, long j, ED1 ed1) {
        this(r12, eo5, j);
    }

    @Override // ir.nasim.InterfaceC5766Kt
    public ZQ7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new C13563gR7(this.a.a(interfaceC5342Ix7), this.b, this.c, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C20494s63)) {
            return false;
        }
        C20494s63 c20494s63 = (C20494s63) obj;
        return AbstractC13042fc3.d(c20494s63.a, this.a) && c20494s63.b == this.b && AbstractC10865cK6.d(c20494s63.c, this.c);
    }

    public final R12 f() {
        return this.a;
    }

    public final EO5 g() {
        return this.b;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + AbstractC10865cK6.e(this.c);
    }

    private C20494s63(R12 r12, EO5 eo5, long j) {
        this.a = r12;
        this.b = eo5;
        this.c = j;
    }
}
