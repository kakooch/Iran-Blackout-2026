package ir.nasim;

/* renamed from: ir.nasim.hT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14169hT4 implements InterfaceC16242kw3 {
    private final GT4 a;
    private final int b;

    public C14169hT4(GT4 gt4, int i) {
        this.a = gt4;
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int a() {
        return this.a.H();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int b() {
        if (this.a.C().i().size() == 0) {
            return 0;
        }
        return AbstractC23053wG5.e(AbstractC18324oT4.a(this.a.C()) / (this.a.C().h() + this.a.C().l()), 1);
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public boolean c() {
        return !this.a.C().i().isEmpty();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int d() {
        return Math.max(0, this.a.y() - this.b);
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int e() {
        return Math.min(a() - 1, ((InterfaceC9734aT4) AbstractC15401jX0.C0(this.a.C().i())).getIndex() + this.b);
    }
}
