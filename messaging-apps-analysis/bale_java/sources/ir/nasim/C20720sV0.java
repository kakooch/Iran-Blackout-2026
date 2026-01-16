package ir.nasim;

/* renamed from: ir.nasim.sV0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C20720sV0 {
    private final InterfaceC18354oW7 a;
    private int b;
    private C6616Og5 c;

    public C20720sV0(InterfaceC18354oW7 interfaceC18354oW7) {
        this.a = interfaceC18354oW7;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b(C6616Og5 c6616Og5, C6616Og5 c6616Og52) {
        return AbstractC25138zn6.f(this.a, c6616Og5, c6616Og52);
    }

    public final boolean c(C6616Og5 c6616Og5, C6616Og5 c6616Og52) {
        return c6616Og52.o() - c6616Og5.o() < this.a.a();
    }

    public final void d(C3534Bg5 c3534Bg5) {
        C6616Og5 c6616Og5 = this.c;
        C6616Og5 c6616Og52 = (C6616Og5) c3534Bg5.c().get(0);
        if (c6616Og5 != null && c(c6616Og5, c6616Og52) && b(c6616Og5, c6616Og52)) {
            this.b++;
        } else {
            this.b = 1;
        }
        this.c = c6616Og52;
    }
}
