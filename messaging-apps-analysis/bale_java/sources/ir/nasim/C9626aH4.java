package ir.nasim;

/* renamed from: ir.nasim.aH4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9626aH4 implements InterfaceC15247jG {
    private final InterfaceC15247jG a;
    private final int b;
    private int c;

    public C9626aH4(InterfaceC15247jG interfaceC15247jG, int i) {
        this.a = interfaceC15247jG;
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void a(int i, int i2) {
        this.a.a(i + (this.c == 0 ? this.b : 0), i2);
    }

    @Override // ir.nasim.InterfaceC15247jG
    public Object b() {
        return this.a.b();
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void c(int i, int i2, int i3) {
        int i4 = this.c == 0 ? this.b : 0;
        this.a.c(i + i4, i2 + i4, i3);
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void clear() {
        AbstractC5138Ib1.s("Clear is not valid on OffsetApplier");
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void d(int i, Object obj) {
        this.a.d(i + (this.c == 0 ? this.b : 0), obj);
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void f(int i, Object obj) {
        this.a.f(i + (this.c == 0 ? this.b : 0), obj);
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void g(Object obj) {
        this.c++;
        this.a.g(obj);
    }

    @Override // ir.nasim.InterfaceC15247jG
    public void k() {
        if (!(this.c > 0)) {
            AbstractC5138Ib1.s("OffsetApplier up called with no corresponding down");
        }
        this.c--;
        this.a.k();
    }
}
