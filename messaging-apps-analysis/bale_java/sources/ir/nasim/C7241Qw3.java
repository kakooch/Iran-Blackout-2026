package ir.nasim;

/* renamed from: ir.nasim.Qw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7241Qw3 implements InterfaceC16242kw3 {
    private final C19206px3 a;
    private final int b;

    public C7241Qw3(C19206px3 c19206px3, int i) {
        this.a = c19206px3;
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int a() {
        return this.a.x().g();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int b() {
        if (this.a.x().i().isEmpty()) {
            return 0;
        }
        return AbstractC23053wG5.e(AbstractC17433mx3.c(this.a.x()) / AbstractC10028ax3.a(this.a.x()), 1);
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public boolean c() {
        return !this.a.x().i().isEmpty();
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int d() {
        return Math.max(0, this.a.s() - this.b);
    }

    @Override // ir.nasim.InterfaceC16242kw3
    public int e() {
        return Math.min(a() - 1, ((InterfaceC7948Tw3) AbstractC15401jX0.C0(this.a.x().i())).getIndex() + this.b);
    }
}
