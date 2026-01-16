package ir.nasim;

/* renamed from: ir.nasim.pn6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19110pn6 {
    private final InterfaceC9336Zm4 a;
    private final InterfaceC4557Fq2 b;

    public C19110pn6() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        this.a = interfaceC9336Zm4A;
        this.b = AbstractC6459Nq2.F(interfaceC9336Zm4A);
    }

    public final InterfaceC4557Fq2 a() {
        return this.b;
    }

    public final void b(int i) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i)));
    }
}
