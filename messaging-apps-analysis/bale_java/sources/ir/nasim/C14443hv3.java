package ir.nasim;

/* renamed from: ir.nasim.hv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14443hv3 implements InterfaceC16242kw3 {
    private final C6021Lv3 a;

    public C14443hv3(C6021Lv3 c6021Lv3) {
        this.a = c6021Lv3;
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int a() {
        return this.a.u().g();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int b() {
        if (this.a.u().i().isEmpty()) {
            return 0;
        }
        return AbstractC23053wG5.e(AbstractC5320Iv3.a(this.a.u()) / AbstractC22255uv3.a(this.a.u()), 1);
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public boolean c() {
        return !this.a.u().i().isEmpty();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int d() {
        return this.a.p();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int e() {
        return ((InterfaceC16823lv3) AbstractC15401jX0.C0(this.a.u().i())).getIndex();
    }
}
