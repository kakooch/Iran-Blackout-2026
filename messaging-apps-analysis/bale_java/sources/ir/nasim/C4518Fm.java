package ir.nasim;

/* renamed from: ir.nasim.Fm, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4518Fm extends AbstractC22597vW1 {
    private final EnumC8893Xt7 a;
    private final String b;
    private final long c;
    private final long d;
    private final C4309Eo6 e;
    private float f;
    private long g;
    private boolean h;

    public C4518Fm(EnumC8893Xt7 enumC8893Xt7, String str, long j, long j2) {
        AbstractC13042fc3.i(enumC8893Xt7, "origin");
        AbstractC13042fc3.i(str, "mimeType");
        this.a = enumC8893Xt7;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = ((InterfaceC8627Wt7) C92.a(C5721Ko.a.d(), InterfaceC8627Wt7.class)).S();
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        super.d(interfaceC3346Am2);
        if (this.h) {
            this.e.a(this.g * 1024, this.a, this.c, this.d, this.b);
            this.h = false;
        }
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        super.q(f, f2);
        this.h = true;
        this.g = (long) f2;
        if (f - this.f > 0.1d) {
            this.f = f;
        }
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
    }
}
