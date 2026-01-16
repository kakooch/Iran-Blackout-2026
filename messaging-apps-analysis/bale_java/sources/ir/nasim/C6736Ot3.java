package ir.nasim;

/* renamed from: ir.nasim.Ot3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6736Ot3 implements YM5 {
    private final InterfaceC14603iB2 a;
    private final InterfaceC20315ro1 b;
    private InterfaceC13730gj3 c;

    public C6736Ot3(InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = interfaceC14603iB2;
        this.b = AbstractC20906so1.a(interfaceC11938do1);
    }

    @Override // ir.nasim.YM5
    public void b() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 != null) {
            AbstractC20267rj3.f(interfaceC13730gj3, "Old job was still running!", null, 2, null);
        }
        this.c = AbstractC10533bm0.d(this.b, null, null, this.a, 3, null);
    }

    @Override // ir.nasim.YM5
    public void d() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 != null) {
            interfaceC13730gj3.g(new C20415ry3());
        }
        this.c = null;
    }

    @Override // ir.nasim.YM5
    public void e() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 != null) {
            interfaceC13730gj3.g(new C20415ry3());
        }
        this.c = null;
    }
}
